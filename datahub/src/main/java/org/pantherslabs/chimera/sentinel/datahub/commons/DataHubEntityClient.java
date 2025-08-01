package org.pantherslabs.chimera.sentinel.datahub.commons;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class DataHubEntityClient {
    private static final String DATAHUB_URLa = System.getenv("DATAHUB_GMS_URL");
    public static String DATAHUB_AUTH_TOKEN3= System.getenv("DATAHUB_TOKEN");
    public static String DATAHUB_AUTH_TOKEN="eyJhbGciOiJIUzI1NiJ9.eyJhY3RvclR5cGUiOiJVU0VSIiwiYWN0b3JJZCI6ImRhdGFodWIiLCJ0eXBlIjoiUEVSU09OQUwiLCJ2ZXJzaW9uIjoiMiIsImp0aSI6IjJhNWI2ODNlLTMxNTktNDQ5ZC04YmM2LTc4MjI5NTAxNjMyNSIsInN1YiI6ImRhdGFodWIiLCJpc3MiOiJkYXRhaHViLW1ldGFkYXRhLXNlcnZpY2UifQ.GMojHOdUCp0R3dltLmCJMqqxMrlo5wtDyhHAub3Vw08";
    private static final String DATAHUB_URL = "http://localhost:9002";
    public enum Action {
        GET,
        DELETE
    }

    public static int performAction(
            Action action,
            String entityType,
            String urn,
            boolean clear,
            List<String> aspects
    ) {
        int status = 0;
        try {
            String encodedUrn = URLEncoder.encode(urn, StandardCharsets.UTF_8);

            UriComponentsBuilder builder = UriComponentsBuilder
                    .fromHttpUrl(DATAHUB_URL)
                    .pathSegment("openapi", "v3", "entity", entityType, encodedUrn)
                    .queryParam("urn", urn)
                    .queryParam("aspect", "globalTags");

            if (action == Action.DELETE) {
                builder.queryParam("clear", clear);
            }

            if (aspects != null && !aspects.isEmpty()) {
                for (String aspect : aspects) {
                    builder.queryParam("aspects", aspect);  // Automatically URL-encodes each value
                }
            }

            String finalUrl = builder.build().encode().toUriString();

            URL url = new URL(finalUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(action.name());
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + DATAHUB_AUTH_TOKEN);


            status = conn.getResponseCode();
            System.out.println("🔄 " + action + " " + urn + " -> HTTP " + status);

            if (action == Action.GET && status == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                System.out.println("✅ Entity exists:");
                while ((line = in.readLine()) != null) {
                    System.out.println(line);

                }
                in.close();
            } else if (action == Action.DELETE && (status == 200 || status == 204)) {
                System.out.println("✅ Successfully deleted: " + urn);
            } else {
                System.err.println("❌ Operation failed. HTTP status: " + status);
            }

            conn.disconnect();
        } catch (Exception e) {
            System.err.println("❌ Error performing action: " + e.getMessage());
        }
        return status;
    }

    public static String performEntityAction(
            Action action,
            String entityType,
            String urn,
            String aspect
    ) {
        try {
            String encodedUrn = URLEncoder.encode(urn, StandardCharsets.UTF_8);

            URI baseUri = URI.create(DATAHUB_URL);

            String finalUrl = UriComponentsBuilder
                    .newInstance()
                    .scheme(baseUri.getScheme())
                    .host(baseUri.getHost())
                    .port(baseUri.getPort())
                    .pathSegment("openapi", "v3", "entity", entityType, encodedUrn)
                    .queryParam("systemMetadata", "false")
                    .queryParam("aspect", aspect)
                    .build()
                    .toUriString();
            System.out.println("Calling URL: " + finalUrl);
           /* if (action == Action.DELETE) {
                builder.queryParam("clear", true);
            }
*/
            System.out.println("Calling URL " + finalUrl);
            URL url = new URL(finalUrl);
            System.out.println("Calling URL 2" + url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(action.name());
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + DATAHUB_AUTH_TOKEN);

            int status = conn.getResponseCode();
            InputStream inputStream = (status < 400) ? conn.getInputStream() : conn.getErrorStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();
            conn.disconnect();

            if (action == Action.GET && status == 200) {
                // Return version 0 of the aspect only
                return extractVersion0Aspect(responseBuilder.toString(), aspect);
            } else if (action == Action.DELETE && (status == 200 || status == 204)) {
                return String.format("{\"message\": \"Successfully deleted aspect '%s' from URN '%s'\"}", aspect, urn);
            } else {
                return String.format("{\"error\": \"Operation failed with HTTP status %d\", \"response\": %s}", status, responseBuilder);
            }

        } catch (Exception e) {
            return String.format("{\"error\": \"Exception occurred: %s\"}", e.getMessage());
        }
    }
    private static String extractVersion0Aspect(String json, String aspectName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);

            JsonNode secretValueNode = root.path("dataHubSecretValue").path("value").path("value");

            if (!secretValueNode.isMissingNode()) {
                return secretValueNode.asText(); // returns the "v2:..." string
            } else {
                return String.format("{\"error\": \"'value.value' not found in aspect '%s'\"}", aspectName);
            }

        } catch (Exception e) {
            return String.format("{\"error\": \"Failed to parse aspect version 0: %s\"}", e.getMessage());
        }
    }

/*    // Example usage
    public static void main(String[] args) {
        DataHubEntityClient client = new DataHubEntityClient(DATAHUB_URL);

        String urn = "urn:li:domain:panterslabs";
        List<String> aspects = List.of(
                "testResults", "displayProperties", "structuredProperties",
                "domainProperties", "ownership", "institutionalMemory",
                "domainKey", "forms"
        );

        // 1. Check if domain exists
        client.performAction(Action.GET, "domain", urn, false, null);

        // 2. Delete domain
        client.performAction(Action.DELETE, "domain", urn, true, aspects);
    }*/
}
