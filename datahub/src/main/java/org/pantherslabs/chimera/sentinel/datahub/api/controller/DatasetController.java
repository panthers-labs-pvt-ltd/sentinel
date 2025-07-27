package org.pantherslabs.chimera.sentinel.datahub.api.controller;

import org.pantherslabs.chimera.sentinel.datahub.api.service.ManageDatasets;
import org.pantherslabs.chimera.sentinel.datahub.modal.EmitResult;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.SuccessResponse;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dataset")
public class DatasetController {

    @Autowired
    ManageDatasets manageDatasets;
    /**
     * Accepts a dataset definition as JSON string (raw body) and a createdBy query parameter.
     */

    @PostMapping("/create")
    public ResponseEntity<?> createDataset(
            @RequestBody String datasetDefinitionJson,
            @RequestParam(name = "inFormat", required = false, defaultValue = "json") String inFormat) {
        EmitResult result = null;
        try {
            result = manageDatasets.createDataset(datasetDefinitionJson, inFormat, "UPSERT");
            List<SuccessResponse> summaries = result.getSucceeded().stream()
                    .map(p -> new SuccessResponse(
                            p.getEntityUrn().toString() + " " + p.getAspectName() + " created successfully..", "200"))
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
