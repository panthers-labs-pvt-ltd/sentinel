package org.pantherslabs.chimera.sentinel.datahub.service.assertions;

import org.junit.jupiter.api.Test;
import org.pantherslabs.chimera.sentinel.datahub.dto.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class DatasetAssertionTest {
    @Autowired
    private DatasetAssertion service;
    String dataPlatform = "postgres";
    String datasetName = "sentinel.public.data_control_dimensions";
    String fabricType = "PROD";
    String businessDate = "2025-07-31";

    @Test
    void create() throws Exception {
        List<String> columnList = List.of("dimension_id", "dimension_name","control_id","dimension_short_desc");
        String assertionScope = "DATASET_COLUMN";
        String aggregationRule = "ROW_COUNT";
        String operator = "EQUAL_TO";
        Map<String, String> params = Map.of("value", "100");

        // Call the method under test
        service.create(
                dataPlatform,
                datasetName,
                fabricType,
                businessDate,
                columnList,
                assertionScope,
                aggregationRule,
                operator,
                params
        );

        // Assertions.assertNotNull(result);
        // Assertions.assertEquals(expectedUrn, result.getDataset());
    }

    @Test
    void runAssertion() {

        try {
            service.run(dataPlatform,datasetName,fabricType,500,businessDate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
