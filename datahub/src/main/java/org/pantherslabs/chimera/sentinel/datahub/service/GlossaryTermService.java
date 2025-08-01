package org.pantherslabs.chimera.sentinel.datahub.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.linkedin.common.GlossaryTermUrnArray;
import com.linkedin.common.url.Url;
import com.linkedin.common.urn.GlossaryNodeUrn;
import com.linkedin.common.urn.GlossaryTermUrn;
import com.linkedin.glossary.GlossaryRelatedTerms;
import com.linkedin.glossary.GlossaryTermInfo;
import com.linkedin.mxe.MetadataChangeProposal;

import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.dto.ErrorDetails;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import org.pantherslabs.chimera.sentinel.datahub.dto.GlossaryTerm;
import org.pantherslabs.chimera.sentinel.datahub.dto.GlossaryRelatedTerm;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.GLOSSARY_RELATED_TERM_ASPECT_NAME;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.buildProposal;


@Service
public class GlossaryTermService {
    static List<MetadataChangeProposal> proposals = new ArrayList<>();

    public EmitResult createGlossaryTerm(List<GlossaryTerm> glossaryTerms,String actionType) throws Exception {
        EmitResult result = null;
        for (GlossaryTerm glossaryTerm : glossaryTerms) {

            if (glossaryTerm.getGlossaryTermName() == null || glossaryTerm.getGlossaryTermName().isEmpty()) {
                new EmitResult(false, new ErrorDetails(500, "Glossary term name is required."));
            }
            if (glossaryTerm.getDocumentations() == null || glossaryTerm.getDocumentations().isEmpty()) {
                new EmitResult(false, new ErrorDetails(500, "Glossary term definition is required."));
            }
            GlossaryTermUrn glossaryNodeUrn = new GlossaryTermUrn(glossaryTerm.getGlossaryTermName());

            GlossaryTermInfo termInfo = new GlossaryTermInfo()
                    .setId(glossaryNodeUrn.getNameEntity())
                    .setName(glossaryTerm.getGlossaryTermName())
                    .setDefinition(glossaryTerm.getDocumentations())
                    .setTermSource(glossaryTerm.getSourceRef());

            if (glossaryTerm.getSourceURL() != null && !glossaryTerm.getSourceURL().isEmpty()) {
                termInfo.setSourceUrl(new Url(glossaryTerm.getSourceURL()));
            }

            if (glossaryTerm.getGlossaryNodeRecord() != null && !glossaryTerm.getGlossaryNodeRecord().name.isEmpty()) {
                // createGlossaryNode()
                termInfo.setParentNode(new GlossaryNodeUrn(glossaryTerm.getGlossaryNodeRecord().name));
            }

            proposals.add(buildProposal(glossaryNodeUrn,GLOSSARY_TERM_INFO_ASPECT_NAME,termInfo,actionType));

            GlossaryRelatedTerms relatedTerms = new GlossaryRelatedTerms();
            if (glossaryTerm.getGlossaryRelatedTermsRecord() != null && !glossaryTerm.getGlossaryRelatedTermsRecord().isEmpty()) {
                for (GlossaryRelatedTerm glossaryRelatedTerm : glossaryTerm.getGlossaryRelatedTermsRecord()) {
                    if (glossaryRelatedTerm.getRelatedTermName() != null && glossaryRelatedTerm.getRelatedTermName().length > 0) {
                        GlossaryTermUrnArray contains = new GlossaryTermUrnArray();
                        GlossaryTermUrnArray inherits = new GlossaryTermUrnArray();
                        GlossaryTermUrnArray containedBy = new GlossaryTermUrnArray();
                        GlossaryTermUrnArray inheritedBy = new GlossaryTermUrnArray();

                        for (String termName : glossaryRelatedTerm.getRelatedTermName()) {
                            if ("INHERITED BY".equalsIgnoreCase(glossaryRelatedTerm.getRelationType().trim())) {
                                inheritedBy.add(new GlossaryTermUrn(termName));
                            } else if ("CONTAINED BY".equalsIgnoreCase(glossaryRelatedTerm.getRelationType().trim())) {
                                containedBy.add(new GlossaryTermUrn(termName));
                            } else if ("INHERITS".equalsIgnoreCase(glossaryRelatedTerm.getRelationType().trim())) {
                                inherits.add(new GlossaryTermUrn(termName));
                            } else {
                                contains.add(new GlossaryTermUrn(termName));
                            }
                        }

                        relatedTerms.setValues(contains);
                        relatedTerms.setIsRelatedTerms(containedBy);
                        relatedTerms.setHasRelatedTerms(inheritedBy);
                        relatedTerms.setRelatedTerms(inherits);
                    }
                }
            }
            proposals.add(buildProposal(glossaryNodeUrn,GLOSSARY_RELATED_TERM_ASPECT_NAME,relatedTerms,actionType));

           result = emitEvent(proposals);
        }
        return result;
    }
}
