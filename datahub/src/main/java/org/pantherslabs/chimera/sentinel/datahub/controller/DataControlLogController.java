package org.pantherslabs.chimera.sentinel.datahub.controller;

import org.pantherslabs.chimera.sentinel.datahub.service.DataControlLogService;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.dto.FilterRequest;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/records")
public class DataControlLogController {

    @Autowired
    private DataControlLogService dataControlLogService;

    @PostMapping("/filter")
    public ResponseEntity<List<Map<String, Object>>> selectFromTable(@RequestBody FilterRequest request) {
        List<Map<String, Object>> result = dataControlLogService.selectFromTable(request.getTable(),
                request.getFilters());

        if (result.isEmpty()) {
            throw new ChimeraException("APIException.404",
                    Map.of("exception", "No records found"),
                    null,
                    HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result);
    }
}