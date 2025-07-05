package org.pantherslabs.chimera.sentinel.controller;

import org.pantherslabs.chimera.sentinel.dto.DataControls;
import org.pantherslabs.chimera.sentinel.service.DataControlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data-controls")
public class DataControlsController {

    @Autowired
    private DataControlsService dataControlsService;

    @GetMapping
    public ResponseEntity<List<DataControls>> getAllControls() {
        return ResponseEntity.ok(dataControlsService.getAllControls());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataControls> getControlById(@PathVariable Short id) {
        DataControls control = dataControlsService.getControlById(id);
        if (control == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(control);
    }

    @PostMapping
    public ResponseEntity<DataControls> createControl(@RequestBody DataControls dataControls) {
        DataControls created = dataControlsService.createControl(dataControls);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataControls> updateControl(@PathVariable Short id, @RequestBody DataControls dataControls) {
        DataControls updated = dataControlsService.updateControl(id, dataControls);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteControl(@PathVariable Short id) {
        boolean deleted = dataControlsService.deleteControl(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}