package org.pantherslabs.chimera.sentinel.datahub.api.controller;

import com.linkedin.common.urn.Urn;
import org.pantherslabs.chimera.sentinel.datahub.api.dto.OwnerRequest;
import org.pantherslabs.chimera.sentinel.datahub.modal.EmitResult;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.SuccessResponse;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.pantherslabs.chimera.sentinel.datahub.api.service.ManageOwnership;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.CREATE_ACTION_TYPE;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.UPSERT_ACTION_TYPE;

@RestController
@RequestMapping("/api/ownership")
public class OwnershipController {

    @Autowired
    private ManageOwnership manageOwnership;

    /**
     * @param request {
     *                "entityUrn": "urn:li:dataset:(urn:li:dataPlatform:hive,my_dataset,PROD)",
     *                "entityType": "dataset",
     *                "ownersInfo": {
     *                "john.doe": ["TECHNICAL_OWNER", "DATA_STEWARD"],
     *                "jane.smith": ["BUSINESS_OWNER"]
     *                }
     *                }
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<?> addOwners(@RequestBody OwnerRequest request) {

        EmitResult result = null;
        try {
            Urn urn = Urn.createFromString(request.getEntityUrn());
            result = ManageOwnership.createOwners(
                    urn,
                    request.getEntityType(),
                    request.getOwnersInfo(),
                    CREATE_ACTION_TYPE
            );
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            assert result != null;
            throw new ChimeraException(
                    "APIException." + result.getErrorDetails().getStatus(),
                    Map.of("exception", result.getErrorDetails().getMessage()),
                    null,
                    HttpStatus.valueOf(result.getErrorDetails().getStatus())
            );
        }
    }

    /**
     * @param request {
     *                "entityUrn": "urn:li:dataset:(urn:li:dataPlatform:hive,my_dataset,PROD)",
     *                "entityType": "dataset",
     *                "ownersInfo": {
     *                "john.doe": ["TECHNICAL_OWNER", "DATA_STEWARD"],
     *                "jane.smith": ["BUSINESS_OWNER"]
     *                }
     *                }
     * @return
     */
    @PostMapping("/edit")
    public ResponseEntity<?> editOwners(@RequestBody OwnerRequest request) {

        EmitResult result = null;
        try {
            Urn urn = Urn.createFromString(request.getEntityUrn());
            result = manageOwnership.createOwners(
                    urn,
                    request.getEntityType(),
                    request.getOwnersInfo(),
                    UPSERT_ACTION_TYPE
            );
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            assert result != null;
            throw new ChimeraException(
                    "APIException." + result.getErrorDetails().getStatus(),
                    Map.of("exception", result.getErrorDetails().getMessage()),
                    null,
                    HttpStatus.valueOf(result.getErrorDetails().getStatus())
            );
        }
    }

    /**
     * API Will be used to remove /de-associate owner from any association/base aspects
     * Input Payload :=
     * {
     * "entityUrn": "urn:li:dataset:(urn:li:dataPlatform:hive,fct_users_deleted,PROD)",
     * "entityType": "ownership",
     * "ownersInfo": {
     * "removableOwners": [
     * "urn:li:corpuser:datahub",
     * "urn:li:corpuser:manish",
     * "urn:li:corpuser:jdoe"
     * ]
     * }
     * }
     */
    @PostMapping("/remove")
    public ResponseEntity<?> removeOwners(@RequestBody OwnerRequest request) {
        EmitResult result = null;
        try {
            List<String> ownersToRemove = request.getOwnersInfo().get("removableOwners");
/*            List<String> allOwnersToRemove = request.getOwnersInfo().values().stream()
                    .flatMap(List::stream)
                    .toList();*/

            if (ownersToRemove == null || ownersToRemove.isEmpty()) {
                // return ResponseEntity.badRequest().body("No owners provided under key 'removableOwners'");
                throw new ChimeraException(
                        "APIException.400",
                        Map.of("exception", "No owners provided under key 'removableOwners'"),
                        null,
                        HttpStatus.BAD_REQUEST);
            }

            result = manageOwnership.removeOwners(
                    request.getEntityUrn(),
                    request.getEntityType(),
                    ownersToRemove
            );

            List<SuccessResponse> summaries = result.getSucceeded().stream()
                    .map(p -> new SuccessResponse(
                            p.getEntityUrn().toString() + " " + p.getAspectName() + " removed successfully..", "200"))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(summaries);
        } catch (Exception e) {
            assert result != null;
            throw new ChimeraException(
                    "APIException." + result.getErrorDetails().getStatus(),
                    Map.of("exception", result.getErrorDetails().getMessage()),
                    null,
                    HttpStatus.valueOf(result.getErrorDetails().getStatus())
            );
        }
    }


}

