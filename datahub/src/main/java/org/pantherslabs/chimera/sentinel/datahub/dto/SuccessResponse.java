
package org.pantherslabs.chimera.sentinel.datahub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SuccessResponse {
    private String message;
    private String responseCode;
}

