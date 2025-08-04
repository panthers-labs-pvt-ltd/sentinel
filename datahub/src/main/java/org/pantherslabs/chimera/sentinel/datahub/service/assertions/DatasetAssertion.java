package org.pantherslabs.chimera.sentinel.datahub.service.assertions;

import com.datahub.util.RecordUtils;
import com.linkedin.assertion.*;
import com.linkedin.common.AuditStamp;
import com.linkedin.common.FabricType;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.DataPlatformUrn;
import com.linkedin.common.urn.DatasetUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringMap;
import com.linkedin.incident.IncidentType;
import com.linkedin.mxe.MetadataChangeProposal;
import lombok.SneakyThrows;
import org.pantherslabs.chimera.sentinel.datahub.commons.AspectsMetadata;
import org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.model.generated.LatestMetadataAspectV2;
import org.pantherslabs.chimera.sentinel.datahub.service.incidentService;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ResponseWrapper;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.*;
import static org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils.DataAssertionsUtils.*;

@Service
public class DatasetAssertion {
    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(VolumeAssertion.class);
    static List<MetadataChangeProposal> proposals = new ArrayList<>();
    static EmitResult result = null;

    @SneakyThrows
    public void create(String dataPlatform, String datasetName, String fabricType,
                       String businessDate, List<String> columnList, String AssertionScope,
                       String AggregationRule, String operator, Map<String, String> params) throws Exception {

        DataPlatformUrn dataPlatformUrn = new DataPlatformUrn(dataPlatform);

        if (!isValid(fabricType)) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + fabricType +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }
        DatasetUrn datasetUrn = new DatasetUrn(dataPlatformUrn, datasetName, FabricType.valueOf(fabricType));
        commonsFunctions.DataControlKey dataset = parseDatasetName(datasetName);

        String assertionName = String.format("%sdataset_%s_%s.%s_%s", ASSERTION_URN_PREFIX, dataset.databaseName(),
                dataset.tableName(), "dataset", fabricType);

        if (!isValid(DatasetAssertionScope.class, AssertionScope.toUpperCase())) {
            throw new IllegalArgumentException("❌ Invalid Assertion Scope: " + AssertionScope +
                    ". Allowed values: " + Arrays.toString(DatasetAssertionScope.values()));
        }


        if (!isValid(AssertionStdAggregation.class, AggregationRule.toUpperCase())) {
            throw new IllegalArgumentException("❌ Invalid Aggregation Rule: " + AggregationRule +
                    ". Allowed values: " + Arrays.toString(AssertionStdAggregation.values()));
        }

        if (!isValid(AssertionStdOperator.class, operator.toUpperCase())) {
            throw new IllegalArgumentException("❌ Invalid Operator: " + operator +
                    ". Allowed values: " + Arrays.toString(AssertionStdOperator.values()));
        }

        DatasetAssertionInfo datasetAssertionInfo = buildDatasetAssertionInfo(
                datasetUrn,
                getFieldUrns(columnList, datasetUrn.toString()),
                DatasetAssertionScope.valueOf(AssertionScope.toUpperCase(Locale.ROOT)),
                AssertionStdAggregation.valueOf(AggregationRule.toUpperCase(Locale.ROOT)),
                AssertionStdOperator.valueOf(operator.toUpperCase(Locale.ROOT)),
                params
        );

        AssertionInfo assertionInfo = new AssertionInfo()
                .setDatasetAssertion(datasetAssertionInfo)
                .setType(AssertionType.DATASET)
                .setDescription("Dataset Assertions")
                .setLastUpdated(new AuditStamp()
                        .setActor(new CorpuserUrn(SYSTEM_ACTOR))
                        .setTime(Instant.now().toEpochMilli()))
                .setSource(new AssertionSource().setType(AssertionSourceType.NATIVE));

        proposals.add(buildProposal(Urn.createFromString(assertionName), ASSERTION_INFO_ASPECT_NAME,
                assertionInfo, "CREATE"));
        result = emitEvent(proposals);
    }

    public void run(String dataPlatform, String datasetName, String fabricType,
                    int actualValue, String businessDate) throws Exception {

        DataPlatformUrn dataPlatformUrn = new DataPlatformUrn(dataPlatform);
        if (!isValid(fabricType)) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + fabricType +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }

        DatasetUrn datasetUrn = new DatasetUrn(dataPlatformUrn, datasetName, FabricType.valueOf(fabricType));
        DataControlKey dataset = parseDatasetName(datasetName);
        String assertionName = String.format("%sdataset_%s_%s.%s_%s", ASSERTION_URN_PREFIX, dataset.databaseName(),
                dataset.tableName(), "dataset", fabricType);
        Urn assertionUrn = Urn.createFromString(assertionName);
        StringMap nativeResult = new StringMap();
        AssertionResult assertionResult = new AssertionResult();
        AssertionAction assertionAction = new AssertionAction();
        AssertionRunEvent runEvent = new AssertionRunEvent();

        ResponseWrapper<List<LatestMetadataAspectV2>, ErrorResponse> response =
                AspectsMetadata.get(assertionUrn.toString(), ASSERTION_INFO_ASPECT_NAME);

        if (response == null || !response.isSuccess() || response.getSuccessBody() == null) {
            throw new IllegalArgumentException("No Assertion Found for entity: " + datasetUrn);
        }

        // Step 2: Extract Schema aspect from the list of aspects
        LatestMetadataAspectV2 schemaMetadataAspect = response.getSuccessBody().stream()
                .filter(aspect -> ASSERTION_INFO_ASPECT_NAME.equals(aspect.getAspect()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Metadata aspect not found for entity: " + datasetUrn));

        DatasetAssertionInfo existingSchema = RecordUtils.toRecordTemplate(DatasetAssertionInfo.class, schemaMetadataAspect.getMetadata());
        long expectedValue = 0;
        String operator = "";
        Object assertionObj = existingSchema.data().get("datasetAssertion");
        if (assertionObj instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> assertionMap = (Map<String, Object>) assertionObj;
            Object nativeParamsObj = assertionMap.get("nativeParameters");
            Object operatorObj = assertionMap.get("operator");

            if (nativeParamsObj instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> nativeParamsMap = (Map<String, Object>) nativeParamsObj;
                String expectedValueStr = String.valueOf(nativeParamsMap.get("value"));

                expectedValue = Long.parseLong(expectedValueStr);
                System.out.println("Expected value: " + expectedValue);
            }
            if (operatorObj instanceof String) {
                operator = (String) operatorObj;
                System.out.println("Operator: " + operator);
            }
        }
        long expected = Long.parseLong(String.valueOf(expectedValue));
        boolean compareResult = compare(actualValue, operator, expected);
        String errorDesc = "";
        if (compareResult) {
            nativeResult.put("Dataset Result", String.format("Expected Value %s is %s Actual Value %s ",
                    expected, operator, actualValue));
            assertionAction.setType(AssertionActionType.RESOLVE_INCIDENT);
            assertionResult.setType(AssertionResultType.SUCCESS);
        } else {
            errorDesc = String.format("Expected Value %s is not %s Actual Value %s ",
                    expected, operator, actualValue);
            nativeResult.put("Result", errorDesc);
            assertionResult.setType(AssertionResultType.FAILURE);
            assertionAction.setType(AssertionActionType.RAISE_INCIDENT);
            assertionResult.setError(
                    new AssertionResultError()
                            .setType(AssertionResultErrorType.FIELD_ASSERTION_ERROR));
        }

        assertionResult.setNativeResults(nativeResult);
        runEvent.setRunId(UUID.randomUUID().toString())
                .setAssertionUrn(assertionUrn)
                .setAsserteeUrn(datasetUrn)
                .setTimestampMillis(Instant.now().toEpochMilli())
                .setStatus(AssertionRunStatus.COMPLETE)
                .setResult(assertionResult);
        proposals.add(buildProposal(assertionUrn, ASSERTION_RUN_EVENT_ASPECT_NAME, runEvent, "UPSERT"));
        result = emitEvent(proposals);
        if (result.isSuccess() && assertionAction.getType().equals(AssertionActionType.RAISE_INCIDENT)) {

            String incidentType = IncidentType.DATA_SCHEMA.toString();
            String entityUrn = datasetUrn.toString();
            String incidentTitle = String.format("Data for %s, Env. %s", datasetName, fabricType);
            String incidentDesc = String.format("Data Failed for %s, Env. %s\nErrors :%s"
                    , datasetName, fabricType, errorDesc);

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
