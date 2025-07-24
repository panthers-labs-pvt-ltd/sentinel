package org.pantherslabs.chimera.sentinel.datahub.api.controller;

import org.pantherslabs.chimera.sentinel.datahub.api.service.MetadataAspects;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.dto.FilterRequest;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/aspects")
public class MetadataAspectsController {

    @Autowired
    private MetadataAspects metadataAspects;

    @PostMapping("/filter")
    public ResponseEntity<List<Map<String, Object>>> getMetadataAspects(@RequestBody FilterRequest request) {
        List<Map<String, Object>> result = metadataAspects.getAspectsMetadata(request.getTable(), request.getFilters());

       if (result.isEmpty()) return ResponseEntity.noContent().build();
       return ResponseEntity.ok(result);
    }
}