package org.pantherslabs.chimera.sentinel.datahub.service;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class DataHubSecretDecryptor {

    public static void main(String[] args) {
        try {
            // Encrypted string (must start with "v2:")
            String encryptedSecret = "v2:z7ItgGLDzVg8yYz2RByT7s04Y6ZqawtSFlGHHEHvorBbTBqwIow=";

            // Original encryption key from DataHub secret (as plain string)
            String originalKey = "panthersLabsPrivateLtd@280216!11";

            // Step 1: Normalize the key using SHA-256 to get 32 bytes
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] aesKey = digest.digest(originalKey.getBytes(StandardCharsets.UTF_8));

            // Step 2: Remove "v2:" prefix and decode Base64
            String base64Payload = encryptedSecret.substring(3); // Remove "v2:"
            byte[] decoded = Base64.getDecoder().decode(base64Payload);

            // Step 3: Extract IV (12 bytes) and ciphertext (rest)
            byte[] iv = Arrays.copyOfRange(decoded, 0, 12);
            byte[] ciphertext = Arrays.copyOfRange(decoded, 12, decoded.length);

            // Step 4: Decrypt using AES-GCM
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
            GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);

            cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmSpec);
            byte[] decrypted = cipher.doFinal(ciphertext);

            // Step 5: Print decrypted result
            String decryptedSecret = new String(decrypted, StandardCharsets.UTF_8);
            System.out.println("✅ Decrypted Secret: " + decryptedSecret);

        } catch (Exception e) {
            System.err.println("❌ Failed to decrypt: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
