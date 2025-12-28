package com.examly.springapp.service;

import com.examly.springapp.model.GrievanceCategory;
import java.util.List;

public interface GrievanceCategoryService {
    GrievanceCategory saveGrievanceCategory(GrievanceCategory category);
    List<GrievanceCategory> getAllGrievanceCategories();
    GrievanceCategory getGrievanceCategoryById(Long id);
    GrievanceCategory updateGrievanceCategory(Long id, GrievanceCategory category);
    void deleteGrievanceCategory(Long id);
    List<GrievanceCategory> searchGrievanceCategories(String keyword);
}