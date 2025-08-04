package org.pantherslabs.chimera.sentinel.datahub.service.assertions;

import com.linkedin.assertion.*;
import com.linkedin.common.AuditStamp;
import com.linkedin.common.FabricType;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.DataPlatformUrn;
import com.linkedin.common.urn.DatasetUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringMap;
import com.linkedin.dataset.DatasetFilter;
import com.linkedin.dataset.DatasetFilterType;
import com.linkedin.incident.IncidentType;
import com.linkedin.mxe.MetadataChangeProposal;
import com.linkedin.schema.SchemaFieldSpec;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.service.incidentService;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;

import java.time.Instant;
import java.util.*;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.*;

public class VolumeAssertion {
    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(VolumeAssertion.class);
    List<MetadataChangeProposal> proposals = new ArrayList<>();
    EmitResult result = null;

   public void create(String dataPlatform, String datasetName, String fabricType,
                       String fieldPath,String fieldType,String nativeType,String valueChangeType,
                       String volumeAssertionTyp, String operatorType,Map<String, String> stdParams
                       ) throws Exception {

        DataPlatformUrn dataPlatformUrn = new DataPlatformUrn(dataPlatform);

        if (!isValid(fabricType)) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + fabricType +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }
        DatasetUrn datasetUrn = new DatasetUrn(dataPlatformUrn, datasetName, FabricType.valueOf(fabricType));
        DataControlKey dataset = parseDatasetName(datasetName);
       String assertionName = String.format("%svolume_%s_%s_%s.%s_%s", ASSERTION_URN_PREFIX,volumeAssertionTyp,
               dataset.databaseName(),dataset.tableName(), "dataset", fabricType);

        if (!isValid(VolumeAssertionType.class, volumeAssertionTyp.toUpperCase())) {
            throw new IllegalArgumentException("❌ Invalid VolumeAssertionType: " + volumeAssertionTyp +
                    ". Allowed values: " + Arrays.toString(VolumeAssertionType.values()));
        }

        if (!isValid(AssertionStdOperator.class, operatorType.toUpperCase())) {
            throw new IllegalArgumentException("❌ Invalid Operator Type: " + operatorType +
                    ". Allowed values: " + Arrays.toString(AssertionStdOperator.values()));
        }

        VolumeAssertionInfo volumeAssertionInfo = new VolumeAssertionInfo();
        String typeUpper = volumeAssertionTyp.toUpperCase(Locale.ROOT);
        String description = "";

       AssertionStdParameters assertionStdParameters = new AssertionStdParameters();

       if (stdParams != null) {
           if (stdParams.containsKey("min")) {
               assertionStdParameters.setMinValue(
                       new AssertionStdParameter()
                               .setValue(stdParams.get("min"))
                               .setType(AssertionStdParameterType.NUMBER)
               );
               description = "Ensures the change in row count between runs stays within acceptable bounds.";

           }
           if (stdParams.containsKey("max")) {
               assertionStdParameters.setMaxValue(
                       new AssertionStdParameter()
                               .setValue(stdParams.get("max"))
                               .setType(AssertionStdParameterType.NUMBER)
               );
           }
           if (stdParams.containsKey("value")) {
               assertionStdParameters.setValue(
                       new AssertionStdParameter()
                               .setValue(stdParams.get("value"))
                               .setType(AssertionStdParameterType.STRING)
               );
           }
       }

       SchemaFieldSpec schemaFieldSpec = new SchemaFieldSpec()
               .setType(fieldType)
               .setNativeType(nativeType)
               .setPath(fieldPath);

        switch (typeUpper) {
            case "ROW_COUNT_TOTAL" -> {
                    volumeAssertionInfo.setRowCountTotal(
                        new RowCountTotal()
                                .setParameters(assertionStdParameters)
                                .setOperator(AssertionStdOperator.valueOf(operatorType.toUpperCase(Locale.ROOT)))

                );
                description = "Validates that the total row count meets the specified criteria.";
            }

            case "ROW_COUNT_CHANGE" -> {
                volumeAssertionInfo.setRowCountChange(new RowCountChange()
                        .setType(AssertionValueChangeType.valueOf(valueChangeType.toUpperCase(Locale.ROOT)))
                        .setOperator(AssertionStdOperator.valueOf(operatorType.toUpperCase(Locale.ROOT)))
                        .setParameters(assertionStdParameters));
            }

            case "INCREMENTING_SEGMENT_ROW_COUNT_TOTAL" -> {
                volumeAssertionInfo.setIncrementingSegmentRowCountChange(
                        new IncrementingSegmentRowCountChange()
                                .setSegment(
                                        new IncrementingSegmentSpec()
                                                .setField(schemaFieldSpec)
                                                .setTransformer(
                                                        new IncrementingSegmentFieldTransformer()
                                                                .setNativeType(nativeType)
                                                                .setType(IncrementingSegmentFieldTransformerType.NATIVE)
                                                )
                                )
                                .setParameters(assertionStdParameters)
                                .setOperator(AssertionStdOperator.valueOf(operatorType.toUpperCase(Locale.ROOT)))
                                .setType(AssertionValueChangeType.valueOf(valueChangeType.toUpperCase(Locale.ROOT)))
                )
                ;
                description = "Checks the total row count across incrementing segments.";
            }

            case "INCREMENTING_SEGMENT_ROW_COUNT_CHANGE" -> {


                volumeAssertionInfo.setIncrementingSegmentRowCountTotal(
                        new IncrementingSegmentRowCountTotal()
                                .setParameters(assertionStdParameters)
                                .setOperator(AssertionStdOperator.valueOf(operatorType.toUpperCase(Locale.ROOT)))
                                .setSegment(
                                        new IncrementingSegmentSpec()
                                                .setField(schemaFieldSpec)
                                                .setTransformer(
                                                        new IncrementingSegmentFieldTransformer()
                                                                .setNativeType(nativeType)
                                                                .setType(IncrementingSegmentFieldTransformerType.NATIVE)
                                                )
                                )
                );
                description = "Validates the change in row count across segments defined by an incrementing field.";
            }

            default -> throw new IllegalArgumentException("Unsupported VolumeAssertionType: " + volumeAssertionTyp);
        }

        volumeAssertionInfo
                .setType(VolumeAssertionType.valueOf(volumeAssertionTyp.toUpperCase()))
                .setEntity(datasetUrn)
                .setFilter(new DatasetFilter().setType(DatasetFilterType.SQL));

        AssertionInfo assertionInfo = new AssertionInfo()
                .setVolumeAssertion(volumeAssertionInfo)
                .setType(AssertionType.VOLUME)
                .setDescription(description)
                .setLastUpdated(new AuditStamp()
                        .setActor(new CorpuserUrn(SYSTEM_ACTOR))
                        .setTime(Instant.now().toEpochMilli()))
                .setSource(new AssertionSource().setType(AssertionSourceType.NATIVE));

        proposals.add(buildProposal(Urn.createFromString(assertionName), ASSERTION_INFO_ASPECT_NAME,
                assertionInfo, "CREATE"));
        result = emitEvent(proposals);
    }
    public void run(String dataPlatform, String datasetName, String fabricType,
                    String externalUrl, String businessDate,
                    String assertionType, String operatorType, String valueChangeType,
                    Map<String, String> stdParams,
                    long currentRowCount, long previousRowCount,
                    long currentSegmentRowCount, long previousSegmentRowCount) throws Exception {

        DataPlatformUrn dataPlatformUrn = new DataPlatformUrn(dataPlatform);
        if (!isValid(fabricType)) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + fabricType +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }

        DatasetUrn datasetUrn = new DatasetUrn(dataPlatformUrn, datasetName, FabricType.valueOf(fabricType));
        DataControlKey dataset = parseDatasetName(datasetName);
        boolean passed = false;
        String assertionName = String.format("%svolume_%s_%s_%s.%s_%s", ASSERTION_URN_PREFIX,assertionType,
                dataset.databaseName(),dataset.tableName(), "dataset", fabricType);
        Urn assertionUrn = Urn.createFromString(assertionName);

                AssertionStdOperator operator = AssertionStdOperator.valueOf(operatorType.toUpperCase(Locale.ROOT));
        AssertionValueChangeType changeType = (valueChangeType != null && !valueChangeType.isEmpty())
                ? AssertionValueChangeType.valueOf(valueChangeType.toUpperCase(Locale.ROOT)) : null;

        AssertionStdParameters parameters = new AssertionStdParameters();
        if (stdParams != null) {
            if (stdParams.containsKey("value")) {
                parameters.setValue(new AssertionStdParameter().setValue(stdParams.get("value")));
            }
            if (stdParams.containsKey("minValue")) {
                parameters.setMinValue(new AssertionStdParameter().setValue(stdParams.get("minValue")));
            }
            if (stdParams.containsKey("maxValue")) {
                parameters.setMaxValue(new AssertionStdParameter().setValue(stdParams.get("maxValue")));
            }
        }

        switch (assertionType.toUpperCase(Locale.ROOT)) {
            case "ROW_COUNT_TOTAL" -> {
                long expected = Long.parseLong(stdParams.get("value"));
                passed = switch (operator) {
                    case EQUAL_TO -> currentRowCount == expected;
                    case NOT_EQUAL_TO -> currentRowCount != expected;
                    case GREATER_THAN -> currentRowCount > expected;
                    case LESS_THAN -> currentRowCount < expected;
                    default -> false;
                };
            }

            case "ROW_COUNT_CHANGE" -> {
                double changePct = ((double)(currentRowCount - previousRowCount)) / previousRowCount * 100.0;
                double min = Double.parseDouble(stdParams.getOrDefault("minValue", "-100"));
                double max = Double.parseDouble(stdParams.getOrDefault("maxValue", "100"));
                passed = changePct >= min && changePct <= max;
            }

            case "INCREMENTING_SEGMENT_ROW_COUNT_TOTAL" -> {
                long expected = Long.parseLong(stdParams.get("value"));
                passed = switch (operator) {
                    case GREATER_THAN -> currentSegmentRowCount > expected;
                    case LESS_THAN -> currentSegmentRowCount < expected;
                    case EQUAL_TO -> currentSegmentRowCount == expected;
                    case NOT_EQUAL_TO -> currentSegmentRowCount != expected;
                    default -> false;
                };
            }

            case "INCREMENTING_SEGMENT_ROW_COUNT_CHANGE" -> {
                long delta = currentSegmentRowCount - previousSegmentRowCount;
                long expected = Long.parseLong(stdParams.get("value"));
                passed = switch (operator) {
                    case GREATER_THAN -> delta > expected;
                    case LESS_THAN -> delta < expected;
                    case EQUAL_TO -> delta == expected;
                    case NOT_EQUAL_TO -> delta != expected;
                    default -> false;
                };
            }

            default -> throw new IllegalArgumentException("❌ Unsupported assertionType: " + assertionType);
        }
        StringMap nativeResult = new StringMap();
        AssertionResult assertionResult = new AssertionResult();
        AssertionAction assertionAction = new AssertionAction();
        AssertionRunEvent runEvent = new AssertionRunEvent();
        String errorDesc = "";

        if (passed) {
            nativeResult.put("Volume Assertion Result", "Data is OK as per " + assertionType + "For Business Date "
                    + businessDate);
            assertionAction.setType(AssertionActionType.RESOLVE_INCIDENT);
            assertionResult.setType(AssertionResultType.SUCCESS);
        } else {
            errorDesc = "Data is OK as per " + assertionType + "For Business Date "
                    + businessDate;
            nativeResult.put("Volume Result", errorDesc);
            assertionResult.setType(AssertionResultType.FAILURE);
            assertionAction.setType(AssertionActionType.RAISE_INCIDENT);
            assertionResult.setError(
                    new AssertionResultError()
                            .setType(AssertionResultErrorType.FIELD_ASSERTION_ERROR));
        }
        if (externalUrl != null && !externalUrl.isEmpty())
            assertionResult.setExternalUrl(externalUrl);

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
            String incidentTitle = String.format("Data Volume for %s, Env. %s", datasetName, fabricType);
            String incidentDesc = String.format("Data Volume Failed for %s, Env. %s\nErrors :%s"
                    , datasetName, fabricType, errorDesc);

            EmitResult incidentCreationStatus = incidentService.createIncident(incidentType, entityUrn,
                    incidentTitle, incidentDesc);
            if(incidentCreationStatus.isSuccess())
                DatahubLogger.logInfo("Incident Created");
            else
                DatahubLogger.logError("Incident Creation Failed With Error "
                        + incidentCreationStatus.getErrorDetails());
        }
    }
}
