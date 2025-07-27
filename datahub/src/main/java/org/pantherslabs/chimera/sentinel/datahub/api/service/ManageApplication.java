package org.pantherslabs.chimera.sentinel.datahub.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linkedin.common.GlobalTags;
import com.linkedin.common.GlossaryTerms;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.ByteString;
import com.linkedin.mxe.GenericAspect;
import org.pantherslabs.chimera.sentinel.datahub.api.model.generated.MetadataAspectV2;
import org.pantherslabs.chimera.sentinel.datahub.domain.ManageDomain;
import org.pantherslabs.chimera.sentinel.datahub.emitter.TransactionalDataHubEmitter;
import org.pantherslabs.chimera.sentinel.datahub.modal.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.api.mapper.generated.MetadataAspectV2Mapper;

import org.pantherslabs.chimera.sentinel.datahub.modal.GlossaryTerm;
import org.pantherslabs.chimera.sentinel.datahub.modal.Owners;
import org.pantherslabs.chimera.sentinel.datahub.modal.Tag;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.ACTION_TYPE;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.DATASET_ENTITY_NAME;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.OWNERSHIP_ASPECT_NAME;
import static org.pantherslabs.chimera.sentinel.datahub.api.service.ManageUsersAndGroupsService.proposals;
import static org.pantherslabs.chimera.sentinel.datahub.common.genericUtils.replaceSpecialCharsAndLowercase;
import static org.pantherslabs.chimera.sentinel.datahub.datasets.schema.setGlobalTags;
import static org.pantherslabs.chimera.sentinel.datahub.datasets.schema.setGlossaryTerms;
import static org.pantherslabs.chimera.sentinel.datahub.ownership.ManageOwners.addOwners;
import static org.pantherslabs.chimera.sentinel.datahub.users.SecretService.buildProposal;

@Service
public class ManageApplication {
    @Autowired
    private  MetadataAspectV2Mapper metadataAspectV2Mapper;
    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(org.pantherslabs.chimera.sentinel.datahub.datasets.ManageDatasets.class);

    public  EmitResult createApplication(String appName, String appDescription,
                                         String actionType, String domainName, List<Tag> appTags,
                                         List<Owners>  ownersInfo, List<GlossaryTerm> glossaryTerms) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        EmitResult result;

        String appId = replaceSpecialCharsAndLowercase(appName);
        Urn appUrn = Urn.createFromString(APP_URN_PREFIX + appId);
        String aspectName = "applicationProperties";

        // Build JSON for applicationProperties
        Map<String, String> appProps = Map.of(
                "name", appName,
                "description", appDescription
        );
        String jsonString = objectMapper.writeValueAsString(appProps);

        // Prepare GenericAspect
        ByteString byteString = ByteString.unsafeWrap(jsonString.getBytes(StandardCharsets.UTF_8));
        GenericAspect genericAspect = new GenericAspect();
        genericAspect.setValue(byteString);
        genericAspect.setContentType("application/json");

        proposals.add(buildProposal(appUrn, aspectName, genericAspect, "UPSERT"));

        // Emit proposal
        TransactionalDataHubEmitter txEmitter = new TransactionalDataHubEmitter();
        result = txEmitter.emitWithRollback(proposals);

        // If success, update local metadata store
        if (result.isSuccess()) {
            MetadataAspectV2 updatedRow = new MetadataAspectV2();
            updatedRow.setUrn(appUrn.toString());
            updatedRow.setAspect(aspectName);
            updatedRow.setVersion(0L);
            updatedRow.setMetadata(jsonString);
            updatedRow.setCreatedby(DATAHUB_ACTOR);

            int updated = metadataAspectV2Mapper.updateByPrimaryKeySelective(updatedRow);
            System.out.println("Metadata rows updated: " + updated);
        }
        proposals.clear();
        GlobalTags globalTags = setGlobalTags(appTags);
        proposals.add(buildProposal(appUrn,GLOBAL_TAGS_ASPECT_NAME,globalTags,actionType));
        DatahubLogger.logInfo("DatasetGlobal Tags Metadata For Dataset Creation");

        GlossaryTerms glossaryTerm = setGlossaryTerms(glossaryTerms,"datahub");
        proposals.add(buildProposal(appUrn,GLOSSARY_TERMS_ASPECT_NAME,glossaryTerm,actionType));
        result = txEmitter.emitWithRollback(proposals);

        //TODO
        ManageDomain manageDomain = new ManageDomain();
        manageDomain.addDomain(domainName, appUrn.toString(), APPLICATION_ENTITY_NAME );
        DatahubLogger.logInfo("Domain Name Mapping For Application Created");

        //TODO
        Map<String, String> ownersMap = new HashMap<>();
        for (Owners owner : ownersInfo) {
            ownersMap.put(owner.getName(), owner.getType());
        }
        addOwners(appUrn, APPLICATION_ENTITY_NAME, OWNERSHIP_ASPECT_NAME, ACTION_TYPE, ownersMap);
        DatahubLogger.logInfo("Ownership Mapping For Dataset Creation Completed");


        return result;
    }

}
