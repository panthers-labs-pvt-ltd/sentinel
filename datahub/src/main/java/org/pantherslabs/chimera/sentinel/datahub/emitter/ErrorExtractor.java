package org.pantherslabs.chimera.sentinel.datahub.emitter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.pantherslabs.chimera.sentinel.datahub.modal.ErrorDetails;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorExtractor {

    public static ErrorDetails extractErrorDetails(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);

            int status = root.has("status") ? root.get("status").asInt() : -1;

            String message = root.has("message") ? root.get("message").asText() : "";
            String extractedMsg = extractMsgFromText(message);

            return new ErrorDetails(status, extractedMsg);
        } catch (Exception e) {
            return new ErrorDetails(-1, "Failed to parse error response: " + e.getMessage());
        }
    }

    private static String extractMsgFromText(String input) {
        Pattern pattern = Pattern.compile("msg=([^,)]+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "No validation message found.";
    }
}
