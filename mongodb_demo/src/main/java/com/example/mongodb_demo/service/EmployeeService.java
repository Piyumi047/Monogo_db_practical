package com.example.mongodb_demo.service;

import com.example.mongodb_demo.dto.EmployeeDto;
import com.example.mongodb_demo.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {


     ResponseEntity<EmployeeDto> addEmployee(EmployeeDto employeeDto) ;
     ResponseEntity<EmployeeDto> getEmployeeById(String id);

     ResponseEntity<EmployeeDto> updateEmployee(String id, EmployeeDto employeeDto);

     ResponseEntity<EmployeeDto> deleteEmployee(String id);

     ResponseEntity<EmployeeDto> assignedEmployeeToDepartment(String id, String departmentId);
}
