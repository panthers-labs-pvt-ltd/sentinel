package org.pantherslabs.chimera.sentinel.datahub.tag;

import com.linkedin.mxe.MetadataChangeProposal;
import com.linkedin.tag.TagProperties;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.common.genericUtils.*;

public class ManageTags {
        public static String createTags(String tagName, String tagDescription) throws IOException,
            ExecutionException, InterruptedException {
        String entityUrn = "urn:li:tag:" + replaceSpecialCharsAndLowercase(tagName);
        TagProperties tagProperties =
                new TagProperties()
                        .setName(tagName)
                        .setDescription(tagDescription).setColorHex("#77fb71");

        MetadataChangeProposal proposal = createProposal(entityUrn, TAG_ENTITY_NAME,
                TAG_PROPERTIES_ASPECT_NAME, ACTION_TYPE, tagProperties);
        return emitProposal(proposal, TAG_ENTITY_NAME);

    }
}
