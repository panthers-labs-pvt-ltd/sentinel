package org.pantherslabs.chimera.sentinel.data_quality.api.controller;
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataQualityVw;
import org.pantherslabs.chimera.sentinel.data_quality.api.service.DataQualityVwService;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.dto.FilterRequest;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data-quality")
public class DataQualityVwController {

    @Autowired
    private DataQualityVwService dataQualityVwService;

    @PostMapping("/filter")
    public ResponseEntity<List<Map<String, Object>>> filterDataQualityVw(@RequestBody FilterRequest request) {
        List<Map<String, Object>> result = dataQualityVwService.getDataQualityRules(request.getTable(), request.getFilters());

        if (result.isEmpty()) {
            throw new ChimeraException("APIException.404",
                    Map.of("exception", "No records found"),
                    null,
                    HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result);
    }
}