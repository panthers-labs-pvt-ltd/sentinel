package org.pantherslabs.chimera.sentinel.datahub.api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;
@Getter
@Setter
public class Domains {
    @NotNull
    String name;
    @NotNull String documentation;
    @Null
    String parentDomain;
    @Null
    Map<String, String> domainOwners;
    @Null String[] assets;
    @Null Map<String, String> customProperties;
    @Null
    List<Domains> domainHierarchy;
}