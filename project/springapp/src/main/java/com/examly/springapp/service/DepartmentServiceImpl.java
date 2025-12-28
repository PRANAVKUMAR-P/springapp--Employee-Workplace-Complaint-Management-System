package com.examly.springapp.service;

import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    
    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }
    
    @Override
    public Department updateDepartment(Long id, Department department) {
        if (departmentRepository.existsById(id)) {
            department.setDepartmentId(id);
            return departmentRepository.save(department);
        }
        return null;
    }
    
    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
    
    @Override
    public Page<Department> getDepartmentsPaginated(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }
}