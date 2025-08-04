package org.pantherslabs.chimera.sentinel.datahub.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreshnessScheduleInput {
    public String scheduleType;         // "CRON" or "FIXED_INTERVAL"
    public String cronExpression;       // e.g., "0 0 * * *"
    public String timezone;             // e.g., "Asia/Kolkata"
    public Long windowStartOffsetMs;    // e.g., 0L
    public Integer intervalMultiple;    // e.g., 1
    public String intervalUnit;         // e.g., "HOURS", "DAYS"
}
