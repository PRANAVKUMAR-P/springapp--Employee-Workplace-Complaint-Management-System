package com.examly.springapp.service;

import com.examly.springapp.model.Grievance;
import com.examly.springapp.repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GrievanceServiceImpl implements GrievanceService {
    
    @Autowired
    private GrievanceRepository grievanceRepository;
    
    @Override
    public Grievance saveGrievance(Grievance grievance) {
        return grievanceRepository.save(grievance);
    }
    
    @Override
    public List<Grievance> getAllGrievances() {
        return grievanceRepository.findAll();
    }
    
    @Override
    public Grievance getGrievanceById(Long id) {
        return grievanceRepository.findById(id).orElse(null);
    }
    
    @Override
    public Grievance updateGrievance(Long id, Grievance grievance) {
        if (grievanceRepository.existsById(id)) {
            grievance.setGrievanceId(id);
            return grievanceRepository.save(grievance);
        }
        return null;
    }
    
    @Override
    public void deleteGrievance(Long id) {
        grievanceRepository.deleteById(id);
    }
}