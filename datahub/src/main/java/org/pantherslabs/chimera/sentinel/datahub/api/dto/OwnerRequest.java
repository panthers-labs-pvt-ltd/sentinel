package org.pantherslabs.chimera.sentinel.datahub.api.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OwnerRequest {
    private String entityUrn;
    private String entityType;
    private Map<String, List<String>> ownersInfo;
}