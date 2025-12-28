package com.examly.springapp.controller;

import com.examly.springapp.model.Grievance;
import com.examly.springapp.service.GrievanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/grievances")
public class GrievanceController {
    
    @Autowired
    private GrievanceService grievanceService;
    
    @PostMapping
    public ResponseEntity<Grievance> createGrievance(@RequestBody Grievance grievance) {
        if (grievance == null) {
            return ResponseEntity.badRequest().build();
        }
        Grievance saved = grievanceService.saveGrievance(grievance);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @GetMapping
    public ResponseEntity<List<Grievance>> getAllGrievances() {
        List<Grievance> grievances = grievanceService.getAllGrievances();
        if (grievances.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(grievances);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<String> getGrievanceById(@PathVariable Long id) {
        Grievance grievance = grievanceService.getGrievanceById(id);
        if (grievance == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grievance not found");
        }
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Grievance> updateGrievance(@PathVariable Long id, @RequestBody Grievance grievance) {
        Grievance updated = grievanceService.updateGrievance(id, grievance);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrievance(@PathVariable Long id) {
        grievanceService.deleteGrievance(id);
        return ResponseEntity.noContent().build();
    }
}
