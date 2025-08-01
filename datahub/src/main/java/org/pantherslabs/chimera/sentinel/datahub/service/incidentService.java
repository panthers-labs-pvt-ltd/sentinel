package org.pantherslabs.chimera.sentinel.datahub.service;

import com.linkedin.common.*;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.incident.*;
import com.linkedin.metadata.key.IncidentKey;
import com.linkedin.mxe.MetadataChangeProposal;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.buildProposal;

public class incidentService {
    static List<MetadataChangeProposal> incident_proposals = new ArrayList<>();

    public static EmitResult createIncident(String incidentType, String entityUrn, String incidentTitle,
                                            String incidentDesc) throws Exception {
        incident_proposals.clear();
        // Create Incident Key
        String incidentId=INCIDENT_URN_PREFIX + UUID.randomUUID();
        IncidentKey incidentKey = new IncidentKey().setId(incidentId);

        incident_proposals.add(buildProposal(Urn.createFromString(incidentId),INCIDENT_KEY_ASPECT_NAME,
                incidentKey,"UPSERT"));

        // Create Incident Information's
        IncidentSource incidentSource =new IncidentSource()
                .setType(IncidentSourceType.ASSERTION_FAILURE)
                .setSourceUrn(Urn.createFromString(incidentId));

        AuditStamp auditStamp = new AuditStamp()
                .setActor(new CorpuserUrn(DATAHUB_ACTOR))
                .setTime(Instant.now().toEpochMilli());

        UrnArray entitiesUrns = new UrnArray();
        entitiesUrns.add(Urn.createFromString(entityUrn));

        IncidentInfo inc = new IncidentInfo()
                .setType(IncidentType.valueOf(incidentType))
                .setPriority(0)
                .setSource(incidentSource)
                .setCreated(auditStamp)
                .setEntities(entitiesUrns)
                .setDescription(incidentDesc)
                .setTitle(incidentTitle)
                .setStatus(new IncidentStatus().setState(IncidentState.ACTIVE).setLastUpdated(auditStamp));

        incident_proposals.add(buildProposal(Urn.createFromString(incidentId),INCIDENT_INFO_ASPECT_NAME,
                inc,"UPSERT"));

        // Create Incident Information's Summary
        IncidentSummaryDetailsArray incidentSummaryDetailsArray = new IncidentSummaryDetailsArray();

        incidentSummaryDetailsArray.add(
                new IncidentSummaryDetails().setCreatedAt(System.currentTimeMillis())
                        .setType(String.valueOf(IncidentSourceType.ASSERTION_FAILURE))
                        .setUrn(Urn.createFromString(incidentId)));

        IncidentsSummary incidentsSummary = new IncidentsSummary();
        incidentsSummary.setActiveIncidentDetails(incidentSummaryDetailsArray);
        incident_proposals.add(buildProposal(Urn.createFromString(entityUrn),INCIDENTS_SUMMARY_ASPECT_NAME,
                incidentsSummary,"UPSERT"));
        return emitEvent(incident_proposals);
    }
}
