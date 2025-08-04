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

    public static <E extends Enum<E>> boolean isValid(Class<E> enumClass, Object value) {
        if (value == null) {
            return false;
        }

        String stringValue = value instanceof Enum<?> ? ((Enum<?>) value).name() : value.toString();

        for (E enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.name().equalsIgnoreCase(stringValue)) {
                return true;
            }
        }
        return false;
    }


    public static record DataControlKey(String databaseName, String tableName, String ruleName,
                                        String ruleColumn,String schemaName) {}

    public static  DataControlKey parseDatasetName(String datasetName) {
        String[] parts = datasetName.split("\\.");

        String databaseName;
        String schema = null;
        String tableName;
        if (parts.length == 1) {
            // Format: database.table
            databaseName = null;
            tableName = parts[0];
        }
        else if (parts.length == 2) {
            // Format: database.table
            databaseName = parts[0];
            tableName = parts[1];
        } else if (parts.length == 3) {
            // Format: database.schema.table
            databaseName = parts[0];
            schema = parts[1];
            tableName = parts[2];
        } else {
            throw new IllegalArgumentException("Invalid dataset name format: " + datasetName);
        }

        return new  DataControlKey(databaseName, tableName, null, null,schema);
    }

}