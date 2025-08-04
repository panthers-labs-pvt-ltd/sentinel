package org.pantherslabs.chimera.sentinel.datahub.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class GlobalTags {
    // Getters and Setters
    private String entityUrn;
    private Map<String, String> tagNames;
    private String actionType;

    public void setEntityUrn(String entityUrn) {
        this.entityUrn = entityUrn;
    }

    public void setTagNames(Map<String, String> tagNames) {
        this.tagNames = tagNames;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
}
