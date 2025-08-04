package org.pantherslabs.chimera.sentinel.datahub.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class GlossaryNodeGroup {
    @NotNull
    public String name;

    @NotNull
    public String definition;

    @Null
    public GlossaryNodeGroup parentGlossaryNodeGroup;

    @Null
    public Map<String, List<String>> Ownership;

    @Null
    public Map<String, String> customProperties;

    public GlossaryNodeGroup(){}

    public GlossaryNodeGroup(String name, String definition, GlossaryNodeGroup parentGlossaryNodeGroup,
                             Map<String, List<String>>  Ownership,
                             Map<String, String> customProperties) {
        this.name = name;
        this.definition = definition;
        this.parentGlossaryNodeGroup = parentGlossaryNodeGroup;
        this.Ownership = Ownership;
        this.customProperties = customProperties;
    }
}
