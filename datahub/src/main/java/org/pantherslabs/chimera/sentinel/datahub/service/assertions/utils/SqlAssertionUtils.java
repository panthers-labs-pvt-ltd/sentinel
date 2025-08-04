package org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils;

import com.datahub.util.RecordUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.linkedin.assertion.*;
import com.linkedin.common.urn.Urn;
import org.pantherslabs.chimera.sentinel.datahub.commons.AspectsMetadata;
import org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions;
import org.pantherslabs.chimera.sentinel.datahub.model.generated.LatestMetadataAspectV2;
import org.pantherslabs.chimera.sentinel.datahub.model.generated.DataControlsLog;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.consumer.ApiConsumer;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ResponseWrapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.ASSERTION_INFO_ASPECT_NAME;

public class SqlAssertionUtils {
    public static String getAssertionSQL(String assertionName) throws IOException, InterruptedException {
        ResponseWrapper<List<LatestMetadataAspectV2>, ErrorResponse> response =
                AspectsMetadata.get(assertionName, ASSERTION_INFO_ASPECT_NAME);

        if (response == null || !response.isSuccess() || response.getSuccessBody() == null) {
            throw new IllegalArgumentException("No SQL Assertion Found for entity: " + assertionName);
        }

        // Step 2: Extract Schema aspect from the list of aspects
        LatestMetadataAspectV2 schemaMetadataAspect = response.getSuccessBody().stream()
                .filter(aspect -> ASSERTION_INFO_ASPECT_NAME.equals(aspect.getAspect()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("SQL Assertion Metadata aspect not found for entity: " + assertionName));

        SqlAssertionInfo existingAssertion = RecordUtils.toRecordTemplate(SqlAssertionInfo.class, schemaMetadataAspect.getMetadata());
        Map<String, Object> rawMap = existingAssertion.data();
        @SuppressWarnings("unchecked")
        Map<String, Object> sqlAssertion = (Map<String, Object>) rawMap.get("sqlAssertion");
        return (sqlAssertion != null && sqlAssertion.get("statement") != null)
                ? sqlAssertion.get("statement").toString()
                : "No SQL Statement";
    }

    public static List<DataControlsLog> getControlData(String databaseName, String tableName, String businessDate) throws IOException, InterruptedException {
        String filterApiUrl = "http://localhost:9001/api/records/filter";
        ApiConsumer consumer = new ApiConsumer();
        List<DataControlsLog> deduplicated =new ArrayList<>();
        List<String> filters = new ArrayList<>();

        // Mandatory table_name filter
        filters.add(String.format("""
            { "field": "table_name", "operator": "=", "value": ["%s"] }""", tableName));

        // Optional filters
        if (databaseName != null && !databaseName.isBlank()) {
            filters.add(String.format("""
            { "field": "database_name", "operator": "=", "value": ["%s"] }""", databaseName));
        }

        if (businessDate != null && !businessDate.isBlank()) {
            filters.add(String.format("""
            { "field": "batch_id", "operator": "=", "value": ["%s"] }""", businessDate));
        }
        String filtersJson = String.join(",", filters);

        String filterJson = String.format(""" 
                {"table": "data_controls_log","filters": [%s]}""", filtersJson);
        /*String filterJson = String.format("""
                {
                  "table": "data_controls_log",
                  "filters": [
                    { "field": "database_name", "operator": "=", "value": ["%s"] },
                    { "field": "table_name", "operator": "=", "value": ["%s"] },
                    { "field": "batch_id", "operator": "=", "value": ["%s"] }
                  ]
                }
                """, databaseName, tableName, businessDate);*/

        ResponseWrapper<List<DataControlsLog>, ErrorResponse> response =
                consumer.post(filterApiUrl, filterJson, new TypeReference<List<DataControlsLog>>() {},
                        new TypeReference<ErrorResponse>() {});

        if (response.isSuccess()) {
            List<DataControlsLog> rows = response.getSuccessBody();
            Set<commonsFunctions.DataControlKey> seen = new HashSet<>();
            deduplicated = rows.stream()
                    .filter(row -> seen.add(new commonsFunctions.DataControlKey(
                            row.getDatabaseName(),
                            row.getTableName(),
                            row.getRuleName(),
                            row.getRuleColumn(),
                            row.getSchemaName()
                    )))
                    .toList();

        }

        return deduplicated;
    }

    public static List<SqlAssertionInfo> generateAssertionsFromRow(DataControlsLog rowData, String entityUrn)
            throws URISyntaxException {
        String database = rowData.getDatabaseName();
        String schema = rowData.getSchemaName();
        String table = rowData.getTableName();
        String column = rowData.getRuleColumn();
        String ruleName = rowData.getRuleName();
        String ruleValue = rowData.getRuleValue();

        List<SqlAssertionInfo> assertions = new ArrayList<>();
        String fullTable = String.format("%s.%s.%s", database, schema, table);
        String columnExpr = String.format("\"%s\"", column); // escape column name

        switch (ruleName) {
            case "isComplete":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "COUNT(*) - COUNT(" + columnExpr + ")", "=", "0", SqlAssertionType.METRIC));
                break;

            case "isUnique":
                assertions.add(buildAssertion(entityUrn,fullTable, column, columnExpr + " IS NOT NULL GROUP BY " + columnExpr + " HAVING COUNT(*) > 1", "=", "0", SqlAssertionType.METRIC, true));
                break;

            case "isNonNegative":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "COUNT(*) - COUNT(" + columnExpr + ")", ">=", "0", SqlAssertionType.METRIC));
                assertions.add(buildAssertion(entityUrn,fullTable, column, "MIN(CAST(" + columnExpr + " AS DOUBLE))", ">=", "0", SqlAssertionType.METRIC));
                break;

            case "isPositive":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "MIN(CAST(" + columnExpr + " AS DOUBLE))", ">", "0", SqlAssertionType.METRIC));
                break;

            case "isLessThan":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "MAX(CAST(" + columnExpr + " AS DOUBLE))", "<", ruleValue, SqlAssertionType.METRIC));
                break;

            case "isLessThanOrEqualTo":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "MAX(CAST(" + columnExpr + " AS DOUBLE))", "<=", ruleValue, SqlAssertionType.METRIC));
                break;

            case "isGreaterThan":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "MIN(CAST(" + columnExpr + " AS DOUBLE))", ">", ruleValue, SqlAssertionType.METRIC));
                break;

            case "isGreaterThanOrEqualTo":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "MIN(CAST(" + columnExpr + " AS DOUBLE))", ">=", ruleValue, SqlAssertionType.METRIC));
                break;

            case "hasMin":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "MIN(CAST(" + columnExpr + " AS DOUBLE))", "=", ruleValue, SqlAssertionType.METRIC_CHANGE));
                break;

            case "hasMax":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "MAX(CAST(" + columnExpr + " AS DOUBLE))", "=", ruleValue, SqlAssertionType.METRIC_CHANGE));
                break;

            case "hasMean":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "AVG(CAST(" + columnExpr + " AS DOUBLE))", "=", ruleValue, SqlAssertionType.METRIC_CHANGE));
                break;

            case "hasSum":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "SUM(CAST(" + columnExpr + " AS DOUBLE))", "=", ruleValue, SqlAssertionType.METRIC_CHANGE));
                break;

            case "hasStandardDeviation":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "STDDEV(CAST(" + columnExpr + " AS DOUBLE))", "=", ruleValue, SqlAssertionType.METRIC_CHANGE));
                break;

            case "hasSize":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "COUNT(*)", "=", ruleValue, SqlAssertionType.METRIC_CHANGE));
                break;

            case "hasApproxCountDistinct":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "APPROX_COUNT_DISTINCT(" + columnExpr + ")", "=", ruleValue, SqlAssertionType.METRIC_CHANGE));
                break;

            case "hasDataType":
                assertions.add(buildAssertion(entityUrn,fullTable, column, "MAX(typeof(" + columnExpr + "))", "=", ruleValue, SqlAssertionType.METRIC_CHANGE));
                break;

            case "hasUniqueness":
            case "hasDistinctness":
            case "hasUniqueValueRatio":
                assertions.add(buildAssertion(entityUrn,fullTable, column,
                        "COUNT(DISTINCT " + columnExpr + ") * 1.0 / COUNT(*)",
                        ">=", ruleValue, SqlAssertionType.METRIC_CHANGE));
                break;

            case "containsEmail":
                assertions.add(buildAssertion(entityUrn,fullTable, column,
                        "SUM(CASE WHEN " + columnExpr + " ~* '^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$' THEN 1 ELSE 0 END) * 1.0 / COUNT(*)",
                        ">=", ruleValue, SqlAssertionType.METRIC));
                break;

            case "containsURL":
                assertions.add(buildAssertion(entityUrn,fullTable, column,
                        "SUM(CASE WHEN " + columnExpr + " ~* '^(http|https)://' THEN 1 ELSE 0 END) * 1.0 / COUNT(*)",
                        ">=", ruleValue, SqlAssertionType.METRIC));
                break;

            case "containsCreditCardNumber":
                assertions.add(buildAssertion(entityUrn,fullTable, column,
                        "SUM(CASE WHEN " + columnExpr + " ~* '^(?:\\d[ -]*?){13,16}$' THEN 1 ELSE 0 END) * 1.0 / COUNT(*)",
                        ">=", ruleValue, SqlAssertionType.METRIC));
                break;

            case "containsSocialSecurityNumber":
                assertions.add(buildAssertion(entityUrn,fullTable, column,
                        "SUM(CASE WHEN " + columnExpr + " ~* '^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$' THEN 1 ELSE 0 END) * 1.0 / COUNT(*)",
                        ">=", ruleValue, SqlAssertionType.METRIC));
                break;

            case "hasMinLength":
                assertions.add(buildAssertion(entityUrn,fullTable, column,
                        "MIN(CHAR_LENGTH(" + columnExpr + "))",
                        ">=", ruleValue, SqlAssertionType.METRIC_CHANGE));
                break;

            case "hasMaxLength":
                assertions.add(buildAssertion(entityUrn,fullTable, column,
                        "MAX(CHAR_LENGTH(" + columnExpr + "))",
                        "<=", ruleValue, SqlAssertionType.METRIC_CHANGE));
                break;

            case "hasApproxQuantile":
                // rule_value example: "0.5,100" → quantile=0.5, expected_value=100
                String[] quantileParts = ruleValue.split(",");
                if (quantileParts.length >= 2) {
                    String quantile = quantileParts[0].trim();
                    String expectedValue = quantileParts[1].trim();
                    String expression = String.format("APPROX_QUANTILE(%s, %s)", columnExpr, quantile);
                    assertions.add(buildAssertion(entityUrn,fullTable, column, expression, "=", expectedValue, SqlAssertionType.METRIC_CHANGE));
                }
                break;

            case "hasMutualInformation":
                // rule_value example: "other_col,0.85" → otherCol=other_col, expectedMI=0.85
                String[] miParts = ruleValue.split(",");
                if (miParts.length >= 2) {
                    String otherCol = miParts[0].trim();
                    String expectedMI = miParts[1].trim();
                    String expression = String.format("MUTUAL_INFORMATION(%s, %s)", columnExpr, otherCol);
                    assertions.add(buildAssertion(entityUrn,fullTable, column, expression, ">=", expectedMI, SqlAssertionType.METRIC_CHANGE));
                }
                break;

            case "isContainedIn":
                // Split and quote values
                String[] allowedValues = ruleValue.split(",");
                String inClause = Arrays.stream(allowedValues)
                        .map(String::trim)
                        .map(val -> "'" + val.replace("'", "''") + "'")
                        .collect(Collectors.joining(", "));
                String expr = columnExpr + " NOT IN (" + inClause + ")";
                assertions.add(buildAssertion(entityUrn,fullTable, column, "COUNT(*) FILTER (WHERE " + expr + ")", "=", "0", SqlAssertionType.METRIC));
                break;
            default:
                System.out.println("Unhandled rule: " + ruleName);
        }
        return assertions;
    }

    private static SqlAssertionInfo buildAssertion(String entityUrn,
                                                   String table, String column, String metricSql, String operator,
                                                   String value, SqlAssertionType type
    ) throws URISyntaxException {
        return buildAssertion(entityUrn, table, column, metricSql, operator, value, type, false);
    }


    private static SqlAssertionInfo buildAssertion(String entityUrn,
                                                   String table, String column, String metricSql, String operator,
                                                   String value, SqlAssertionType type, boolean isHavingClause
    ) throws URISyntaxException {
        AssertionStdParameters params = new AssertionStdParameters()
                .setValue(new AssertionStdParameter().setValue(value).setType(AssertionStdParameterType.STRING));

        String sql;
        if (isHavingClause) {
            sql = String.format("SELECT COUNT(*) FROM (SELECT %s FROM %s GROUP BY %s HAVING COUNT(*) > 1) t", column, table, column);
        } else {
            sql = String.format("SELECT %s FROM %s", metricSql, table);
        }
        return new SqlAssertionInfo()
                .setOperator(AssertionStdOperator.valueOf(
                        operator
                                .replace(">=", "GREATER_THAN_OR_EQUAL_TO")
                                .replace("<=", "LESS_THAN_OR_EQUAL_TO")
                                .replace("=", "EQUAL_TO")
                                .replace("<", "LESS_THAN")
                                .replace(">", "GREATER_THAN")
                ))
                .setChangeType(AssertionValueChangeType.ABSOLUTE)
                .setEntity(Urn.createFromString(entityUrn))
                .setStatement(sql)
                .setType(type)
                .setParameters(params);
    }
}
