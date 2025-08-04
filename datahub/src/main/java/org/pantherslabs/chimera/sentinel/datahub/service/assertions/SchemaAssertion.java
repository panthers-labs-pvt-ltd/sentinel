package org.pantherslabs.chimera.sentinel.datahub.service.assertions;

import com.datahub.util.RecordUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.linkedin.schema.OtherSchema;
import com.linkedin.schema.SchemaField;
import com.linkedin.schema.SchemaFieldArray;
import com.linkedin.schema.SchemaMetadata;
import org.pantherslabs.chimera.sentinel.datahub.commons.AspectsMetadata;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.dto.Field;
import org.pantherslabs.chimera.sentinel.datahub.model.generated.LatestMetadataAspectV2;
import org.pantherslabs.chimera.sentinel.datahub.service.incidentService;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ResponseWrapper;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.*;
import static org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils.SchemaAssertionUtils.NativeTypeToSchemaType;
import static org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils.SchemaAssertionUtils.compareSchemas;


public class SchemaAssertion {
    List<MetadataChangeProposal> proposals = new ArrayList<>();
    EmitResult result = null;
    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(SchemaAssertion.class);

    public EmitResult create(String dataPlatform, String datasetName, String fabricType,
                             String schemaName, String sqlDDL, List<Field> schemaList,
                             String schemaDesc) throws Exception {
        DataPlatformUrn dataPlatformUrn = new DataPlatformUrn(dataPlatform);
        if (!isValid(fabricType)) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + fabricType +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }
        DatasetUrn datasetUrn = new DatasetUrn(dataPlatformUrn, datasetName, FabricType.valueOf(fabricType));
        String assertionName = String.format("%sschema_%s_%s_%s", ASSERTION_URN_PREFIX, dataPlatform,
                datasetName, fabricType);
        Urn assertionUrn = Urn.createFromString(assertionName);

        SchemaFieldArray schemaFields = new SchemaFieldArray();
        for (Field schema : schemaList) {
            SchemaField schemaField = new SchemaField();
            schemaField.setFieldPath(schema.getName());
            schemaField.setNativeDataType(schema.getType());
            schemaField.setType(NativeTypeToSchemaType(schema.getType()));
            schemaFields.add(schemaField);
        }

        SchemaMetadata schemaMetadata = new SchemaMetadata()
                .setPlatform(dataPlatformUrn)
                .setVersion(0L)
                .setHash("")
                .setSchemaName(schemaName)
                .setFields(schemaFields)
                .setPlatformSchema(SchemaMetadata.PlatformSchema.create(
                        new OtherSchema().setRawSchema(sqlDDL)));

        SchemaAssertionInfo schemaAssertionInfo = new SchemaAssertionInfo()
                .setEntity(datasetUrn)
                .setSchema(schemaMetadata)
                .setCompatibility(SchemaAssertionCompatibility.EXACT_MATCH);

        AssertionInfo assertionInfo = new AssertionInfo()
                .setType(AssertionType.DATA_SCHEMA)
                .setSchemaAssertion(schemaAssertionInfo)
                .setDescription(schemaDesc)
                .setLastUpdated(new AuditStamp()
                        .setActor(new CorpuserUrn(SYSTEM_ACTOR))
                        .setTime(Instant.now().toEpochMilli()))
                .setSource(new AssertionSource().setType(AssertionSourceType.NATIVE));
        proposals.add(buildProposal(assertionUrn, ASSERTION_INFO_ASPECT_NAME, assertionInfo, "CREATE"));
        return emitEvent(proposals);
    }

    public void run(String dataPlatform, String datasetName, String fabricType,
                    String externalUrl, List<Field> schemaList) throws Exception {

        DataPlatformUrn dataPlatformUrn = new DataPlatformUrn(dataPlatform);
        if (!isValid(fabricType)) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + fabricType +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }
        DatasetUrn datasetUrn = new DatasetUrn(dataPlatformUrn, datasetName, FabricType.valueOf(fabricType));
        String assertionName = String.format("%sschema_%s_%s_%s", ASSERTION_URN_PREFIX, dataPlatform, datasetName, fabricType);
        Urn assertionUrn = Urn.createFromString(assertionName);

        ResponseWrapper<List<LatestMetadataAspectV2>, ErrorResponse> response =
                AspectsMetadata.get(datasetUrn.toString(), SCHEMA_METADATA_ASPECT_NAME);

        if (response == null || !response.isSuccess() || response.getSuccessBody() == null) {
            throw new IllegalArgumentException("No Dataset Found for entity: " + datasetUrn);
        }

        // Step 2: Extract Schema aspect from the list of aspects
        LatestMetadataAspectV2 schemaMetadataAspect = response.getSuccessBody().stream()
                .filter(aspect -> SCHEMA_METADATA_ASPECT_NAME.equals(aspect.getAspect()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Schema Metadata aspect not found for entity: " + datasetUrn));

        SchemaMetadata existingSchema = RecordUtils.toRecordTemplate(SchemaMetadata.class, schemaMetadataAspect.getMetadata());

        StringMap nativeResult = new StringMap();
        AssertionResult assertionResult = new AssertionResult();
        AssertionAction assertionAction = new AssertionAction();

        List<ErrorResponse> matchStatus = compareSchemas(schemaList, existingSchema.getFields(), datasetUrn.toString());
        String errorDesc = "";
        if (matchStatus.isEmpty()) {
            nativeResult.put("result", "Schema matched");
            assertionAction.setType(AssertionActionType.RESOLVE_INCIDENT);
            assertionResult.setType(AssertionResultType.SUCCESS);

        } else {
            errorDesc = new ObjectMapper().writeValueAsString(matchStatus);
            nativeResult.put("result", "Schema MisMismatch");
            nativeResult.put("errors", errorDesc);
            assertionResult.setType(AssertionResultType.FAILURE);
            assertionAction.setType(AssertionActionType.RAISE_INCIDENT);
            assertionResult.setError(
                    new AssertionResultError()
                            .setType(AssertionResultErrorType.FIELD_ASSERTION_ERROR));
        }
            if (externalUrl != null && !externalUrl.isEmpty())
                assertionResult.setExternalUrl(externalUrl);
        assertionResult.setNativeResults(nativeResult);
        AssertionRunEvent runEvent = new AssertionRunEvent()
                .setRunId(UUID.randomUUID().toString())
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
            String incidentTitle = String.format("Schema Mismatch for %s, Env. %s", datasetName, fabricType);
            String incidentDesc = String.format("Schema Mismatch Found for %s, Env. %s\nErrors :%s"
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
