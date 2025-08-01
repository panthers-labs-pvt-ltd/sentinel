package org.pantherslabs.chimera.sentinel.datahub.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {
    private int status;
    private String message;

    public ErrorDetails() {}

    public ErrorDetails(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters & Setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
