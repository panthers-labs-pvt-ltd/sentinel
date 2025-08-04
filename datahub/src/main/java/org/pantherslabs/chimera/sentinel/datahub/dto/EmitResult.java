package org.pantherslabs.chimera.sentinel.datahub.dto;

import com.linkedin.mxe.MetadataChangeProposal;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EmitResult {
    private final boolean success;
    private final List<MetadataChangeProposal> succeeded;
    private final MetadataChangeProposal failedProposal;
    private final ErrorDetails errorDetails;

    public EmitResult(boolean success, List<MetadataChangeProposal> succeeded,
                      MetadataChangeProposal failedProposal, ErrorDetails errorDetails) {
        this.success = success;
        this.succeeded = succeeded;
        this.failedProposal = failedProposal;
        this.errorDetails = errorDetails;
    }


    public EmitResult(boolean success, ErrorDetails errorDetails) {
        this.success = success;
        this.errorDetails = errorDetails;
        this.succeeded = null;
        this.failedProposal = null;
    }

}
