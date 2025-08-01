package org.pantherslabs.chimera.sentinel.datahub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.linkedin.common.urn.GlossaryNodeUrn;
import com.linkedin.data.template.StringMap;
import com.linkedin.glossary.GlossaryNodeInfo;
import com.linkedin.mxe.MetadataChangeProposal;

import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.pantherslabs.chimera.sentinel.datahub.dto.GlossaryNodeGroup;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.buildProposal;

@Service
public class GlossaryNodesService {
    List<MetadataChangeProposal> proposals = new ArrayList<>();
    EmitResult result = null;
    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(GlossaryNodesService.class);

    public EmitResult createGlossaryNode(List<GlossaryNodeGroup> inGlossaryNodes, String actionType)
            throws Exception {

        for (GlossaryNodeGroup nodeGroup : inGlossaryNodes) {
            StringMap MapCustomProperties = new StringMap();
            GlossaryNodeUrn glossaryNodeUrn = new GlossaryNodeUrn(nodeGroup.name);

            GlossaryNodeInfo glossaryNodeInfo = new GlossaryNodeInfo()
                    .setName(nodeGroup.name)
                    .setId(glossaryNodeUrn.toString())
                    .setDefinition(nodeGroup.definition);

            // If there is a parentGlossaryNodeGroup, handle it recursively
            if (nodeGroup.parentGlossaryNodeGroup != null && nodeGroup.parentGlossaryNodeGroup.name != null
                    && !nodeGroup.parentGlossaryNodeGroup.name.isEmpty()) {
                glossaryNodeInfo.setParentNode(new GlossaryNodeUrn(nodeGroup.parentGlossaryNodeGroup.name));
                List<GlossaryNodeGroup> parentList = List.of(nodeGroup.parentGlossaryNodeGroup);
                createGlossaryNode(parentList, "CREATE");
            }

            if (nodeGroup.parentGlossaryNodeGroup != null && nodeGroup.parentGlossaryNodeGroup.Ownership != null
                    && !nodeGroup.parentGlossaryNodeGroup.Ownership.isEmpty()
                    && (nodeGroup.Ownership == null || nodeGroup.Ownership.isEmpty())) {

                Map<String, List<String>> owner=nodeGroup.parentGlossaryNodeGroup.Ownership;
               OwnershipService.createOwners(glossaryNodeUrn, GLOSSARY_NODE_ENTITY_NAME,
                       owner,"UPSERT");
            }

            if (nodeGroup.customProperties != null && !nodeGroup.customProperties.isEmpty()) {
                MapCustomProperties.putAll(nodeGroup.customProperties);
                glossaryNodeInfo.setCustomProperties(MapCustomProperties);
            }

            proposals.add(buildProposal(glossaryNodeUrn,GLOBAL_TAGS_ASPECT_NAME,glossaryNodeInfo,actionType));
            result= emitEvent(proposals);


            if (nodeGroup.Ownership != null && !nodeGroup.Ownership.isEmpty()) {
                OwnershipService.createOwners(glossaryNodeUrn, GLOSSARY_NODE_ENTITY_NAME,
                        nodeGroup.Ownership,"UPSERT");
            }
        }
        DatahubLogger.logInfo(inGlossaryNodes.size() + " glossary nodes processed.");
        return result;
    }

}
