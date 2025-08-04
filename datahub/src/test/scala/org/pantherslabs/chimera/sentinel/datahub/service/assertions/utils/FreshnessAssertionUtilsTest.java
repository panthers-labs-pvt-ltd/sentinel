package org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils;

import org.junit.jupiter.api.Test;
import org.pantherslabs.chimera.sentinel.datahub.dto.FreshnessScheduleInput;
import org.pantherslabs.chimera.sentinel.datahub.service.assertions.FreshnessAssertion;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FreshnessAssertionUtilsTest {

    @Autowired
    private FreshnessAssertion freshnessAssertionUtils;

    @Test
    void getLastExecutionTimeTest() {
        String tableName = "data_control_dimensions";
        String databaseName = "sentinel";
        Instant businessDate = now();
        FreshnessScheduleInput input = new FreshnessScheduleInput();
        input.scheduleType = "FIXED_INTERVAL";       // or "CRON"
        input.cronExpression = null;                 // if using FIXED_INTERVAL
        input.timezone = "UTC";
        input.windowStartOffsetMs = 0L;
        input.intervalMultiple = 3;
        input.intervalUnit = "DAY";

        List<Instant> result = freshnessAssertionUtils.getLastExecutionTime(tableName, databaseName, businessDate,
                input);
        System.out.println("Last Execution Time: " + result);
    }
}
