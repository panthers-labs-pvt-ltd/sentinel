package org.pantherslabs.chimera.sentinel.datahub.emitter;

import com.linkedin.mxe.MetadataChangeProposal;
import datahub.client.Emitter;
import datahub.client.MetadataWriteResponse;
import datahub.client.rest.RestEmitter;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DataHubBatchEmitter {

    private static final String DATAHUB_URL = "http://localhost:8080";  // replace as needed
    public static String DATAHUB_AUTH_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhY3RvclR5cGUiOiJVU0VSIiwiYWN0b3JJZCI6ImRhdGFodWIiLCJ0eXBlIjoiUEVSU09OQUwiLCJ2ZXJzaW9uIjoiMiIsImp0aSI6IjBhNTZiZWZkLTUwNDUtNDZhMS1iNWFlLTA1NmNiZDA3NGZkZCIsInN1YiI6ImRhdGFodWIiLCJleHAiOjE3NTU1OTIwMjQsImlzcyI6ImRhdGFodWItbWV0YWRhdGEtc2VydmljZSJ9.12xJknOihhNpWutS6GccBRkR1HzbyHQZPN1XITp2muI";

    /**
     * Emit a list of MCPs to DataHub via REST emitter and wait for all responses.
     */
    public static List<String> emitProposalBatch(List<MetadataChangeProposal> proposals, String type) throws IOException, InterruptedException, ExecutionException {
        Emitter emitter = RestEmitter.create(b -> b
                .server(DATAHUB_URL)
                .token(DATAHUB_AUTH_TOKEN)
        );

        List<Future<MetadataWriteResponse>> futures = new ArrayList<>();
        List<String> statuses = new ArrayList<>();

        for (MetadataChangeProposal proposal : proposals) {
//            CompletableFuture<MetadataWriteResponse> future = (CompletableFuture<MetadataWriteResponse>) emitter.emit(proposal);
            Future<MetadataWriteResponse> future = emitter.emit(proposal);
            futures.add(future);
        }

        for (int i = 0; i < futures.size(); i++) {
            MetadataChangeProposal proposal = proposals.get(i);
            MetadataWriteResponse response = futures.get(i).get(); // blocks until complete

            if (response.isSuccess()) {
                String urn = proposal.getEntityUrn().toString();
                statuses.add("SUCCESS: " + urn);
                System.out.printf("%s: Successfully emitted aspect '%s' for %s%n", type, proposal.getAspectName(), urn);
            } else {
                statuses.add("FAILURE: " + response.getResponseContent());
                System.out.printf("%s: Failed to emit aspect '%s' for %s. Error: %s%n", type, proposal.getAspectName(), proposal.getEntityUrn(), response.getResponseContent());
            }
        }

        return statuses;
    }
}
