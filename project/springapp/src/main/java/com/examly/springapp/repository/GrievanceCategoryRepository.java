package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.GrievanceCategory;
import java.util.List;

@Repository
public interface GrievanceCategoryRepository extends JpaRepository<GrievanceCategory, Long> {
    @Query("SELECT gc FROM GrievanceCategory gc WHERE gc.categoryName LIKE %:keyword% OR gc.description LIKE %:keyword%")
    List<GrievanceCategory> findByCategoryNameContainingOrDescriptionContaining(@Param("keyword") String keyword);
}
