package org.pantherslabs.chimera.sentinel.datahub.api.generics;

import org.junit.jupiter.api.Test;
import org.pantherslabs.chimera.sentinel.datahub.api.model.generated.LatestMetadataAspectV2;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ResponseWrapper;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AspectsMetadataTest {

    @Test
    void getTest() throws IOException, InterruptedException {
            ResponseWrapper<List<LatestMetadataAspectV2>, ErrorResponse> response =
                    AspectsMetadata.get("urn:li:corpuser:john.doe@example.om","corpUserStatus");
        if (response.getStatusCode() >= 200 && response.getStatusCode() < 300)
        {
            System.out.println(response.getStatusCode());
            System.out.println(response.getSuccessBody());
        }
        else
            System.out.println("No Record Found...");
    }
}