package org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils;

import com.linkedin.assertion.VolumeAssertionType;

import java.util.Locale;

import static com.linkedin.assertion.VolumeAssertionType.*;

public class VolumeAssertionUtils {
    public static String getVolumeAssertionTypeQuery(
            String VolumeAssertionType,
            String databaseName,
            String tableName,
            boolean isPartitioned,
            String partitionKey
    ) {
        final String baseFilter = "database_name = '%s' AND table_name = '%s'".formatted(databaseName, tableName);

        return switch (VolumeAssertionType.toUpperCase(Locale.ROOT)) {
            case "ROW_COUNT_TOTAL" -> isPartitioned
                    ? """
                        SELECT SUM(row_count) AS total_row_count
                        FROM data_volume_log
                        WHERE %s
                          AND is_partitioned = true
                          AND partition_key = '%s'
                          AND partition_value = (
                              SELECT MAX(partition_value)
                              FROM data_volume_log
                              WHERE %s AND partition_key = '%s'
                          );
                        """.formatted(baseFilter, partitionKey, baseFilter, partitionKey)
                    : """
                        SELECT row_count
                        FROM data_volume_log
                        WHERE %s AND is_partitioned = false
                        ORDER BY log_time DESC
                        LIMIT 1;
                        """.formatted(baseFilter);

            case "ROW_COUNT_CHANGE" -> isPartitioned
                    ? """
                        SELECT partition_value, SUM(row_count) AS total_row_count
                        FROM data_volume_log
                        WHERE %s
                          AND is_partitioned = true
                          AND partition_key = '%s'
                        GROUP BY partition_value
                        ORDER BY partition_value DESC
                        LIMIT 2;
                        """.formatted(baseFilter, partitionKey)
                    : """
                        SELECT row_count
                        FROM data_volume_log
                        WHERE %s AND is_partitioned = false
                        ORDER BY log_time DESC
                        LIMIT 2;
                        """.formatted(baseFilter);

            case "INCREMENTING_SEGMENT_ROW_COUNT_TOTAL" -> """
                    SELECT row_count
                    FROM data_volume_log
                    WHERE %s
                      AND is_partitioned = true
                      AND partition_key = '%s'
                      AND partition_value = (
                          SELECT MAX(partition_value)
                          FROM data_volume_log
                          WHERE %s AND partition_key = '%s'
                      );
                    """.formatted(baseFilter, partitionKey, baseFilter, partitionKey);

            case "INCREMENTING_SEGMENT_ROW_COUNT_CHANGE" -> """
                    SELECT partition_value, row_count
                    FROM data_volume_log
                    WHERE %s
                      AND is_partitioned = true
                      AND partition_key = '%s'
                    ORDER BY partition_value DESC
                    LIMIT 2;
                    """.formatted(baseFilter, partitionKey);
            default -> throw new IllegalStateException("Unexpected value: " + VolumeAssertionType);
        };
    }
}
