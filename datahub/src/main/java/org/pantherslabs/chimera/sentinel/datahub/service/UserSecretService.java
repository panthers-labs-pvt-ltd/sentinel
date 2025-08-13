package org.pantherslabs.chimera.sentinel.datahub.service;

import java.net.URISyntaxException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linkedin.common.AuditStamp;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringMap;
import com.linkedin.mxe.MetadataChangeProposal;
import com.linkedin.mxe.SystemMetadata;
import com.linkedin.secret.DataHubSecretValue;
import org.pantherslabs.chimera.sentinel.datahub.commons.DataHubEntityClient;
import org.pantherslabs.chimera.sentinel.datahub.commons.SecretService;
import org.springframework.stereotype.Service;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.DataHubEntityClient.performEntityAction;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.SecretService.getK8sSecret;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.buildProposal;

@Service
public class UserSecretService {
    List<MetadataChangeProposal> proposals = new ArrayList<>();

    public void createSecret(String secretName, String secretValue, String secretDescription) throws Exception {
        Urn secretUrn = Urn.createFromString(DATAHUB_SECRET_URN_PREFIX + secretName);

        AuditStamp createdTs = new AuditStamp()
                .setTime(Instant.now().toEpochMilli())
                .setActor(new CorpuserUrn(DATAHUB_ACTOR));

        String rawKey = getK8sSecret("datahub-encryption-secrets",
                "default", "encryption_key_secret");
        SecretService svc = new SecretService(rawKey, false);
        String encryptedVal = svc.encrypt(secretValue);

        DataHubSecretValue dataHubSecretValue = new DataHubSecretValue().setCreated(createdTs)
                .setValue(encryptedVal)
                .setDescription(secretDescription)
                .setName(secretName);

        SystemMetadata systemMetadata = new SystemMetadata();
        Map<String, String> customProps = new HashMap<>();
        customProps.put("environment", "dev");
        customProps.put("team", "panthers");

        StringMap stringMap = new StringMap();
        stringMap.putAll(customProps);
        systemMetadata.setProperties(stringMap);
        proposals.add(buildProposal(secretUrn, SECRET_VALUE_ASPECT_NAME, dataHubSecretValue, UPSERT_ACTION_TYPE,
                systemMetadata));
        emitEvent(proposals);
    }

    public String getSecretValue(String secretName) throws URISyntaxException {
        Urn secretUrn = Urn.createFromString(DATAHUB_SECRET_URN_PREFIX + secretName);
        return  performEntityAction(DataHubEntityClient.Action.GET,
                DATAHUB_SECRET_ENTITY, String.valueOf(secretUrn), SECRET_VALUE_ASPECT_NAME);
    }


    public String deleteSecretValue(String secretName) throws URISyntaxException {
        Urn secretUrn = Urn.createFromString(DATAHUB_SECRET_URN_PREFIX + secretName);
        return  performEntityAction(DataHubEntityClient.Action.DELETE,
                DATAHUB_SECRET_ENTITY, String.valueOf(secretUrn), SECRET_VALUE_ASPECT_NAME);
    }
}
