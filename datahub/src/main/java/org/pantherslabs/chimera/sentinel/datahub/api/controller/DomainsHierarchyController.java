package org.pantherslabs.chimera.sentinel.datahub.api.controller;

import jakarta.validation.Valid;
import org.pantherslabs.chimera.sentinel.datahub.api.dto.Domains;
import org.pantherslabs.chimera.sentinel.datahub.api.service.ManageDomainHierarchy;
import org.pantherslabs.chimera.sentinel.datahub.api.service.MetadataAspects;
import org.pantherslabs.chimera.sentinel.datahub.modal.EmitResult;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.SuccessResponse;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/domains")
public class DomainsHierarchyController {
    EmitResult result =null;
    @Autowired
    private ManageDomainHierarchy manageDomains;
    private MetadataAspects metadataAspects;

    /**
     *
     * @param domain {
     *   "name": "PantersLabs",
     *   "documentation": "Top-level domain for business data",
     *   "domainOwners": {
     *     "prashantkumar.official@gmail.com": "DATAOWNER"
     *   },
     *   "assets": ["urn:li:dataPlatform:hive", "urn:li:dataset:(urn:li:dataPlatform:hive,finance.transactions,PROD)"],
     *   "customProperties": {
     *     "department": "business",
     *     "criticality": "high"
     *   },
     *   "domainHierarchy": [
     *     {
     *       "name": "PantersLabs-sales",
     *       "documentation": "Handles sales-related data",
     *       "domainOwners": {
     *         "sandhya.rock18@gmail.com": "TECHNICAL_OWNER"
     *       },
     *       "assets": ["urn:li:dataset:(urn:li:dataPlatform:hive,sales.orders,PROD)"],
     *       "customProperties": {
     *         "region": "global",
     *         "priority": "high"
     *       },
     *       "domainHierarchy": [
     *         {
     *           "name": "PantersLabs-north-america-sales",
     *           "documentation": "Sales data for North America",
     *           "domainOwners": {
     *             "abhinav.official@gmail.com": "DATA_STEWARD"
     *           },
     *           "assets": ["urn:li:dataset:(urn:li:dataPlatform:hive,sales.na.orders,PROD)"],
     *           "customProperties": {
     *             "region": "NA",
     *             "timezone": "EST"
     *           },
     *           "domainHierarchy": []
     *         }
     *       ]
     *     }
     *   ]
     * }
     * @param actionType
     * @return
     */
    @PostMapping("/create-hierarchy")
    public ResponseEntity<?> createDomainHierarchy(@RequestBody @Valid Domains domain,
                                                  @RequestParam(name = "actionType", defaultValue = "CREATE") String actionType
                                                  ) {
        try {
            manageDomains.createDomainHierarchy(domain, actionType);
            List<SuccessResponse> summaries = result.getSucceeded().stream()
                    .map(p -> new SuccessResponse(
                            p.getEntityUrn().toString() + " " + p.getAspectName() + " created successfully..", "200"))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(summaries);
        } catch (Exception e) {
            throw new ChimeraException(
                    "APIException." + result.getErrorDetails().getStatus(),
                    Map.of("exception", result.getErrorDetails().getMessage()),
                    null,
                    HttpStatus.valueOf(result.getErrorDetails().getStatus())
            );
        }
    }

    @PostMapping("/edit-hierarchy")
    public ResponseEntity<?> editDomainHierarchy(@RequestBody @Valid Domains domain,
                                             @RequestParam(name = "actionType", defaultValue = "UPSERT") String actionType
    ) {
        try {
            manageDomains.createDomainHierarchy(domain, actionType);
            List<SuccessResponse> summaries = result.getSucceeded().stream()
                    .map(p -> new SuccessResponse(
                            p.getEntityUrn().toString() + " " + p.getAspectName() + " created successfully..", "200"))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(summaries);
        } catch (Exception e) {
            throw new ChimeraException(
                    "APIException." + result.getErrorDetails().getStatus(),
                    Map.of("exception", result.getErrorDetails().getMessage()),
                    null,
                    HttpStatus.valueOf(result.getErrorDetails().getStatus())
            );
        }
    }

    /**
     *
     * @param domainName http://192.168.100.22:9001/api/domains/delete?domainName=panterslabs
     * @return
     * @throws Exception
     */
    @PostMapping("/delete")
    public ResponseEntity<?> deleteDomains(@RequestParam(name = "domainName") String domainName) throws Exception {
        EmitResult result = manageDomains.deleteDomain(domainName);
        if (!result.isSuccess()) {
            throw new ChimeraException(
                    "APIException." + result.getErrorDetails().getStatus(),
                    Map.of("exception", result.getErrorDetails().getMessage()),
                    null,
                    HttpStatus.valueOf(result.getErrorDetails().getStatus())
            );

        }
        return ResponseEntity.ok(new SuccessResponse("Domain " + domainName + " Deleted Successfully", "200"));
    }
}
