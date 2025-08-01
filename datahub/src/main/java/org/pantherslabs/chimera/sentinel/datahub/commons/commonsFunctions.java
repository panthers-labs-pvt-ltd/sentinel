package org.pantherslabs.chimera.sentinel.datahub.commons;
import com.linkedin.common.FabricType;
import com.linkedin.data.DataMap;
import com.linkedin.data.codec.JacksonDataCodec;
import javax.annotation.Nonnull;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Base64.Encoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.linkedin.common.urn.Urn;
import com.linkedin.data.ByteString;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.events.metadata.ChangeType;
import com.linkedin.mxe.GenericAspect;
import com.linkedin.mxe.MetadataChangeProposal;
import com.linkedin.mxe.SystemMetadata;
import com.linkedin.schema.*;
import datahub.shaded.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.pantherslabs.chimera.sentinel.datahub.dto.ErrorDetails;
import org.pantherslabs.chimera.sentinel.datahub.dto.Field;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;

import static java.time.LocalTime.now;


public class commonsFunctions {
    static ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(commonsFunctions.class);
    private static final JacksonDataCodec CODEC = new JacksonDataCodec();

    private static final int LOWERCASE_ASCII_START = 97;
    private static final int LOWERCASE_ASCII_END = 122;
    public static final String HASHING_ALGORITHM = "SHA-256";

    private static final SecureRandom _secureRandom = new SecureRandom();
    private static final Encoder _encoder = Base64.getEncoder();
    private static final Base64.Decoder _decoder = Base64.getDecoder();
    private static final MessageDigest _messageDigest;

    private static String _secret = "default-secret"; // Can be overridden

    static {
        try {
            _messageDigest = MessageDigest.getInstance(HASHING_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unable to create MessageDigest", e);
        }
    }

    public static <T> T getOrElse(T value, T defaultValue) {
        return (value != null) ? value : defaultValue;
    }

    public static void setSecret(String secret) {
        _secret = secret;
    }

    public static String encrypt(String value) {
        try {
            byte[] key = _secret.getBytes(StandardCharsets.UTF_8);
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // AES key length
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return _encoder.encodeToString(cipher.doFinal(value.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("Failed to encrypt value using provided secret!", e);
        }
    }

    public static String decrypt(String encryptedValue) {
        try {
            byte[] key = _secret.getBytes(StandardCharsets.UTF_8);
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(_decoder.decode(encryptedValue)), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Failed to decrypt value using provided secret!", e);
        }
    }

    public static String generateUrlSafeToken(int length) {
        return _secureRandom
                .ints(length, LOWERCASE_ASCII_START, LOWERCASE_ASCII_END + 1)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
    }

    public static byte[] generateSalt(int length) {
        byte[] randomBytes = new byte[length];
        _secureRandom.nextBytes(randomBytes);
        return randomBytes;
    }

    public static String hashString(@Nonnull final String str) {
        byte[] hashedBytes = _messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
        return _encoder.encodeToString(hashedBytes);
    }

    public static String getHashedPassword(@Nonnull byte[] salt, @Nonnull String password)
            throws IOException {
        byte[] saltedPassword = saltPassword(salt, password);
        byte[] hashedPassword = _messageDigest.digest(saltedPassword);
        return _encoder.encodeToString(hashedPassword);
    }

    private static byte[] saltPassword(@Nonnull byte[] salt, @Nonnull String password) throws IOException {
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(salt);
        byteArrayOutputStream.write(passwordBytes);
        return byteArrayOutputStream.toByteArray();
    }

    // ChangeType resolution logic for DataHub metadata updates
    private static final Map<String, Set<ChangeType>> ALLOWED_CHANGE_TYPES = new HashMap<>();

    static {
        ALLOWED_CHANGE_TYPES.put("corpuser", EnumSet.of(ChangeType.UPSERT, ChangeType.CREATE, ChangeType.CREATE_ENTITY));
        ALLOWED_CHANGE_TYPES.put("corpgroup", EnumSet.of(ChangeType.UPSERT, ChangeType.CREATE, ChangeType.CREATE_ENTITY));
        ALLOWED_CHANGE_TYPES.put("dataset", EnumSet.of(ChangeType.UPSERT, ChangeType.UPDATE, ChangeType.RESTATE, ChangeType.PATCH));
        ALLOWED_CHANGE_TYPES.put("dataflow", EnumSet.of(ChangeType.UPSERT, ChangeType.UPDATE));
        ALLOWED_CHANGE_TYPES.put("datajob", EnumSet.of(ChangeType.UPSERT, ChangeType.UPDATE));
        ALLOWED_CHANGE_TYPES.put("tag", EnumSet.of(ChangeType.UPSERT, ChangeType.CREATE, ChangeType.DELETE));
        ALLOWED_CHANGE_TYPES.put("glossaryterm", EnumSet.of(ChangeType.UPSERT, ChangeType.CREATE, ChangeType.DELETE));
        ALLOWED_CHANGE_TYPES.put("container", EnumSet.of(ChangeType.UPSERT, ChangeType.CREATE));
        ALLOWED_CHANGE_TYPES.put("domain", EnumSet.of(ChangeType.UPSERT, ChangeType.CREATE, ChangeType.DELETE));
        ALLOWED_CHANGE_TYPES.put("chart", EnumSet.of(ChangeType.UPSERT, ChangeType.CREATE, ChangeType.UPDATE, ChangeType.RESTATE));
        ALLOWED_CHANGE_TYPES.put("dashboard", EnumSet.of(ChangeType.UPSERT, ChangeType.CREATE, ChangeType.UPDATE));
        ALLOWED_CHANGE_TYPES.put("mlmodel", EnumSet.of(ChangeType.UPSERT, ChangeType.CREATE));
    }

    private static ChangeType resolveChangeType(String entityType, ChangeType inputChangeType) {
        Set<ChangeType> allowedTypes = ALLOWED_CHANGE_TYPES.get(entityType.toLowerCase());

        if (allowedTypes == null) {
            System.err.println("[WARN] Unknown entityType: " + entityType + ". Defaulting to UPSERT.");
            return ChangeType.UPSERT;
        }

        if (!allowedTypes.contains(inputChangeType)) {
            String message = String.format("[ERROR] ChangeType '%s' is not allowed for entityType '%s'. Allowed: %s",
                    inputChangeType, entityType, allowedTypes);
            System.err.println(message);
            throw new IllegalArgumentException(message);
        }

        return inputChangeType;
    }

    public static MetadataChangeProposal buildProposal(Urn entityUrn, String aspectName, RecordTemplate aspect,
                                                       String inputChangeType) throws Exception {
        ChangeType resolvedChangeType = resolveChangeType(entityUrn.getEntityType(), ChangeType.valueOf(inputChangeType));
        return new MetadataChangeProposal()
                .setEntityUrn(entityUrn)
                .setEntityType(entityUrn.getEntityType())
                .setAspectName(aspectName)
                .setAspect(serializeAspect(aspect))
                .setChangeType(resolvedChangeType);

    }
    public static MetadataChangeProposal buildProposal(Urn entityUrn, String entityType,String aspectName, RecordTemplate aspect,
                                                       String inputChangeType) throws Exception {
        ChangeType resolvedChangeType = resolveChangeType(entityUrn.getEntityType(), ChangeType.valueOf(inputChangeType));
        return new MetadataChangeProposal()
                .setEntityUrn(entityUrn)
                .setEntityType(entityType)
                .setAspectName(aspectName)
                .setAspect(serializeAspect(aspect))
                .setChangeType(resolvedChangeType);

    }

    public static MetadataChangeProposal buildProposal(Urn entityUrn, String aspectName, RecordTemplate aspect,
                                                       String inputChangeType, SystemMetadata SystemMetadataValue) throws Exception {
        ChangeType resolvedChangeType = resolveChangeType(entityUrn.getEntityType(), ChangeType.valueOf(inputChangeType));
        return new MetadataChangeProposal()
                .setEntityUrn(entityUrn)
                .setEntityType(entityUrn.getEntityType())
                .setAspectName(aspectName)
                .setAspect(serializeAspect(aspect))
                .setSystemMetadata(SystemMetadataValue)
                .setChangeType(resolvedChangeType);
    }

    public static GenericAspect serializeAspect(RecordTemplate aspect) throws Exception {
        DatahubLogger.logInfo("serializeAspect  " + aspect);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(aspect.data());
        System.out.println(jsonString);
        // ByteString byteString = ByteString.copyAvroString(jsonString, true);  // Serialize to ByteString
        ByteString byteString = ByteString.unsafeWrap(jsonString.getBytes(StandardCharsets.UTF_8));

        GenericAspect genericAspect = new GenericAspect();
        genericAspect.setValue(byteString);  // Set the serialized aspect
        genericAspect.setContentType("application/json");  // Content type
        DatahubLogger.logInfo("serializeAspect  " + aspect);
        return genericAspect;
    }

    public static String replaceSpecialCharsAndLowercase(String input) {
        if (input == null) {
            return null;
        }
        // Replace all non-alphanumeric characters with empty string
        String cleanedString = input.replaceAll("[^a-zA-Z0-9]", "");

        // Convert to lowercase and return
        return cleanedString.toLowerCase();
    }

    public static ErrorDetails extractErrorDetails(String json) {
        try {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            JsonNode root = mapper.readTree(json);

            int status = root.has("status") ? root.get("status").asInt() : -1;

            String message = root.has("message") ? root.get("message").asText() : "";
            String extractedMsg = extractMsgFromText(message);

            return new ErrorDetails(status, message + "-" + extractedMsg);
        } catch (Exception e) {
            return new ErrorDetails(-1, "Failed to parse error response: " + e.getMessage());
        }
    }

    private static String extractMsgFromText(String input) {
        Pattern pattern = Pattern.compile("msg=([^,)]+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "No validation message found.";
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

    // Convert DataMap to byte[]
    public static byte[] dataMapToBytes(DataMap map) throws Exception {
        return CODEC.mapToBytes(map);
    }

    // Convert byte[] to DataMap
    public static DataMap bytesToDataMap(byte[] bytes) throws Exception {
        return CODEC.bytesToMap(bytes);
    }

    public static boolean isValid(String value) {
        for (FabricType type : FabricType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

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

    public static String getHtmlError(List<ErrorResponse> matchStatus)
    {
        String executionDate = matchStatus.get(0).getErrorTimestamp();
        return  "<table border='1'><tr><th colspan='2'> Error Details </th>" +
                "<th colspan='2'> Execution Date %s </th></tr><tr><th>Type</th><th>Code</th>" +
                "<th colspan='2'>Message</th></tr>".formatted(executionDate) +
                matchStatus.stream().map(error ->
                        String.format("<tr><td>%s</td><td>%s</td><td colspan='2'>%s</td></tr>",
                                error.getErrorType(),error.getErrorCode(),error.getErrorMessage()))
                        .collect(Collectors.joining()) +
                "</table>";
   }
}