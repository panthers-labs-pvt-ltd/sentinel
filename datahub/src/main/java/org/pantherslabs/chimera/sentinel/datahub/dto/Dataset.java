package org.pantherslabs.chimera.sentinel.datahub.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class Dataset {

    // Required fields
    @NotNull
    private String dataProductName;

    @NotNull
    private String name;

    @NotNull
    private String fabricType;

    @NotNull
    private String datasetPlatformName;

    // Optional fields
    private String displayName;
    private String description;
    private String qualifiedName;
    private String uri;
    private String domain;

    private List<Tag> tags;
    private List<Property> properties;
    private List<Owners> owners;
    private List<GlossaryTerm> glossaryTerm;
    private List<Field> fields;

    // Constructors
    public Dataset() {}

    public Dataset(@NotNull String dataProductName, @NotNull String name, @NotNull String fabricType,
                   @NotNull String datasetPlatformName) {
        this.dataProductName = dataProductName;
        this.name = name;
        this.fabricType = fabricType;
        this.datasetPlatformName = datasetPlatformName;
    }
}
