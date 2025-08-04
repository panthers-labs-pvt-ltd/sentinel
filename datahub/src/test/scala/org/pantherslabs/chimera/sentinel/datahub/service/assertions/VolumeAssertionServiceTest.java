package org.pantherslabs.chimera.sentinel.datahub.service.assertions;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class VolumeAssertionServiceTest {
    VolumeAssertion service = new VolumeAssertion(); // Your class name

    @Test
    public void testCreateVolumeAssertionInfo_rowCountChange() throws Exception {

        String dataPlatform = "postgres";
        String datasetName = "sentinel.public.data_control_dimensions";
        String fabricType = "PROD";

        String fieldPath = "dimension_name";
        String fieldType = "String";
        String nativeType = "varchar";

        Map<String, String> stdParams = new HashMap<>();
        stdParams.put("min", "0");
        stdParams.put("max", "10000");
        stdParams.put("value", "0");

        // Case 1: ROW_COUNT_TOTAL
        service.create( dataPlatform, datasetName, fabricType, fieldPath, fieldType, nativeType, null, "ROW_COUNT_TOTAL", "LESS_THAN", stdParams );

        // Case 2: ROW_COUNT_CHANGE
        service.create( dataPlatform, datasetName, fabricType, fieldPath, fieldType, nativeType, "PERCENTAGE", "ROW_COUNT_CHANGE", "LESS_THAN", stdParams     );

        // Case 3: INCREMENTING_SEGMENT_ROW_COUNT_TOTAL
        service.create( dataPlatform, datasetName, fabricType, fieldPath, fieldType, nativeType, "ABSOLUTE", "INCREMENTING_SEGMENT_ROW_COUNT_TOTAL", "GREATER_THAN", stdParams     );

        // Case 4: INCREMENTING_SEGMENT_ROW_COUNT_CHANGE
        service.create( dataPlatform, datasetName, fabricType, fieldPath, fieldType, nativeType, "PERCENTAGE", "INCREMENTING_SEGMENT_ROW_COUNT_CHANGE", "GREATER_THAN", stdParams);
    }

    @Test
    public void testRunVolumeAssertionInfo_rowCountChange() throws Exception {
        String dataPlatform = "postgres";
        String datasetName = "sentinel.public.data_control_dimensions";
        String fabricType = "PROD";
        String businessDate = "2025-07-31";
        String externalUrl = "https://example.com/assertion-run-result";

        // Common Parameters

        Map<String, String> stdParams = new HashMap<>();
        stdParams.put("threshold", "10");
        stdParams.put("value", "100");

        long currentRowCount = 1200;
        long previousRowCount = 1000;
        long currentSegmentRowCount = 300;
        long previousSegmentRowCount = 250;

       // Case 1: ROW_COUNT_TOTAL
        service.run(dataPlatform, datasetName, fabricType, externalUrl, businessDate,
                "ROW_COUNT_TOTAL", "GREATER_THAN", null, stdParams,
                currentRowCount, previousRowCount,
                currentSegmentRowCount, previousSegmentRowCount);

        // Case 2: ROW_COUNT_CHANGE
        service.run(dataPlatform, datasetName, fabricType, externalUrl, businessDate,
                "ROW_COUNT_CHANGE", "GREATER_THAN", null, stdParams,
                currentRowCount, previousRowCount,
                currentSegmentRowCount, previousSegmentRowCount);

       // Case 3: INCREMENTING_SEGMENT_ROW_COUNT_TOTAL
        service.run(dataPlatform, datasetName, fabricType, externalUrl, businessDate,
                "INCREMENTING_SEGMENT_ROW_COUNT_TOTAL", "GREATER_THAN", "ABSOLUTE", stdParams,
                currentRowCount, previousRowCount,
                currentSegmentRowCount, previousSegmentRowCount);

        // Case 4: INCREMENTING_SEGMENT_ROW_COUNT_CHANGE
        service.run(dataPlatform, datasetName, fabricType, externalUrl, businessDate,
                "INCREMENTING_SEGMENT_ROW_COUNT_CHANGE", "GREATER_THAN", "PERCENTAGE", stdParams,
                currentRowCount, previousRowCount,
                currentSegmentRowCount, previousSegmentRowCount);
    }
    }