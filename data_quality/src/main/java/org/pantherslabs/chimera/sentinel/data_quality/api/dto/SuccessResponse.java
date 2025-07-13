
package org.pantherslabs.chimera.sentinel.data_quality.api.dto;

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

