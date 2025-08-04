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
import com.linkedin.timeseries.CalendarInterval;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.dto.FreshnessScheduleInput;
import org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils.FreshnessAssertionUtils;
import org.pantherslabs.chimera.sentinel.datahub.service.incidentService;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.dto.FilterCondition;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.mapper.GenericMapper;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.ASSERTION_INFO_ASPECT_NAME;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.*;

@Service
public class FreshnessAssertion {
    @Autowired
            GenericMapper genericMapper;

    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(FreshnessAssertion.class);
    List<MetadataChangeProposal> proposals = new ArrayList<>();
    EmitResult result = null;
    FreshnessAssertionUtils freshnessAssertionUtils = new FreshnessAssertionUtils();
    public void create(String dataPlatform, String datasetName, String fabricType,
                       String businessDate, FreshnessScheduleInput input, String FreshnessFieldType) throws Exception {

        DataPlatformUrn dataPlatformUrn = new DataPlatformUrn(dataPlatform);
        if (!isValid(fabricType)) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + fabricType +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }
        DatasetUrn datasetUrn = new DatasetUrn(dataPlatformUrn, datasetName, FabricType.valueOf(fabricType));
        DataControlKey dataset = parseDatasetName(datasetName);

        String assertionName = String.format("%sfreshness_%s_%s.%s_%s", ASSERTION_URN_PREFIX, dataset.databaseName(),
                dataset.tableName(), "dataset", fabricType);

        DatasetFilter datasetFilter = new DatasetFilter();
        datasetFilter.setType(DatasetFilterType.SQL);
        datasetFilter.setSql("SQL");

        if (!isValid(CalendarInterval.class, input.intervalUnit.toUpperCase())) {
            throw new IllegalArgumentException("❌ Invalid intervalUnit: " + input.intervalUnit +
                    ". Allowed values: " + Arrays.toString(CalendarInterval.values()));
        }
        String Description = "";
        // dataset.databaseName(), dataset.tableName());

        FreshnessAssertionSchedule schedule = new FreshnessAssertionSchedule();

        if (CRON_EXPRESSION_SCHEDULE.equalsIgnoreCase(input.scheduleType)) {
            schedule.setType(FreshnessAssertionScheduleType.CRON);
            FreshnessCronSchedule cronSchedule = new FreshnessCronSchedule()
                    .setCron(input.cronExpression)
                    .setTimezone(input.timezone)
                    .setWindowStartOffsetMs(input.windowStartOffsetMs != null ? input.windowStartOffsetMs : 0L);
            schedule.setCron(cronSchedule);
            Description = String.format(
                    "Ensures that dataset '%s' is updated according to cron schedule '%s' (%s).",
                    dataset.tableName(), input.cronExpression, input.timezone
            );
        } else if (FIXED_INTERVAL_SCHEDULE.equalsIgnoreCase(input.scheduleType)) {
            schedule.setType(FreshnessAssertionScheduleType.FIXED_INTERVAL);
            FixedIntervalSchedule fixedIntervalSchedule = new FixedIntervalSchedule()
                    .setMultiple(input.intervalMultiple != null ? input.intervalMultiple : 1)
                    .setUnit(CalendarInterval.valueOf(input.intervalUnit.toUpperCase()));
            schedule.setFixedInterval(fixedIntervalSchedule);
            Description = String.format(
                    "Checks that dataset '%s' is updated at least every %d %s.",
                    dataset.tableName(), input.intervalMultiple, input.intervalUnit.toLowerCase()
            );
        } else if (SINCE_THE_LAST_CHECK_SCHEDULE.equalsIgnoreCase(input.scheduleType)) {
            schedule.setType(FreshnessAssertionScheduleType.SINCE_THE_LAST_CHECK);
            Description = String.format("Ensures that dataset %s has been updated since the last run.", dataset.tableName());
        }

        FreshnessAssertionInfo freshnessAssertion = new FreshnessAssertionInfo()
                .setType(FreshnessAssertionType.DATA_JOB_RUN)
                .setEntity(datasetUrn)
                .setFilter(datasetFilter)
                .setSchedule(schedule);

        if (!isValid(FreshnessFieldKind.class, FreshnessFieldType.toUpperCase())) {
            throw new IllegalArgumentException("❌ Invalid FreshnessFieldType: " + FreshnessFieldType +
                    ". Allowed values: " + Arrays.toString(FreshnessFieldKind.values()));
        }

        FreshnessFieldSpec fieldSpec = new FreshnessFieldSpec()
                .setType("timestamp")
                .setNativeType("bigint")
                .setPath("event_time")
                .setKind(FreshnessFieldKind.valueOf(FreshnessFieldType.toUpperCase()));


        AssertionInfo assertionInfo = new AssertionInfo()
                .setFreshnessAssertion(freshnessAssertion)
                .setType(AssertionType.FRESHNESS)
                .setDescription(Description)
                .setLastUpdated(new AuditStamp()
                        .setActor(new CorpuserUrn(SYSTEM_ACTOR))
                        .setTime(Instant.now().toEpochMilli()))
                .setSource(new AssertionSource().setType(AssertionSourceType.NATIVE));

        proposals.add(buildProposal(Urn.createFromString(assertionName), ASSERTION_INFO_ASPECT_NAME,
                assertionInfo, "CREATE"));
        result = emitEvent(proposals);

    }

    public void run(String dataPlatform, String datasetName, String fabricType,
                    String externalUrl, String businessDate) throws Exception {

        DataPlatformUrn dataPlatformUrn = new DataPlatformUrn(dataPlatform);
        if (!isValid(fabricType)) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + fabricType +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }

        DatasetUrn datasetUrn = new DatasetUrn(dataPlatformUrn, datasetName, FabricType.valueOf(fabricType));
        DataControlKey dataset = parseDatasetName(datasetName);
        String assertionName = String.format("%sfreshness_%s_%s.%s_%s", ASSERTION_URN_PREFIX, dataset.databaseName(),
                dataset.tableName(), "dataset", fabricType);
        Urn assertionUrn = Urn.createFromString(assertionName);

        StringMap nativeResult = new StringMap();
        AssertionResult assertionResult = new AssertionResult();
        AssertionAction assertionAction = new AssertionAction();
        AssertionRunEvent runEvent = new AssertionRunEvent();
        FreshnessScheduleInput scheduleInput = freshnessAssertionUtils.getScheduleAssertion(assertionName);
        boolean isDatasetFresh = isDatasetFresh(dataset.tableName(), dataset.databaseName(), businessDate,
                scheduleInput);
        System.out.println("Data Refresh Status is "+ isDatasetFresh);
        String errorDesc = "";
        if (isDatasetFresh) {
            nativeResult.put("Freshness Result", "Data is updated as per scheduled..");
            assertionAction.setType(AssertionActionType.RESOLVE_INCIDENT);
            assertionResult.setType(AssertionResultType.SUCCESS);

        } else {
            errorDesc = "Data is not updated as per scheduled..";
            nativeResult.put("Freshness Result", errorDesc);
            nativeResult.put("Schedule", String.valueOf(scheduleInput));
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
            String incidentTitle = String.format("Data Freshness for %s, Env. %s", datasetName, fabricType);
            String incidentDesc = String.format("Data Freshness Failed for %s, Env. %s\nErrors :%s"
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

    public  List<Instant> getLastExecutionTime(String tableName, String databaseName,
                                               Instant expectedTime,FreshnessScheduleInput schedule) {

        List<FilterCondition> filters = List.of(
                new FilterCondition("table_name", "=", List.of(tableName)));

        String zone = (schedule.timezone != null && !schedule.timezone.isBlank())
                ? schedule.timezone
                : "UTC";

        String customSQL = String.format("""
                SELECT end_time FROM pipeline_run_logs WHERE LOWER(table_name) = LOWER('%s')
                AND LOWER(database_name) = LOWER('%s') AND run_status = 'SUCCESS'
                AND DATE(end_time) >= DATE('%s')
                ORDER BY end_time DESC LIMIT 2""", tableName,databaseName,
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
                        .withZone(ZoneId.of(zone)).format(expectedTime));

        List<Map<String, Object>> result = genericMapper.executeDynamicFilterQuery(customSQL, filters);
        List<Instant> recentRunTimes = new ArrayList<>();
        for (Map<String, Object> row : result) {
            Object endTimeObj = row.get("end_time");
            if (endTimeObj instanceof Timestamp timestamp) {
                recentRunTimes.add(timestamp.toInstant());
            }
        }
        return recentRunTimes;
    }


    /**
     * Method to Find the Dataset Freshness Status and compare with current execution
     *
     * @param tableName
     * @param databaseName
     * @param businessDate
     * @param scheduleInput
     * @return
     * @throws Exception
     */
    public boolean isDatasetFresh(String tableName, String databaseName, String businessDate,
                                  FreshnessScheduleInput scheduleInput)  {

        Instant now = Instant.now();
        Instant freshnessThreshold;
        FreshnessAssertionUtils utils = new FreshnessAssertionUtils();

        switch (scheduleInput.scheduleType.toUpperCase()) {
            case FIXED_INTERVAL_SCHEDULE -> {
                ZoneId zone = ZoneId.of(scheduleInput.timezone != null ? scheduleInput.timezone : "UTC");
                ZonedDateTime currentTs = ZonedDateTime.now(zone);
                ChronoUnit unit = ChronoUnit.valueOf(freshnessAssertionUtils.mapToChronoUnit(scheduleInput.intervalUnit).toUpperCase());
                Duration interval = Duration.of(scheduleInput.intervalMultiple, unit);
                freshnessThreshold = currentTs.minus(interval).toInstant();
            }
            case CRON_EXPRESSION_SCHEDULE -> {
                freshnessThreshold = freshnessAssertionUtils.getPreviousScheduledTime(scheduleInput.cronExpression, scheduleInput.timezone);
            }
            case SINCE_THE_LAST_CHECK_SCHEDULE -> {
                freshnessThreshold = null;
            }
            default -> throw new IllegalArgumentException("Invalid schedule type");
        }
        if (scheduleInput.windowStartOffsetMs != null) {
            assert freshnessThreshold != null;
            freshnessThreshold = freshnessThreshold.minusMillis(scheduleInput.windowStartOffsetMs);
        }

        List<Instant> recentRunTimes = getLastExecutionTime(tableName, databaseName, freshnessThreshold, scheduleInput);
        Instant lastUpdateTime = null;
        if (!recentRunTimes.isEmpty()) {
            lastUpdateTime = recentRunTimes.get(0);
            freshnessThreshold = recentRunTimes.size() > 1 ? recentRunTimes.get(1) : null;
            System.out.println("Previous run: " + freshnessThreshold);
            System.out.println("Latest run: " + (lastUpdateTime != null ? lastUpdateTime : "Not available"));
        }
        return lastUpdateTime.isAfter(freshnessThreshold);
    }
}
