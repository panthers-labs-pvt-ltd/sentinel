package org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils;

import com.linkedin.assertion.*;
import com.linkedin.common.UrnArray;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringMap;

import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.DATASET_FIELD_URN_PREFIX;

public class DataAssertionsUtils {

    private static String generateLogic(AssertionStdAggregation agg, AssertionStdOperator op,
                                        Map<String, String> params) {
        String field = agg.name();
        return switch (op) {
            case BETWEEN -> field + " BETWEEN " + params.get("minValue") + " AND " + params.get("maxValue");
            case IN, NOT_IN -> field + " " + op.name() + " (" + params.get("value") + ")";
            case NULL, NOT_NULL, IS_TRUE, IS_FALSE -> field + " IS " + op.name().replace("_", " ");
            default -> field + " " + op.name().replace("_", " ") + " " + params.get("value");
        };
    }
    public static DatasetAssertionInfo buildDatasetAssertionInfo(
            Urn datasetUrn,
            List<Urn> fieldUrns,
            DatasetAssertionScope scope,
            AssertionStdAggregation aggregation,
            AssertionStdOperator operator,
            Map<String, String> paramMap
    ) throws IllegalArgumentException {

        // Validate known incompatible or invalid combos
        Set<AssertionStdOperator> noParamOperators = Set.of(
                AssertionStdOperator.NULL,
                AssertionStdOperator.NOT_NULL,
                AssertionStdOperator.IS_TRUE,
                AssertionStdOperator.IS_FALSE
        );

        Set<AssertionStdOperator> singleParamOperators = Set.of(
                AssertionStdOperator.LESS_THAN,
                AssertionStdOperator.LESS_THAN_OR_EQUAL_TO,
                AssertionStdOperator.GREATER_THAN,
                AssertionStdOperator.GREATER_THAN_OR_EQUAL_TO,
                AssertionStdOperator.EQUAL_TO,
                AssertionStdOperator.NOT_EQUAL_TO,
                AssertionStdOperator.CONTAIN,
                AssertionStdOperator.END_WITH,
                AssertionStdOperator.START_WITH,
                AssertionStdOperator.REGEX_MATCH
        );

        Set<AssertionStdOperator> multiParamOperators = Set.of(
                AssertionStdOperator.BETWEEN,
                AssertionStdOperator.IN,
                AssertionStdOperator.NOT_IN
        );

        // Validate parameter combinations
        if (noParamOperators.contains(operator) && !paramMap.isEmpty()) {
            throw new IllegalArgumentException("Operator " + operator + " does not accept parameters.");
        }

        if (singleParamOperators.contains(operator) && !paramMap.containsKey("value")) {
            throw new IllegalArgumentException("Operator " + operator + " requires 'value' parameter.");
        }

        if (operator == AssertionStdOperator.BETWEEN &&
                (!paramMap.containsKey("minValue") || !paramMap.containsKey("maxValue"))) {
            throw new IllegalArgumentException("Operator BETWEEN requires 'minValue' and 'maxValue' parameters.");
        }

        if ((operator == AssertionStdOperator.IN || operator == AssertionStdOperator.NOT_IN) &&
                !paramMap.containsKey("value")) {
            throw new IllegalArgumentException("Operator " + operator + " requires a 'value' parameter (comma-separated values).");
        }

        // Optional: Additional scope-aggregation validation can be added here

        UrnArray urnArray = new UrnArray(fieldUrns);

        // Build DatasetAssertionInfo
        DatasetAssertionInfo info = new DatasetAssertionInfo()
                .setDataset(datasetUrn)
                .setAggregation(aggregation)
                .setLogic(generateLogic(aggregation, operator, paramMap))
                .setFields(urnArray)
                .setOperator(operator)
                .setNativeType(aggregation.name())
                .setScope(scope);

        if (!paramMap.isEmpty()) {
            info.setNativeParameters(new StringMap(paramMap));
        }
        return info;
    }

    public static List<Urn> getFieldUrns(List<String> columnList,String datasetUrnStr) {
        return columnList.stream()
                .map(field -> {
                    try {
                        return Urn.createFromString(String.format("%s(%s,%s)", DATASET_FIELD_URN_PREFIX, datasetUrnStr, field));
                    } catch (URISyntaxException e) {
                        throw new RuntimeException("Invalid URN for field: " + field, e);
                    }
                })
                .collect(Collectors.toList());
    }
    public static boolean validateExpectedVsActual(DatasetAssertionInfo info, long actualValue)
    {
        long expectedValue = 0;
        String operator="";
        Object assertionObj = info.data().get("datasetAssertion");
        if (assertionObj instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> assertionMap = (Map<String, Object>) assertionObj;
            Object nativeParamsObj = assertionMap.get("nativeParameters");
            Object operatorObj = assertionMap.get("operator");

            if (nativeParamsObj instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> nativeParamsMap = (Map<String, Object>) nativeParamsObj;
                String expectedValueStr = String.valueOf(nativeParamsMap.get("value"));

                expectedValue = Long.parseLong(expectedValueStr);
                System.out.println("Expected value: " + expectedValue);
            }
            if (operatorObj instanceof String) {
                operator = (String) operatorObj;
                System.out.println("Operator: " + operator);
            }
        }
        long expected = Long.parseLong(String.valueOf(expectedValue));
        return compare(actualValue,operator , expected);
    }


    public static boolean compare(long actual, String op, long expected) {
        return switch (op.toUpperCase(Locale.ROOT)) {
            case "EQUAL_TO" -> actual == expected;
            case "GREATER_THAN" -> actual > expected;
            case "LESS_THAN" -> actual < expected;
            case "GREATER_THAN_OR_EQUAL_TO" -> actual >= expected;
            case "LESS_THAN_OR_EQUAL_TO" -> actual <= expected;
            case "NOT_EQUAL_TO" -> actual != expected;
            default -> throw new UnsupportedOperationException("Unsupported operator: " + op);
        };
    }

}
