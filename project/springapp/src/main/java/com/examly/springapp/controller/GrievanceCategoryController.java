package com.examly.springapp.controller;

import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.service.GrievanceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/grievance-categories")
public class GrievanceCategoryController {
    
    @Autowired
    private GrievanceCategoryService grievanceCategoryService;
    
    @PostMapping
    public ResponseEntity<GrievanceCategory> createGrievanceCategory(@RequestBody GrievanceCategory category) {
        GrievanceCategory saved = grievanceCategoryService.saveGrievanceCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @GetMapping
    public ResponseEntity<List<GrievanceCategory>> getAllGrievanceCategories() {
        List<GrievanceCategory> categories = grievanceCategoryService.getAllGrievanceCategories();
        return ResponseEntity.ok(categories);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<GrievanceCategory> getGrievanceCategoryById(@PathVariable Long id) {
        GrievanceCategory category = grievanceCategoryService.getGrievanceCategoryById(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<GrievanceCategory> updateGrievanceCategory(@PathVariable Long id, @RequestBody GrievanceCategory category) {
        GrievanceCategory updated = grievanceCategoryService.updateGrievanceCategory(id, category);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<GrievanceCategory>> searchGrievanceCategories(@PathVariable String keyword) {
        List<GrievanceCategory> categories = grievanceCategoryService.searchGrievanceCategories(keyword);
        return ResponseEntity.ok(categories);
    }
}
