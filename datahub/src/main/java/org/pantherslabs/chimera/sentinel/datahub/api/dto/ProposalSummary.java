package org.pantherslabs.chimera.sentinel.datahub.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@NoArgsConstructor

@Getter
@Setter
@Data
public class ProposalSummary {
    private String entityUrn;
    private String aspectName;

    public ProposalSummary(String entityUrn, String aspectName) {
        this.entityUrn = entityUrn;
        this.aspectName = aspectName;
    }

    // getters and setters
}
