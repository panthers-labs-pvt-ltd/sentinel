package org.pantherslabs.chimera.sentinel.datahub.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class GlossaryTerm {

    public GlossaryTerm(){}

    public GlossaryTerm(String glossaryTermName, String documentations, String parentTermName, String sourceRef,
                        String sourceURL, GlossaryNodeGroup glossaryNodeRecord, List<GlossaryRelatedTerm>
                                GlossaryRelatedTermsRecord, Map<String, String> customProperties) {
        this.glossaryTermName = glossaryTermName;
        this.documentations = documentations;
        this.parentTermName = parentTermName;
        this.sourceRef = sourceRef;
        this.sourceURL = sourceURL;
        this.glossaryNodeRecord = glossaryNodeRecord;
        this.GlossaryRelatedTermsRecord = GlossaryRelatedTermsRecord;
        this.customProperties = customProperties;
    }

    private String glossaryTermName;
    private String documentations;
    private String parentTermName;
    private String sourceRef;
    private String sourceURL;
    private GlossaryNodeGroup glossaryNodeRecord;
    private List<GlossaryRelatedTerm> GlossaryRelatedTermsRecord;
    private Map<String, String> customProperties;


}
