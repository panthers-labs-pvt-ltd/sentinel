package com.progressive.minds.chimera.sentinel.datahub.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalReference {
    @JsonProperty("externalUrl")
    private String externalUrl;

    // Getters and Setters
    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }
}
