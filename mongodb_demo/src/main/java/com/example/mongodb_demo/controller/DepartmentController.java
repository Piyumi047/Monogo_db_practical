package com.example.mongodb_demo.controller;

import com.example.mongodb_demo.dto.DepartmentDto;
import com.example.mongodb_demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/department")
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.addDepartment(departmentDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable String id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable String id, @RequestBody DepartmentDto departmentDto) {
        return departmentService.updateDepartment(id, departmentDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DepartmentDto> deleteDepartment(@PathVariable String id) {
        return departmentService.deleteDepartment(id);
    }
}
