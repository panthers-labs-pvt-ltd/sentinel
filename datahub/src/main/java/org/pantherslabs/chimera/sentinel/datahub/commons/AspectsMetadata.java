package org.pantherslabs.chimera.sentinel.datahub.commons;

import com.fasterxml.jackson.core.type.TypeReference;
import org.pantherslabs.chimera.sentinel.datahub.model.generated.LatestMetadataAspectV2;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.consumer.ApiConsumer;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ResponseWrapper;

import java.io.IOException;
import java.util.List;

public class AspectsMetadata {
    private static final ApiConsumer consumer = new ApiConsumer();

    public static ResponseWrapper<List<LatestMetadataAspectV2>, ErrorResponse> get(String urn, String aspectType)
            throws IOException, InterruptedException {
        String filterJson = String.format("""
            {
              "table": "latest_metadata_aspect_v2",
              "filters": [
                { "field": "urn", "operator": "=", "value": ["%s"] },
                { "field": "aspect", "operator": "=", "value": ["%s"] }
              ]
            }
            """, urn, aspectType);

        String filterApiUrl = "http://localhost:9001/api/aspects/filter";
        return consumer.post(
                filterApiUrl,
                filterJson,
                new TypeReference<List<LatestMetadataAspectV2>>() {},
                new TypeReference<ErrorResponse>() {}
        );
    }
}
