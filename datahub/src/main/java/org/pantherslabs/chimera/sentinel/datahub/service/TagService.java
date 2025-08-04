package org.pantherslabs.chimera.sentinel.datahub.service;

import com.linkedin.common.urn.Urn;
import com.linkedin.mxe.MetadataChangeProposal;
import com.linkedin.tag.TagProperties;
import org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.buildProposal;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.replaceSpecialCharsAndLowercase;

@Service
public class TagService {
    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(TagService.class);
    List<MetadataChangeProposal> proposals = new ArrayList<>();
    EmitResult result = null;

    public EmitResult createTags(Map<String, String> tagNames, String actionType)
            throws Exception {
        DatahubLogger.logInfo("Processing Tags..");
        for (Map.Entry<String, String> entry : tagNames.entrySet()) {
            String tagName = entry.getKey();
            String tagDescription = entry.getValue();

            String entityUrn = TAG_URN_PREFIX + replaceSpecialCharsAndLowercase(tagName);
            TagProperties tagProperties =
                    new TagProperties()
                            .setName(tagName)
                            .setDescription(tagDescription).setColorHex("#77fb71");

            proposals.add(buildProposal(Urn.createFromString(entityUrn),TAG_PROPERTIES_ASPECT_NAME,tagProperties,actionType));
        }
        EventEmitter txEmitter = new EventEmitter();
        result = txEmitter.emitWithRollback(proposals);
        return result;
    }
}
