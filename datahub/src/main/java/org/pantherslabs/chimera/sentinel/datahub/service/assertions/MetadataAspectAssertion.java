package org.pantherslabs.chimera.sentinel.datahub.service.assertions;

import com.linkedin.assertion.*;
import com.linkedin.common.UrnArray;
import com.linkedin.common.url.Url;
import com.linkedin.common.urn.DataPlatformUrn;
import com.linkedin.common.urn.DatasetUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringMap;
import com.linkedin.dataset.DatasetFilter;
import com.linkedin.dataset.DatasetFilterType;
import com.linkedin.schema.*;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class MetadataAspectAssertion {

    public static void main(String[] args) throws Exception {

        String datasetUrnStr = "urn:li:dataset:(urn:li:dataPlatform:postgres,datahub.public.metadata_aspect_v2,PROD)";
        DatasetUrn datasetUrn = (DatasetUrn) Urn.createFromString(datasetUrnStr);
        Urn assertionUrn = Urn.createFromString("urn:li:assertion:" + UUID.randomUUID());

        // Create FieldAssertionInfo
        SchemaFieldSpec schemaFieldSpec = new SchemaFieldSpec()
                .setType("STRING")
                .setNativeType("varchar")
                .setPath("aspect");

        AssertionStdParameters assertionStdParameters = new  AssertionStdParameters()
                .setMaxValue(new AssertionStdParameter().setValue("5000").setType(AssertionStdParameterType.NUMBER))
                .setValue(new AssertionStdParameter().setValue("0").setType(AssertionStdParameterType.STRING))
                .setMinValue(new AssertionStdParameter().setValue("0").setType(AssertionStdParameterType.NUMBER));

        FieldMetricAssertion fieldMetricAssertion = new FieldMetricAssertion()
                .setField(schemaFieldSpec)
                .setMetric(FieldMetricType.MEAN)
                .setOperator(AssertionStdOperator.GREATER_THAN)
                .setParameters(assertionStdParameters);

        FieldAssertionInfo fieldAssertionInfo = new FieldAssertionInfo()
                .setFieldMetricAssertion(fieldMetricAssertion)
                .setType(FieldAssertionType.FIELD_METRIC)
                .setEntity(Urn.createFromString("ddd"))
                .setFilter(new DatasetFilter().setType(DatasetFilterType.SQL));

//==============Schema Assertions
        SchemaFieldDataType.Type type = new SchemaFieldDataType.Type();
        type.setStringType(new StringType());

        SchemaFieldDataType schemaFieldDataType = new SchemaFieldDataType()
                .setType(type);

        SchemaField schemaField = new SchemaField()
                .setFieldPath("aspect")
                .setType(schemaFieldDataType)
                .setNativeDataType("varchar");


        SchemaMetadata schemaMetadata = new SchemaMetadata()
                .setPlatform((DataPlatformUrn) Urn.createFromString("urn:li:dataPlatform:postgres"))
                .setVersion(0L)
                .setHash("")
                .setFields(new SchemaFieldArray(Collections.singletonList(schemaField)))
                .setPlatformSchema(SchemaMetadata.PlatformSchema.create(new OtherSchema().setRawSchema("create table ...")))
                .setDataset(datasetUrn);

        SchemaAssertionInfo schemaAssertionInfo = new SchemaAssertionInfo()
                .setEntity(Urn.createFromString(""))
                .setSchema(schemaMetadata)
                .setCompatibility(SchemaAssertionCompatibility.EXACT_MATCH);
//========= SQL ASSERTION

        // SQL assertion
        AssertionStdParameters sqlassertionStdParameters = new  AssertionStdParameters()
                .setMaxValue(new AssertionStdParameter().setValue("5000").setType(AssertionStdParameterType.NUMBER))
                .setValue(new AssertionStdParameter().setValue("MYVALUE").setType(AssertionStdParameterType.STRING))
                .setMinValue(new AssertionStdParameter().setValue("1").setType(AssertionStdParameterType.NUMBER));


        SqlAssertionInfo sqlAssertionInfo = new SqlAssertionInfo()
                .setOperator(AssertionStdOperator.GREATER_THAN)
                .setChangeType(AssertionValueChangeType.ABSOLUTE)
                .setEntity(Urn.createFromString(""))
                .setStatement("SELECT COUNT(*) FROM datahub.public.metadata_aspect_v2 WHERE createdon IS NULL")
                .setType(SqlAssertionType.METRIC_CHANGE)
                .setParameters(sqlassertionStdParameters);
//============ Volume assertion

        VolumeAssertionInfo volumeAssertionInfo = new VolumeAssertionInfo()
                .setType(VolumeAssertionType.ROW_COUNT_CHANGE)
                .setEntity(Urn.createFromString(""))
                .setFilter(new DatasetFilter().setType(DatasetFilterType.SQL))
                .setRowCountTotal(new RowCountTotal().setOperator(AssertionStdOperator.GREATER_THAN))
                .setIncrementingSegmentRowCountChange(new IncrementingSegmentRowCountChange().setType(AssertionValueChangeType.ABSOLUTE))
                .setIncrementingSegmentRowCountTotal(new IncrementingSegmentRowCountTotal()
                        .setSegment(new IncrementingSegmentSpec().setField(schemaFieldSpec)
                                .setTransformer(new IncrementingSegmentFieldTransformer().setNativeType("STRING")
                                        .setType(IncrementingSegmentFieldTransformerType.NATIVE))));
//======================================

        // DatasetAssertion (row count)
        UrnArray urnarray = new UrnArray();
        urnarray.add(new Urn(""));
        urnarray.add(new Urn(""));

        DatasetAssertionInfo datasetAssertionInfo = new DatasetAssertionInfo()
                .setDataset(datasetUrn)
                .setAggregation(AssertionStdAggregation.ROW_COUNT)
                .setLogic("rowCount > 100")
                .setFields(urnarray)
                .setOperator(AssertionStdOperator.GREATER_THAN)
                .setNativeType("ROW_COUNT")
                .setNativeParameters(new StringMap(Map.of("expectedRowCount", "100")))
                .setScope(DatasetAssertionScope.DATASET_COLUMN);

        // Final AssertionInfo
        AssertionInfo assertionInfo = new AssertionInfo()
                .setType(AssertionType.DATASET)
                .setDescription("Assertions on metadata_aspect_v2 table")
                .setDatasetAssertion(datasetAssertionInfo)
                .setFieldAssertion(fieldAssertionInfo)
                .setSchemaAssertion(schemaAssertionInfo)
                .setSqlAssertion(sqlAssertionInfo)
                .setVolumeAssertion(volumeAssertionInfo)
                .setExternalUrl(new Url("https://monitoring.internal/assertions/metadata_aspect_v2"))
                .setCustomProperties(new StringMap(Map.of(
                        "source", "custom-quality-check",
                        "env", "prod"
                )));

    /*    MetadataChangeProposalWrapper mcp = MetadataChangeProposalWrapper.builder()
                .entityType("assertion")
                .entityUrn(assertionUrn)
                .aspectName("assertionInfo")
                .aspect(GenericAspectUtils.serializeAspect(assertionInfo))
                .changeType(com.linkedin.metadata.event.ChangeType.UPSERT)
                .build();

        emitter.emit(mcp, null);*/

        System.out.println("✅ Assertion created and emitted for dataset: " + datasetUrn);
    }
}

