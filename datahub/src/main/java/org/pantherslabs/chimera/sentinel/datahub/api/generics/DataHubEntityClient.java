package org.pantherslabs.chimera.sentinel.datahub.api.generics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class DataHubEntityClient {
    private static final String DATAHUB_URL = System.getenv("DATAHUB_GMS_URL");
    public static String DATAHUB_AUTH_TOKEN = System.getenv("DATAHUB_TOKEN");

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
            StringBuilder urlBuilder = new StringBuilder(DATAHUB_URL)
                    .append("/openapi/v3/entity/")
                    .append(entityType)
                    .append("/")
                    .append(encodedUrn);

            if (action == Action.DELETE) {
                urlBuilder.append("?clear=").append(clear);
            }

            if (aspects != null && !aspects.isEmpty()) {
                for (String aspect : aspects) {
                    urlBuilder.append("&aspects=").append(URLEncoder.encode(aspect, StandardCharsets.UTF_8));
                }
            }

            URL url = new URL(urlBuilder.toString());
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
