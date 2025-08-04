package org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils;

import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;
import com.datahub.util.RecordUtils;
import com.linkedin.assertion.FreshnessAssertionInfo;
import org.pantherslabs.chimera.sentinel.datahub.commons.AspectsMetadata;
import org.pantherslabs.chimera.sentinel.datahub.dto.FreshnessScheduleInput;
import org.pantherslabs.chimera.sentinel.datahub.model.generated.LatestMetadataAspectV2;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.dto.FilterCondition;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.mapper.GenericMapper;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.SINCE_THE_LAST_CHECK_SCHEDULE;

@Service
public class FreshnessAssertionUtils {

    @Autowired
    GenericMapper genericMapper;

    @SuppressWarnings("unchecked")
    public FreshnessScheduleInput extractSchedule(Map<String, Object> assertionData) {
        Map<String, Object> freshnessAssertion = (Map<String, Object>) assertionData.get("freshnessAssertion");
        if (freshnessAssertion == null) return null;

        Map<String, Object> schedule = (Map<String, Object>) freshnessAssertion.get("schedule");
        if (schedule == null) return null;

        FreshnessScheduleInput input = new FreshnessScheduleInput();
        input.scheduleType = (String) schedule.get("type");

        if ("FIXED_INTERVAL".equals(input.scheduleType)) {
            Map<String, Object> fixed = (Map<String, Object>) schedule.get("fixedInterval");
            if (fixed != null) {
                Object multiple = fixed.get("multiple");
                Object unit = fixed.get("unit");
                input.intervalMultiple = multiple != null ? Integer.parseInt(multiple.toString()) : null;
                input.intervalUnit = unit != null ? unit.toString() : null;
            }
        } else if ("CRON".equals(input.scheduleType)) {
            Map<String, Object> cron = (Map<String, Object>) schedule.get("cron");
            if (cron != null) {
                input.cronExpression = (String) cron.get("cronExpression");
                input.timezone = (String) cron.get("timezone");
            }
        }
        return input;
    }

    public  FreshnessScheduleInput getScheduleAssertion(String assertionName) throws IOException, InterruptedException {
        ResponseWrapper<List<LatestMetadataAspectV2>, ErrorResponse> response =
                AspectsMetadata.get(assertionName, ASSERTION_INFO_ASPECT_NAME);

        if (response == null || !response.isSuccess() || response.getSuccessBody() == null) {
            throw new IllegalArgumentException("No Assertion Found for entity: " + assertionName);
        }

        // Step 2: Extract Schema aspect from the list of aspects
        LatestMetadataAspectV2 aspectData = response.getSuccessBody().stream()
                .filter(aspect -> ASSERTION_INFO_ASPECT_NAME.equals(aspect.getAspect()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Assertion Metadata aspect not found for entity: " + assertionName));

        FreshnessAssertionInfo existingAssertion = RecordUtils.toRecordTemplate(FreshnessAssertionInfo.class,
                aspectData.getMetadata());
        Map<String, Object> rawMap = existingAssertion.data();
        // @SuppressWarnings("unchecked")
        // Map<String, Object> sqlAssertion = (Map<String, Object>) rawMap.get("sqlAssertion");

        return extractSchedule(rawMap);
    }


    /**
     * Method to validate parse and calculate if the data is fresh as per defined schedule
     *
     * @param cronExpr
     * @param timezone
     * @return
     */
    public  Instant getPreviousScheduledTime(String cronExpr, String timezone) {
        CronParser parser = new CronParser(CronDefinitionBuilder.instanceDefinitionFor(CronType.UNIX));
        Cron cron = parser.parse(cronExpr);
        cron.validate();

        ExecutionTime executionTime = ExecutionTime.forCron(cron);
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(timezone));

        Optional<ZonedDateTime> lastExecTime = executionTime.lastExecution(now);
        return lastExecTime.map(ZonedDateTime::toInstant)
                .orElseThrow(() -> new IllegalStateException("Unable to calculate last execution time"));
    }

    public  List<Instant> sgetLastExecutionTime(String tableName, String databaseName,
                                               String businessDate) {

        //TODO
        // Get the Conduct API to find out when the dataset updated last time and then compare
       List<FilterCondition> filters = List.of(
                new FilterCondition("table_name", "=", List.of(tableName)));

        String customSQL = String.format("""
                SELECT end_time FROM pipeline_run_logs WHERE LOWER(table_name) = LOWER('%s')
                AND LOWER(database_name) = LOWER('%s') AND run_status = 'SUCCESS'
                ORDER BY end_time DESC LIMIT 2""", tableName,databaseName);

        List<Map<String, Object>> result = genericMapper.executeDynamicFilterQuery(customSQL, filters);
        List<Instant> recentRunTimes = new ArrayList<>();
        for (Map<String, Object> row : result) {
            Object endTimeObj = row.get("end_time");
            if (endTimeObj instanceof Timestamp timestamp) {
                recentRunTimes.add(timestamp.toInstant());
            }
        }

/*        if (result != null && !result.isEmpty()) {
            Map<String, Object> row = result.get(0);
            Object value = row.get("end_time");

            if (value instanceof Timestamp) {
                return ((Timestamp) value).toInstant();
            } else if (value instanceof java.util.Date) {
                return ((java.util.Date) value).toInstant();
            }
        }*/
        return null;
    }

    public  String mapToChronoUnit(String unit) {
        return switch (unit.toUpperCase(Locale.ROOT)) {
            case "SECOND", "SECONDS" -> ChronoUnit.SECONDS.toString();
            case "MINUTE", "MINUTES" -> ChronoUnit.MINUTES.toString();
            case "HOUR", "HOURS" -> ChronoUnit.HOURS.toString();
            case "DAY", "DAYS" -> ChronoUnit.DAYS.toString();
            case "WEEK", "WEEKS" -> ChronoUnit.WEEKS.toString();
            case "MONTH", "MONTHS" -> ChronoUnit.MONTHS.toString();
            case "YEAR", "YEARS" -> ChronoUnit.YEARS.toString();
            default -> throw new IllegalArgumentException("Unsupported interval unit: " + unit);
        };
    }
}
