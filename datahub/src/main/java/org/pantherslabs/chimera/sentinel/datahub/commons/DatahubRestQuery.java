package org.pantherslabs.chimera.sentinel.datahub.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linkedin.identity.CorpUserStatus;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class DatahubRestQuery {
    private static final String DATAHUB_URL = System.getenv("DATAHUB_GMS_URL");
    public static String DATAHUB_AUTH_TOKEN = System.getenv("DATAHUB_TOKEN");


    public static void main(String[] args) throws Exception {
        String urn = "urn:li:corpuser:john.doe@example.com";
        String encodedUrn = URLEncoder.encode(urn, StandardCharsets.UTF_8);
        String url = DATAHUB_URL + "/entitiesV2/" + encodedUrn;
        System.out.println(url);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + DATAHUB_AUTH_TOKEN)
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
               // Step 3: Deserialize JSON string to Ownership object
            ObjectMapper mapper = new ObjectMapper();
            CorpUserStatus ownership = mapper.readValue(response.body(), CorpUserStatus.class);
            System.out.println("✅ URN exists: " + response.body());

        } else if (response.statusCode() == 404) {
            System.out.println("❌ URN not found: " + urn);
        } else {
            System.out.println("⚠️ Unexpected response: " + response.statusCode());
        }
    }
}
