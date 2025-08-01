package org.pantherslabs.chimera.sentinel.datahub.commons;

import com.linkedin.events.metadata.ChangeType;
import com.linkedin.mxe.MetadataChangeProposal;
import datahub.client.Emitter;
import datahub.client.MetadataWriteResponse;
import datahub.client.rest.RestEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.dto.ErrorDetails;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;

import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.extractErrorDetails;

public class EventEmitter {
    static String DATAHUB_TOKEN="eyJhbGciOiJIUzI1NiJ9.eyJhY3RvclR5cGUiOiJVU0VSIiwiYWN0b3JJZCI6ImRhdGFodWIiLCJ0eXBlIjoiUEVSU09OQUwiLCJ2ZXJzaW9uIjoiMiIsImp0aSI6IjJhNWI2ODNlLTMxNTktNDQ5ZC04YmM2LTc4MjI5NTAxNjMyNSIsInN1YiI6ImRhdGFodWIiLCJpc3MiOiJkYXRhaHViLW1ldGFkYXRhLXNlcnZpY2UifQ.GMojHOdUCp0R3dltLmCJMqqxMrlo5wtDyhHAub3Vw08";

    ChimeraLogger logger = ChimeraLoggerFactory.getLogger(EventEmitter.class);
    private final Emitter emitter;
    private static final String DATAHUB_URL = System.getenv("DATAHUB_GMS_URL");
    public static String DATAHUB_AUTH_TOKEN = DATAHUB_TOKEN;// System.getenv("DATAHUB_TOKEN");

    public EventEmitter() {
        this.emitter = RestEmitter.create(builder -> builder
                .server(DATAHUB_URL)
                .token(DATAHUB_AUTH_TOKEN)
        );
    }

    /**
     * Emits a list of proposals. Rolls back all successful ones if any fails.
     *
     * @param proposals List of MCPs to emit
     * @return Event Emitter
     */
    public EmitResult emitWithRollback(List<MetadataChangeProposal> proposals) {
        List<MetadataChangeProposal> successful = new ArrayList<>();

        for (MetadataChangeProposal proposal : proposals) {
            try {
                Future<MetadataWriteResponse> future = emitter.emit(proposal);
                MetadataWriteResponse response = future.get();

                if (response.isSuccess()) {
                    logger.logInfo(String.format("✅ Emitted aspect '%s' for %s",
                            proposal.getAspectName(), proposal.getEntityUrn()));
                    successful.add(proposal);
                } else {
                    String rawError = response.getResponseContent();
                    ErrorDetails errorDetails = extractErrorDetails(rawError);

                    String errorMsg = String.format("❌ Failed to emit aspect '%s' for %s. Reason: %s",
                            proposal.getAspectName(), proposal.getEntityUrn(), errorDetails.getMessage());
                    logger.logError(errorMsg);
                    rollback(successful);

                    return new EmitResult(false, successful, proposal, errorDetails);
                }
            } catch (Exception ex) {
                String errorMsg = String.format("❌ Exception while emitting aspect '%s' for %s: %s",
                        proposal.getAspectName(), proposal.getEntityUrn(), ex.getMessage());
                logger.logError(errorMsg);

                rollback(successful);
                return new EmitResult(false, successful, proposal, new ErrorDetails(500, errorMsg));
            }
        }

        return new EmitResult(true, successful, null, null);
    }


    /**
     * Rolls back all previously emitted aspects using ChangeType.DELETE.
     */
    private void rollback(List<MetadataChangeProposal> successfulProposals) {
        logger.logInfo("🔁 Starting rollback...");

        for (MetadataChangeProposal success : successfulProposals) {
            try {
                MetadataChangeProposal deleteProposal = new MetadataChangeProposal()
                        .setEntityType(success.getEntityType())
                        .setEntityUrn(success.getEntityUrn())
                        .setAspectName(success.getAspectName())
                        .setChangeType(ChangeType.DELETE);

                Future<MetadataWriteResponse> rollbackResponse = emitter.emit(deleteProposal);
                MetadataWriteResponse resp = rollbackResponse.get();

                if (resp.isSuccess()) {
                    logger.logInfo(String.format("🗑️ Rolled back '%s' for %s%n", success.getAspectName(), success.getEntityUrn()));
                } else {
                    logger.logError(String.format("⚠️ Rollback FAILED for '%s' of %s. Reason: %s%n",
                            success.getAspectName(), success.getEntityUrn(), resp.getResponseContent()));
                }
            } catch (Exception ex) {
                logger.logError(String.format("⚠️ Rollback exception for '%s' of %s: %s%n",
                        success.getAspectName(), success.getEntityUrn(), ex.getMessage()));
            }
        }
    }
        public static EmitResult emitEvent(List<MetadataChangeProposal> proposals)
        {
            EventEmitter txEmitter = new EventEmitter();
            return txEmitter.emitWithRollback(proposals);
        }

}
