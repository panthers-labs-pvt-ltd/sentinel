package org.pantherslabs.chimera.sentinel.datahub.service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linkedin.common.urn.Urn;
import com.linkedin.data.ByteString;
import com.linkedin.mxe.GenericAspect;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.linkedin.mxe.MetadataChangeProposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.pantherslabs.chimera.sentinel.datahub.model.generated.MetadataAspectV2;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.mapper.generated.MetadataAspectV2Mapper;
import org.pantherslabs.chimera.sentinel.datahub.dto.GlossaryTerm;
import org.pantherslabs.chimera.sentinel.datahub.dto.Owners;
import org.pantherslabs.chimera.sentinel.datahub.dto.Tag;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.buildProposal;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.replaceSpecialCharsAndLowercase;


@Service
public class ApplicationService {
    @Autowired
    private  MetadataAspectV2Mapper metadataAspectV2Mapper;
    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(ApplicationService.class);
    static List<MetadataChangeProposal> proposals = new ArrayList<>();

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
        result = emitEvent(proposals);

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
  /*
        GlobalTags globalTags = setGlobalTags(appTags);
        proposals.add(buildProposal(appUrn,GLOBAL_TAGS_ASPECT_NAME,globalTags,actionType));
        DatahubLogger.logInfo("DatasetGlobal Tags Metadata For Dataset Creation");

      //TODO
         GlossaryTerms glossaryTerm = setGlossaryTerms(glossaryTerms,"datahub");
         proposals.add(buildProposal(appUrn,GLOSSARY_TERMS_ASPECT_NAME,glossaryTerm,actionType));
         result = emitEvent(proposals);

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
        DatahubLogger.logInfo("Ownership Mapping For Dataset Creation Completed");*/


        return result;
    }

}
