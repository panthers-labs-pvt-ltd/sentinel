package org.pantherslabs.chimera.sentinel.datahub.service;

import com.linkedin.assertion.*;
import com.linkedin.common.AuditStamp;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.DataPlatformUrn;
import com.linkedin.common.urn.DatasetUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringArray;
import com.linkedin.data.template.StringMap;
import com.linkedin.events.metadata.ChangeType;
import com.linkedin.mxe.MetadataChangeProposal;
import com.linkedin.schema.*;
import org.junit.jupiter.api.Test;
import org.pantherslabs.chimera.sentinel.datahub.Constants;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.dto.Field;

import java.net.URISyntaxException;
import java.time.Instant;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.*;

class MetadataAspectAssertionTest {
    List<MetadataChangeProposal> proposals = new ArrayList<>();
    EmitResult result = null;

    @Test
    void schemaAssertionTest() throws Exception {
        String schemaAssertion="SchemaAssertion";
        String datasetUrnStr = "urn:li:dataset:(urn:li:dataPlatform:postgres,datahub.public.metadata_aspect_v2,PROD)";
        Urn assertionUrn = Urn.createFromString("urn:li:assertion:" + schemaAssertion);

        SchemaFieldDataType.Type stringType = new SchemaFieldDataType.Type();
        stringType.setStringType(new StringType());

        List<Field> schemaList = new ArrayList<>();
        schemaList.add(new Field("id", "String",true));
        schemaList.add(new Field("age", "Integer",true));
        schemaList.add(new Field("created_at", "Timestamp",true));

        SchemaFieldArray schemaFieldArray = new SchemaFieldArray();

        for (Field schema : schemaList) {
            SchemaField schemaField = new SchemaField();
            schemaField.setFieldPath(schema.getName());
            schemaField.setNativeDataType(schema.getType());
            schemaField.setType(NativeTypeToSchemaType(schema.getType()));
            schemaFieldArray.add(schemaField);
        }

     /*   SchemaField fieldVersion = new SchemaField()
                .setFieldPath("version")
                .setType(new SchemaFieldDataType().setType(stringType))
                .setNativeDataType("varchar");

        SchemaField fieldAspect = new SchemaField()
                .setFieldPath("aspect")
                .setType(new SchemaFieldDataType().setType(stringType))
                .setNativeDataType("varchar");

        SchemaField fieldCreatedBy = new SchemaField()
                .setFieldPath("createdby")
                .setType(new SchemaFieldDataType().setType(stringType))
                .setNativeDataType("varchar");*/

/*
// Combine all fields
        SchemaFieldArray schemaFields = new SchemaFieldArray(Arrays.asList(fieldVersion, fieldAspect, fieldCreatedBy));
*/


        SchemaMetadata schemaMetadata = new SchemaMetadata()
                .setPlatform(DataPlatformUrn.createFromString("urn:li:dataPlatform:postgres"))
                .setVersion(0L)
                .setHash("")
                .setSchemaName("sentinel")
                .setFields(schemaFieldArray)
                .setPlatformSchema(SchemaMetadata.PlatformSchema.create(new OtherSchema().setRawSchema("create table metadata_aspect_v2 ( urn varchar(500) not null, aspect varchar(200) not null,  version  int8 not null, metadata text not null, systemmetadata text null, createdon timestamp not null, createdby varchar(255) not null, createdfor varchar(255) null, constraint pk_metadata_aspect_v2 primary key (urn, aspect, version) )")));

        SchemaAssertionInfo schemaAssertionInfo = new SchemaAssertionInfo()
                .setEntity(Urn.createFromString(datasetUrnStr))
                .setSchema(schemaMetadata)
                .setCompatibility(SchemaAssertionCompatibility.EXACT_MATCH);

        AssertionInfo assertionInfo = new AssertionInfo()
                .setType(AssertionType.DATA_SCHEMA)
                .setSchemaAssertion(schemaAssertionInfo)
                .setDescription("My Schema Assertion")
                .setLastUpdated(new AuditStamp()
                        .setActor(new CorpuserUrn(SYSTEM_ACTOR))
                        .setTime(Instant.now().toEpochMilli()))
                .setSource(new AssertionSource().setType(AssertionSourceType.NATIVE));

        proposals.add(buildProposal(assertionUrn,ASSERTION_INFO_ASPECT_NAME,assertionInfo,"CREATE"));

        StringMap ss= new StringMap();
        ss.put("result", "Schema matched");


        AssertionRunEvent runEvent = new AssertionRunEvent()
                .setRunId(UUID.randomUUID().toString())
                .setAssertionUrn(assertionUrn)
                .setAsserteeUrn(Urn.createFromString(datasetUrnStr))
                .setTimestampMillis(Instant.now().toEpochMilli())
                .setStatus(AssertionRunStatus.COMPLETE)
                .setResult(new AssertionResult()
                        .setType(AssertionResultType.SUCCESS)
                        .setExternalUrl("https://your-monitoring-system/assertions/" + assertionUrn.getId())
                        .setRowCount(100)
                        .setUnexpectedCount(0)
                        .setActualAggValue(0.0F)
                        .setNativeResults(ss)
                        .setMissingCount(0L)
                );
        proposals.add(buildProposal(assertionUrn,ASSERTION_RUN_EVENT_ASPECT_NAME,runEvent,"UPSERT"));
result = emitEvent(proposals);
    }
}