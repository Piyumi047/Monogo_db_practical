package com.example.mongodb_demo.service;

import com.example.mongodb_demo.dto.DepartmentDto;
import org.springframework.http.ResponseEntity;


public interface DepartmentService {
    ResponseEntity<DepartmentDto > addDepartment(DepartmentDto departmentDto);
    ResponseEntity<DepartmentDto> getDepartmentById(String id);
    ResponseEntity<DepartmentDto> updateDepartment(String id, DepartmentDto departmentDto);
    ResponseEntity<DepartmentDto> deleteDepartment(String id);

}
