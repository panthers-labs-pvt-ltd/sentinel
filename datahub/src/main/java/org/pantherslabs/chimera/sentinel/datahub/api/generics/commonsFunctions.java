package org.pantherslabs.chimera.sentinel.datahub.api.generics;

import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.events.metadata.ChangeType;
import com.linkedin.mxe.MetadataChangeProposal;

import javax.annotation.Nonnull;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.Base64.Encoder;
import java.util.stream.Collectors;

import static org.pantherslabs.chimera.sentinel.datahub.common.genericUtils.serializeAspect;

public class commonsFunctions {

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
        if (inputChangeType.toLowerCase(Locale.ROOT).contains("adelete"))
                return new MetadataChangeProposal()
                    .setEntityUrn(entityUrn)
                    .setEntityType(entityUrn.getEntityType())
                    .setAspectName(aspectName)
                    .setChangeType(resolvedChangeType);
        else
            return new MetadataChangeProposal()
                .setEntityUrn(entityUrn)
                .setEntityType(entityUrn.getEntityType())
                .setAspectName(aspectName)
                .setAspect(serializeAspect(aspect))
                .setChangeType(resolvedChangeType);

    }
}
