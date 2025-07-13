package org.pantherslabs.chimera.sentinel.data_quality.api.controller;
import org.pantherslabs.chimera.sentinel.data_quality.api.dto.SuccessResponse;
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataControlsLog;
import org.pantherslabs.chimera.sentinel.data_quality.api.service.DataControlsLogService;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/data-controls")
public class DataControlsLogController {

    private final DataControlsLogService logService;

    @Autowired
    public DataControlsLogController(DataControlsLogService logService) {
        this.logService = logService;
    }

    @PostMapping("/addDQLog")
    public ResponseEntity<SuccessResponse> batchInsert(@RequestBody(required = false) List<DataControlsLog> logs) {
        if (logs == null || logs.isEmpty()) {
            SuccessResponse errorResponse = new SuccessResponse("Request body is empty or invalid", "400");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        int insertedCount = logService.insertMultipleLogs(logs);
        SuccessResponse successResponse = new SuccessResponse("Inserted " + insertedCount + " logs", "200");
        return ResponseEntity.ok(successResponse);
    }

}
