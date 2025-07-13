package org.pantherslabs.chimera.sentinel.data_quality.api.controller;
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataControls;
import org.pantherslabs.chimera.sentinel.data_quality.api.service.DataControlsService;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.dto.FilterRequest;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data-controls")
public class DataControlsController {

    @Autowired
    private DataControlsService dataControlsService;

    @GetMapping
    public ResponseEntity<List<DataControls>> getAllControls() {
        List<DataControls> controls = dataControlsService.getAllControls();
        return ResponseEntity.ok(controls);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataControls> getControlById(@PathVariable("id") String id) {
        DataControls control = dataControlsService.getControlById(id);
        if (control == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(control);
    }

    @PostMapping
    public ResponseEntity<DataControls> createControl(@RequestBody DataControls control) {
        DataControls created = dataControlsService.createControl(control);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataControls> updateControl(
            @PathVariable("id") String id,
            @RequestBody DataControls updatedControl) {
        DataControls updated = dataControlsService.updateControl(id, updatedControl);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteControl(@PathVariable("id") String id) {
        boolean deleted = dataControlsService.deleteControl(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/filter")
    public ResponseEntity<List<Map<String, Object>>> filterDataControls(@RequestBody FilterRequest request) {
        List<Map<String, Object>> result = dataControlsService.getControlWithFilter(request.getTable(), request.getFilters());

        if (result.isEmpty()) {
            throw new ChimeraException("APIException.404",
                    Map.of("exception", "No records found"),
                    null,
                    HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result);
    }
}