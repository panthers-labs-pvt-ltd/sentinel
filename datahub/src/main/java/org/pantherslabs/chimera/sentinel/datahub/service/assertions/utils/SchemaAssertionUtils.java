package org.pantherslabs.chimera.sentinel.datahub.service.assertions.utils;

import com.linkedin.schema.*;
import org.pantherslabs.chimera.sentinel.datahub.dto.Field;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchemaAssertionUtils {
    public static List<ErrorResponse> compareSchemas(
            List<Field> inputSchema,
            List<SchemaField> existingFields,
            String requestURI // e.g., dataset URN or API path
    ) {
        List<ErrorResponse> errors = new ArrayList<>();
        String errorTimestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Map<String, SchemaField> fieldMap = new HashMap<>();
        for (SchemaField f : existingFields) {
            fieldMap.put(f.getFieldPath().toLowerCase(), f);
        }

        for (Field inputField : inputSchema) {
            String fieldName = inputField.getName().toLowerCase();
            if (!fieldMap.containsKey(fieldName)) {
                errors.add(new ErrorResponse(errorTimestamp,
                        "FIELD_MISSING",
                        requestURI,
                        "Field missing in dataset: " + inputField.getName(),
                        "ERR_SCHEMA_MISSING_FIELD"
                ));
                continue;
            }

            SchemaField existingField = fieldMap.get(fieldName);

            String existingType = normalizeType(existingField.getType().toString());
            String expectedType = normalizeType(inputField.getType());

            if (!expectedType.equals(existingType)) {
                errors.add(new ErrorResponse(errorTimestamp,
                        "TYPE_MISMATCH",
                        requestURI,
                        String.format("Type mismatch for field '%s': expected '%s', found '%s'",
                                inputField.getName(), expectedType, existingType),
                        "ERR_SCHEMA_TYPE_MISMATCH"
                ));
            }

            if (existingField.isNullable() != inputField.isNullable()) {
                errors.add(new ErrorResponse(errorTimestamp,
                        "NULLABILITY_MISMATCH",
                        requestURI,
                        String.format("Nullable mismatch for field '%s': expected '%s', found '%s'",
                                inputField.getName(), inputField.isNullable(), existingField.isNullable()),
                        "ERR_SCHEMA_NULLABILITY_MISMATCH"
                ));
            }
        }
        return  errors;
    }

    private static String normalizeType(String type) {
        switch (type.toLowerCase()) {
            case "int":
            case "integer":
                return "int";
            case "long":
                return "long";
            case "string":
                return "string";
            case "boolean":
                return "boolean";
            case "timestamp":
                return "timestamp";
            case "double":
                return "double";
            default:
                return type.toLowerCase();
        }
    }

    public static SchemaFieldDataType NativeTypeToSchemaType(Object value) {
        if (value == null) {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new NullType()));
        } else if (value instanceof Boolean) {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new BooleanType()));
        } else if (value instanceof byte[]) {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new BytesType()));
        } else if (value instanceof String) {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new StringType()));
        } else if (value instanceof Number) {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new NumberType()));
        } else if (value instanceof java.util.Date || value instanceof java.time.LocalDate) {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new DateType()));
        } else if (value instanceof java.time.LocalTime) {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new TimeType()));
        } else if (value.getClass().isEnum()) {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new EnumType()));
        } else if (value instanceof Map) {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new MapType()));
        } else if (value instanceof List || value.getClass().isArray()) {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new ArrayType()));
        } else if (value.getClass().isRecord()) {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new RecordType()));
        } else {
            return new SchemaFieldDataType().setType(SchemaFieldDataType.Type.create(new StringType()));
        }
    }
}
