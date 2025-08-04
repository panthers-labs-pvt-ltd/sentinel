package org.pantherslabs.chimera.sentinel.datahub.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class incidentServiceTest {

    @Test
    void createIncident() throws Exception {
        String incidentType="DATA_SCHEMA";
        String entityUrn ="urn:li:dataset:(urn:li:dataPlatform:postgres,datahub.public.latest_metadata_aspect_v2,PROD)";
        String incidentTitle="Test Incident Title";
        String incidentDesc= """
                Summary
                You can:
                Construct IncidentInfo in your backend
                Embed it in AssertionResult.nativeResults
                Process it to trigger real alerts via Slack/Jira/etc.
                Tag assets using MCP if needed (incident_detected, schema_mismatch, etc.)
                Would you like a full example integrating this into a MetadataChangeProposal or emitting AssertionRunEvent with incident context?""";

        incidentService.createIncident(incidentType,entityUrn,incidentTitle,incidentDesc);

    }
}