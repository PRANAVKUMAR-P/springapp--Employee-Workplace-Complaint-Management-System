package com.examly.springapp.service;

import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.repository.GrievanceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GrievanceCategoryServiceImpl implements GrievanceCategoryService {
    
    @Autowired
    private GrievanceCategoryRepository grievanceCategoryRepository;
    
    @Override
    public GrievanceCategory saveGrievanceCategory(GrievanceCategory category) {
        return grievanceCategoryRepository.save(category);
    }
    
    @Override
    public List<GrievanceCategory> getAllGrievanceCategories() {
        return grievanceCategoryRepository.findAll();
    }
    
    @Override
    public GrievanceCategory getGrievanceCategoryById(Long id) {
        return grievanceCategoryRepository.findById(id).orElse(null);
    }
    
    @Override
    public GrievanceCategory updateGrievanceCategory(Long id, GrievanceCategory category) {
        if (grievanceCategoryRepository.existsById(id)) {
            category.setCategoryId(id);
            return grievanceCategoryRepository.save(category);
        }
        return null;
    }
    
    @Override
    public void deleteGrievanceCategory(Long id) {
        grievanceCategoryRepository.deleteById(id);
    }
    
    @Override
    public List<GrievanceCategory> searchGrievanceCategories(String keyword) {
        return grievanceCategoryRepository.findByCategoryNameContainingOrDescriptionContaining(keyword);
    }
}