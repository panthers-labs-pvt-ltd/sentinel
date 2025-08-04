package org.pantherslabs.chimera.sentinel.datahub.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.linkedin.common.*;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.mxe.MetadataChangeProposal;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.pantherslabs.chimera.sentinel.datahub.commons.AspectsMetadata;
import org.pantherslabs.chimera.sentinel.datahub.model.generated.LatestMetadataAspectV2;
import org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ResponseWrapper;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.UPSERT_ACTION_TYPE;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.OWNERSHIP_TYPE_URN;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.buildProposal;

@Service
public class OwnershipService {
    static ChimeraLogger DCSLogger = ChimeraLoggerFactory.getLogger(OwnershipService.class);
    static List<MetadataChangeProposal> proposals = new ArrayList<>();

    public static EmitResult createOwners(
            Urn entityUrn,
            String entityType,
            Map<String, List<String>> ownersInfo,
            String actionType
    ) {
        EmitResult result = null;

        try {
            DCSLogger.logInfo("📌 Adding multi-type owners...");

            OwnerArray ownerArray = new OwnerArray();
            UrnArrayMap ownerTypesMap = new UrnArrayMap();

            for (Map.Entry<String, List<String>> entry : ownersInfo.entrySet()) {
                String ownerId = entry.getKey();
                List<String> typeStrings = entry.getValue();

                CorpuserUrn userUrn = new CorpuserUrn(ownerId);

                // 1. Build Owner object with optional .setType()
                Owner owner = new Owner()
                        .setOwner(userUrn)
                        .setSource(new OwnershipSource().setType(OwnershipSourceType.SERVICE));

                if (!typeStrings.isEmpty()) {
                    owner.setType(OwnershipType.valueOf(typeStrings.get(0))); // optional, deprecated
                }

                ownerArray.add(owner);

                // 2. Build UrnArray for all ownership types
                UrnArray ownershipTypes = new UrnArray();
                for (String typeStr : typeStrings) {
                    ownershipTypes.add(Urn.createFromString(OWNERSHIP_TYPE_URN + typeStr));

                }

                // 3. Put into ownerTypes map (key must be String URN)
                ownerTypesMap.put(userUrn.toString(), ownershipTypes);
            }

            // 4. Build audit stamp
            AuditStamp createdStamp = new AuditStamp()
                    .setActor(new CorpuserUrn(DATAHUB_ACTOR))
                    .setImpersonator(new CorpuserUrn(SYSTEM_ACTOR))
                    .setMessage("Initial Creation of Ownership (multi-type)")
                    .setTime(Instant.now().toEpochMilli());

            // 5. Build ownership aspect
            Ownership ownership = new Ownership()
                    .setOwners(ownerArray)
                    .setOwnerTypes(ownerTypesMap)
                    .setLastModified(createdStamp);

            // 6. Create proposal
            proposals.add(buildProposal(
                    entityUrn,
                    OWNERSHIP_ASPECT_NAME,
                    ownership,
                    actionType
            ));

            // 7. Emit proposal
            EventEmitter txEmitter = new EventEmitter();
            result = txEmitter.emitWithRollback(proposals);

        } catch (Exception e) {
            DCSLogger.logError("❌ Exception while creating multi-type owners for '" + entityType + "': " + e.getMessage(), e);
        }
        return result;
    }


    public EmitResult removeOwners(String entityUrn, String entityType, List<String> ownersToRemove) throws Exception {

        // Step 1: Get current ownership aspect
        ResponseWrapper<List<LatestMetadataAspectV2>, ErrorResponse> response =
                AspectsMetadata.get(entityUrn, entityType);

        if (response == null || !response.isSuccess() || response.getSuccessBody() == null) {
            throw new IllegalArgumentException("No existing ownership found for entity: " + entityUrn);
        }

        // Step 2: Extract Ownership aspect from the list of aspects
        LatestMetadataAspectV2 ownershipAspect = response.getSuccessBody().stream()
                .filter(aspect -> OWNERSHIP_ASPECT_NAME.equals(aspect.getAspect()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ownership aspect not found for entity: " + entityUrn));

        // Step 3: Deserialize JSON string to Ownership object
        ObjectMapper mapper = new ObjectMapper();
        Ownership ownership = mapper.readValue(ownershipAspect.getMetadata(), Ownership.class);

        // Step 4: Remove owners
        List<Owner> updatedOwners = ownership.getOwners().stream()
                .filter(owner -> ownersToRemove.stream()
                        .noneMatch(toRemove -> owner.getOwner().toString().equalsIgnoreCase(toRemove)))
                .collect(Collectors.toList());

        ownership.setOwners(new OwnerArray(updatedOwners));

        // Step 5: Remove entries from ownerTypes
        if (ownership.hasOwnerTypes()) {
            UrnArrayMap updatedOwnerTypes = new UrnArrayMap();
            ownership.getOwnerTypes().entrySet().stream()
                    .filter(entry -> ownersToRemove.stream()
                            .noneMatch(toRemove -> entry.getKey().equalsIgnoreCase("urn:li:corpuser:" + toRemove)))
                    .forEach(entry -> updatedOwnerTypes.put(entry.getKey(), entry.getValue()));
            ownership.setOwnerTypes(updatedOwnerTypes);
        }

        // Step 6: Set audit info
        AuditStamp modified = new AuditStamp()
                .setActor(Urn.createFromString(DATAHUB_ACTOR))
                .setImpersonator(Urn.createFromString(SYSTEM_ACTOR))
                .setMessage("Removing owners")
                .setTime(Instant.now().toEpochMilli());

        ownership.setLastModified(modified);

        // 6. Create proposal
        proposals.add(buildProposal(
                Urn.createFromString(entityUrn),
                OWNERSHIP_ASPECT_NAME,
                ownership,
                UPSERT_ACTION_TYPE
        ));
     /*
        // Step 7: Build proposal
        MetadataChangeProposal proposal = new MetadataChangeProposal();
        proposal.setEntityUrn(Urn.createFromString(entityUrn));
        proposal.setEntityType(actualEntityType);
        proposal.setAspectName(OWNERSHIP_ASPECT_NAME);
        proposal.setChangeType(ChangeType.UPSERT);
        proposal.setAspect(serializeAspect(ownership));
*/
        // Step 8: Emit proposal
        EventEmitter txEmitter = new EventEmitter();
        return txEmitter.emitWithRollback(proposals);
    }
}