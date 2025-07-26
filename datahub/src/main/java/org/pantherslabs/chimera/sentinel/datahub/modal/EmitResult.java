package org.pantherslabs.chimera.sentinel.datahub.modal;

import com.linkedin.mxe.MetadataChangeProposal;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
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

    public boolean isSuccess() {
        return success;
    }

    public List<MetadataChangeProposal> getSucceeded() {
        return succeeded;
    }

    public MetadataChangeProposal getFailedProposal() {
        return failedProposal;
    }

    public ErrorDetails getErrorDetails() {
        return errorDetails;
    }

    public EmitResult(boolean success, ErrorDetails errorDetails) {
        this(success, Collections.emptyList(), null, errorDetails);
    }
}
