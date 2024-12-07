package com.example.mongodb_demo.controller;

import com.example.mongodb_demo.dto.EmployeeDto;
import com.example.mongodb_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
         return employeeService.addEmployee(employeeDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable String id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }

    @PostMapping("{id}/department/{departmentId}")
    public ResponseEntity<EmployeeDto> assignedEmployeeToDepartment(@PathVariable String id, @PathVariable String departmentId) {
        return employeeService.assignedEmployeeToDepartment(id, departmentId);
    }
}
