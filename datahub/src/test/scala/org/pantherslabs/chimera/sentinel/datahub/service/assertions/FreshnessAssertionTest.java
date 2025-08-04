package org.pantherslabs.chimera.sentinel.datahub.service.assertions;

import org.junit.jupiter.api.Test;
import org.pantherslabs.chimera.sentinel.datahub.dto.FreshnessScheduleInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class FreshnessAssertionTest {

    @Autowired
    private FreshnessAssertion service;

    @Test
    public void testCreateWithDummyValues() throws Exception {
        // Dummy input values
        String dataPlatform = "postgres";
        String datasetName = "sentinel.public.data_control_dimensions";
        String fabricType = "PROD";
        String businessDate = "2025-07-31";
        String freshnessFieldType = "LAST_MODIFIED"; // Must match FreshnessFieldKind enum

        // Create and populate FreshnessScheduleInput
        FreshnessScheduleInput input = new FreshnessScheduleInput();
        input.scheduleType = "FIXED_INTERVAL";       // or "CRON"
        input.cronExpression = null;                 // if using FIXED_INTERVAL
        input.timezone = "UTC";
        input.windowStartOffsetMs = 0L;
        input.intervalMultiple = 1;
        input.intervalUnit = "DAY";

        // Run the method and ensure it doesn't throw
        assertDoesNotThrow(() -> {
            service.create(dataPlatform, datasetName, fabricType, businessDate, input, freshnessFieldType);
        });
    }

    @Test
    public void testRunWithDummyValues() throws Exception {
        // Dummy input values
        String dataPlatform = "postgres";
        String datasetName = "sentinel.public.data_control_dimensions";
        String fabricType = "PROD";
        String businessDate = "2025-07-31";
        String freshnessFieldType = "LAST_MODIFIED"; // Must match FreshnessFieldKind enum

        // Create and populate FreshnessScheduleInput
        FreshnessScheduleInput input = new FreshnessScheduleInput();
        input.scheduleType = "FIXED_INTERVAL";       // or "CRON"
        input.cronExpression = null;                 // if using FIXED_INTERVAL
        input.timezone = "UTC";
        input.windowStartOffsetMs = 0L;
        input.intervalMultiple = 3;
        input.intervalUnit = "DAY";

        service.run(dataPlatform, datasetName, fabricType, "https://google.com",businessDate);

    }

}