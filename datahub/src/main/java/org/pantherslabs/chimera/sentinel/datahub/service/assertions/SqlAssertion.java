package org.pantherslabs.chimera.sentinel.datahub.service.assertions;
import java.time.Instant;
import java.util.*;

import com.linkedin.assertion.*;
import com.linkedin.common.AuditStamp;
import com.linkedin.common.FabricType;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.DataPlatformUrn;
import com.linkedin.common.urn.DatasetUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.DataMap;
import com.linkedin.data.template.StringMap;
import com.linkedin.incident.IncidentType;
import com.linkedin.mxe.MetadataChangeProposal;
import com.linkedin.timeseries.CalendarInterval;
import com.linkedin.timeseries.PartitionSpec;
import com.linkedin.timeseries.TimeWindow;
import com.linkedin.timeseries.TimeWindowSize;

import org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.service.incidentService;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.pantherslabs.chimera.sentinel.datahub.model.generated.DataControlsLog;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.*;
import static org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils.SqlAssertionUtils.*;

public class SqlAssertion {

    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(SqlAssertion.class);
    List<MetadataChangeProposal> proposals = new ArrayList<>();
    EmitResult result = null;

    public EmitResult create(String dataPlatform, String datasetName, String fabricType,
                             String businessDate) throws Exception {

        DataPlatformUrn dataPlatformUrn = new DataPlatformUrn(dataPlatform);
        if (!isValid(fabricType)) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + fabricType +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }
        DatasetUrn datasetUrn = new DatasetUrn(dataPlatformUrn, datasetName, FabricType.valueOf(fabricType));
        commonsFunctions.DataControlKey dataset = parseDatasetName(datasetName);

        List<DataControlsLog> deduplicated = getControlData(dataset.databaseName(), dataset.tableName(), businessDate);

        for (DataControlsLog row : deduplicated) {
            List<SqlAssertionInfo> assertions = generateAssertionsFromRow(row, datasetUrn.toString());
            String assertionName = String.format("%ssql_%s_%s.%s_%s", ASSERTION_URN_PREFIX, row.getDatabaseName(), row.getTableName(),
                    row.getRuleName(), row.getRuleColumn());
            Urn assertionUrn = Urn.createFromString(assertionName);
            String assertionDesc = String.format("Control Dimension : %s Rule : %s", row.getControlDimension(), row.getRuleValue());
            AssertionInfo assertionInfo = new AssertionInfo()
                    .setType(AssertionType.SQL)
                    .setSqlAssertion(assertions.get(0))
                    .setDescription(assertionDesc)
                    .setLastUpdated(new AuditStamp()
                            .setActor(new CorpuserUrn(SYSTEM_ACTOR))
                            .setTime(Instant.now().toEpochMilli()))
                    .setSource(new AssertionSource().setType(AssertionSourceType.EXTERNAL));
            proposals.add(buildProposal(assertionUrn, ASSERTION_INFO_ASPECT_NAME, assertionInfo, "CREATE"));
        }
        return emitEvent(proposals);
    }


    public void run(String dataPlatform, String datasetName, String fabricType,
                    String externalUrl, String businessDate) throws Exception {

        DataPlatformUrn dataPlatformUrn = new DataPlatformUrn(dataPlatform);
        if (!isValid(fabricType)) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + fabricType +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }

        DatasetUrn datasetUrn = new DatasetUrn(dataPlatformUrn, datasetName, FabricType.valueOf(fabricType));
        commonsFunctions.DataControlKey dataset = parseDatasetName(datasetName);
        List<DataControlsLog> deduplicated = getControlData(dataset.databaseName(), dataset.tableName(), businessDate);
        String assertionName;
        StringMap nativeResult = new StringMap();
        AssertionResult assertionResult = new AssertionResult();
        AssertionAction assertionAction = new AssertionAction();
        AssertionRunEvent runEvent = new AssertionRunEvent();

        String errorDesc = "";
        String SQL = "";
        String BatchId = "";
        for (DataControlsLog row : deduplicated) {

            assertionName = String.format("%ssql_%s_%s.%s_%s", ASSERTION_URN_PREFIX, row.getDatabaseName(),
                    row.getTableName(), row.getRuleName(), row.getRuleColumn());
            Urn assertionUrn = Urn.createFromString(assertionName);

            if (row.getStatus().equalsIgnoreCase("Failure")) {
                SQL = getAssertionSQL(assertionName);
                BatchId = row.getBatchId();
                errorDesc = String.format(
                        """     
                                📣 DATA QUALITY INCIDENT
                                * Batch ID            : %s
                                * Control Type        : %s
                                * Control Dimension   : %s
                                * Process Type        : %s
                                * Database Name       : %s
                                * Schema Name         : %s
                                * Table Name          : %s
                                * Business Date       : %s
                                * Partition Keys      : %s
                                * Rule Name           : %s
                                * Check Level         : %s
                                * Constraint Desc.    : %s
                                * Status              : %s
                                * Execution Timestamp : %s
                                * SQL Query           :`%s`
                                
                                &nbsp;""",
                        row.getBatchId(),
                        row.getControlType(),
                        row.getControlDimension(),
                        row.getProcessType(),
                        row.getDatabaseName(),
                        row.getSchemaName(),
                        row.getTableName(),
                        row.getBusinessDate(),
                        row.getPartitionKeys(),
                        row.getRuleName(),
                        row.getCheckLevel(),
                        row.getConstraintMsg(),
                        row.getStatus(),
                        row.getExecutionTs(),
                        SQL
                );
                nativeResult.put("result", row.getConstraintMsg());
                assertionAction.setType(AssertionActionType.RAISE_INCIDENT);
                assertionResult.setType(AssertionResultType.FAILURE);  //Making it Error Will populate reason
                assertionResult.setNativeResults(nativeResult);
                assertionResult.setError(
                        new AssertionResultError()
                                .setType(AssertionResultErrorType.CUSTOM_SQL_ERROR));
            } else {
                nativeResult.put("result", row.getStatus());
                assertionAction.setType(AssertionActionType.RESOLVE_INCIDENT);
                assertionResult.setType(AssertionResultType.SUCCESS);
                assertionResult.setNativeResults(nativeResult);
                assertionResult.setActualAggValue(100);   //TODO What is the uses
                assertionResult.setRowCount(200);  //TODO What is the uses
                assertionResult.setMissingCount(50);  //TODO What is the uses
                assertionResult.setUnexpectedCount(600);  //TODO What is the uses
            }

            if (externalUrl != null && !externalUrl.isEmpty())
                assertionResult.setExternalUrl(externalUrl);

            StringMap RuntimeContextMap = new StringMap();
            RuntimeContextMap.put("runtimecontext", "manish");
            RuntimeContextMap.put("runtimecontext2", "Kumar");

            DataMap dataMap = new DataMap();
            dataMap.put("unit", "DAY");
            dataMap.put("multiple", 5);
            String RunEventId=UUID.randomUUID().toString();
            runEvent
                    .setRunId(RunEventId)
                    .setAssertionUrn(assertionUrn)
                    .setAsserteeUrn(datasetUrn)
                    .setTimestampMillis(Instant.now().toEpochMilli())
                    .setStatus(AssertionRunStatus.COMPLETE)
                    .setResult(assertionResult)
                    .setMessageId("The change in row count compared to the previous run (20%) is within the accepted threshold (±30%).");

                   /* .setEventGranularity(new TimeWindowSize().setUnit(CalendarInterval.DAY).setMultiple(5))
                    .setBatchSpec(new BatchSpec().setNativeBatchId(BatchId).setQuery(SQL).setCustomProperties(nativeResult).setLimit(10)) //nativeResult is mapped foe test
                    .setPartitionSpec(
                            new PartitionSpec()
                                    .setPartition("mypartitions=2020-22-21")
                                    .setTimePartition( new TimeWindow()
                                            .setLength(new TimeWindowSize(dataMap))
                                            .setStartTimeMillis(System.currentTimeMillis()))
                    )
                    .setRuntimeContext(RuntimeContextMap);*/

            proposals.add(buildProposal(assertionUrn, ASSERTION_RUN_EVENT_ASPECT_NAME, runEvent, "UPSERT"));
            result = emitEvent(proposals);
            System.out.println("RUn ID :" + RunEventId + ":ERR " +result.getErrorDetails());

            if (assertionAction.getType().equals(AssertionActionType.RAISE_INCIDENT)) {

                String incidentType = IncidentType.SQL.toString();
                String entityUrn = datasetUrn.toString();
                String incidentTitle = String.format("DataQuality Failed for %s - %s For Env. %s", row.getControlDimension(),
                        row.getRuleValue(), fabricType);
                String incidentDesc = String.format("%s\nErrors :%s", incidentTitle, errorDesc);
                EmitResult incidentCreationStatus = incidentService.createIncident(incidentType, entityUrn,
                        incidentTitle, incidentDesc);
                if (incidentCreationStatus.isSuccess())
                    DatahubLogger.logInfo("Incident Created");
                else
                    DatahubLogger.logError("Incident Creation Failed With Error "
                            + incidentCreationStatus.getErrorDetails());
            }
        }
    }
}