package org.pantherslabs.chimera.sentinel.datahub.commons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.pantherslabs.chimera.sentinel.datahub.commons.SecretService.getK8sSecret;
import static org.testng.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;

import org.pantherslabs.chimera.sentinel.datahub.service.UserSecretService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class UserSecretServiceTest {

    private static final String TEST_SECRET = "test-secret-key-12345";
    private static final String ALTERNATIVE_SECRET = "different-secret-key-67890";

    @Test
    public void testEncryptDecrypt() {
        String encryptionKey = "jTrMtUY8iKKcHuQHqwdC"; // <-- this is the same secret key GMS uses
        boolean allowLegacy = false;
        SecretService secretService = new SecretService(encryptionKey, allowLegacy);
        String original = "Vishesha";
        String encrypted = secretService.encrypt(original);
        System.out.println("Encrypted: " + encrypted);
        String decrypted = secretService.decrypt(encrypted);
        System.out.println("decrypted: " + decrypted);

        //Read The Secret from K8
        String rawKey = getK8sSecret("datahub-encryption-secrets" ,
                "default","encryption_key_secret");
        // 2) Construct the service (v1 disabled, UI uses v2/AES-GCM)
        SecretService svc = new SecretService(rawKey, false);

        // 3) Encrypt exactly as DataHub does
        String ciphertext = svc.encrypt("Vishesha");
        System.out.println("Encrypted (v2): " + ciphertext);
        String decrypted1 = svc.decrypt(ciphertext);
        System.out.println("decrypted:1 " + decrypted1);
    }
    @Test
    public void deleteTest() throws URISyntaxException {
        UserSecretService USS = new UserSecretService();
        String retVal = USS.deleteSecretValue("NewSecret");
        System.out.println("retVal:1 " + retVal);
    }
    @Test
    public void GetSecretTest() throws URISyntaxException {
        UserSecretService USS = new UserSecretService();
        String retVal = USS.getSecretValue("NewSecret");
        System.out.println("retVal:1 " + retVal);
    }

}
