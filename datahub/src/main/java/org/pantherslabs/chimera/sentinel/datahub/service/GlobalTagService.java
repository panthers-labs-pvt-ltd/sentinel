package org.pantherslabs.chimera.sentinel.datahub.service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.linkedin.common.GlobalTags;
import com.linkedin.common.MetadataAttribution;
import com.linkedin.common.TagAssociation;
import com.linkedin.common.TagAssociationArray;
import com.linkedin.common.urn.TagUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringMap;
import com.linkedin.events.metadata.ChangeType;
import com.linkedin.mxe.MetadataChangeProposal;

import org.pantherslabs.chimera.sentinel.datahub.commons.DataHubEntityClient;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.dto.ErrorDetails;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.buildProposal;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.serializeAspect;

@Service
public class GlobalTagService {
    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(GlobalTagService.class);
    List<MetadataChangeProposal> proposals = new ArrayList<>();

    public EmitResult createGlobalTags(String entityUrn, Map<String, String> tagNames, String actionType)
            throws Exception {
        DatahubLogger.logInfo("Processing Global Tags..");
        StringMap sourceMap = new StringMap();
        sourceMap.put("CompanyName","Panthers Labs");
        sourceMap.put("ProductName","Chimera");

        TagAssociationArray tagAssociationArray = new TagAssociationArray();

        MetadataAttribution metadataAttribution = new MetadataAttribution()
                .setActor(Urn.createFromString(DATAHUB_ACTOR))
                .setSource(Urn.createFromString(SYSTEM_ACTOR))
                .setSourceDetail(sourceMap)
                .setTime(System.currentTimeMillis());

        for (Map.Entry<String, String> entry : tagNames.entrySet()) {
            String tagName = entry.getKey();
            String context = entry.getValue();

            TagUrn tagUrn = new TagUrn(tagName);
            TagAssociation tagAssociation = new TagAssociation()
                    .setTag(tagUrn)
                    .setContext(context)
                    .setAttribution(metadataAttribution);
            tagAssociationArray.add(tagAssociation);
        }

        GlobalTags globalTags = new GlobalTags().setTags(tagAssociationArray);
        proposals.add(buildProposal(Urn.createFromString(entityUrn),GLOBAL_TAGS_ASPECT_NAME,globalTags,actionType));
        return emitEvent(proposals);
    }

    //TODO
    public EmitResult deleteGlobalTags(Urn entityUrn, List<String> tagNamesToRemove) throws Exception {
        // Step 1: Assume you already have current global tags loaded
        GlobalTags currentTags = getCurrentGlobalTags(entityUrn.toString()); // You must implement this

        if (!currentTags.hasTags()) {
            new EmitResult(false, new ErrorDetails(500, "Exception No tags present to remove."));
             }

        // Step 2: Filter out tags to remove
        List<TagAssociation> filteredTags = currentTags.getTags().stream()
                .filter(tagAssociation -> {
                    String tagName = (tagAssociation.getTag()).getName();
                    return !tagNamesToRemove.contains(tagName);
                })
                .collect(Collectors.toList());

        // Step 3: Build updated GlobalTags object
        GlobalTags updatedTags = new GlobalTags();
        updatedTags.setTags(new TagAssociationArray(filteredTags));

        // Step 4: Create MetadataChangeProposal
        MetadataChangeProposal proposal = new MetadataChangeProposal();
        proposal.setEntityUrn(entityUrn);
        proposal.setEntityType(entityUrn.getEntityType());
        proposal.setAspectName("globalTags");
        proposal.setAspect(serializeAspect(updatedTags));
        proposal.setChangeType(ChangeType.UPSERT); // or

        return emitEvent(proposals);
    }

    // Stub method — replace with logic to fetch the current global tags (e.g. from cache or a REST call)
    public GlobalTags getCurrentGlobalTags(String entityUrn) throws URISyntaxException {
        List<String> aspects = List.of("globalTags");

        String entityType=Urn.createFromString(entityUrn).getEntityType();

        int gt = DataHubEntityClient.performAction(DataHubEntityClient.Action.GET, entityType, entityUrn,
                true, aspects);
          System.out.println(gt);
        return new  GlobalTags();
    }
}

