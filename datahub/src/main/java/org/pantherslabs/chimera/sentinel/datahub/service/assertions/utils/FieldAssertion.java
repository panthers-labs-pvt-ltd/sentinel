package org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils;

import com.linkedin.assertion.*;
import com.linkedin.common.FabricType;
import com.linkedin.common.urn.DataPlatformUrn;
import com.linkedin.common.urn.DatasetUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.dataset.DatasetFilter;
import com.linkedin.dataset.DatasetFilterType;
import com.linkedin.mxe.MetadataChangeProposal;
import com.linkedin.schema.SchemaFieldSpec;
import org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.service.assertions.VolumeAssertion;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.ASSERTION_URN_PREFIX;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.isValid;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.parseDatasetName;

public class FieldAssertion {

    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(VolumeAssertion.class);
    List<MetadataChangeProposal> proposals = new ArrayList<>();
    EmitResult result = null;

    public void create(String dataPlatform, String datasetName, String fabricType,
                       String businessDate, String VolumeAssertionTyp, String OperatorType) throws Exception {

        DataPlatformUrn dataPlatformUrn = new DataPlatformUrn(dataPlatform);

        if (!isValid(fabricType)) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + fabricType +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }
        DatasetUrn datasetUrn = new DatasetUrn(dataPlatformUrn, datasetName, FabricType.valueOf(fabricType));
        commonsFunctions.DataControlKey dataset = parseDatasetName(datasetName);

        String assertionName = String.format("%sfield_%s_%s.%s_%s", ASSERTION_URN_PREFIX, dataset.databaseName(),
                dataset.tableName(), "dataset", fabricType);

        AssertionStdParameters assertionStdParameters = new  AssertionStdParameters()
                .setMaxValue(new AssertionStdParameter().setValue("5000").setType(AssertionStdParameterType.NUMBER))
                .setValue(new AssertionStdParameter().setValue("0").setType(AssertionStdParameterType.STRING))
                .setMinValue(new AssertionStdParameter().setValue("0").setType(AssertionStdParameterType.NUMBER));

        // Create FieldAssertionInfo
        SchemaFieldSpec schemaFieldSpec = new SchemaFieldSpec()
                .setType("STRING")
                .setNativeType("varchar")
                .setPath("aspect");

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
    }
}
