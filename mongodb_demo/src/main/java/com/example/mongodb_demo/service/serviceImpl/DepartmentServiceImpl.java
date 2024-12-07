package com.example.mongodb_demo.service.serviceImpl;

import com.example.mongodb_demo.dto.DepartmentDto;
import com.example.mongodb_demo.entity.Department;
import com.example.mongodb_demo.repository.DepartmentRepository;
import com.example.mongodb_demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public ResponseEntity<DepartmentDto> addDepartment(DepartmentDto departmentDto) {
        try{
            Department department = new Department(
                    departmentDto.getId(),
                    departmentDto.getDepartmentName(),
                    departmentDto.getDescription(),
                    departmentDto.getDepartmentCode());
            Department savedDepartment = departmentRepository.save(department);

            DepartmentDto savedDepartmentDto = new DepartmentDto(
                    savedDepartment.getId(),
                    savedDepartment.getDepartmentName(),
                    savedDepartment.getDescription(),
                    savedDepartment.getDepartmentCode());

            return ResponseEntity.ok(savedDepartmentDto);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<DepartmentDto> getDepartmentById(String id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if(optionalDepartment.isPresent()){
            DepartmentDto departmentDto = new DepartmentDto(
                    optionalDepartment.get().getId(),
                    optionalDepartment.get().getDepartmentName(),
                    optionalDepartment.get().getDescription(),
                    optionalDepartment.get().getDepartmentCode()
            );
            return ResponseEntity.ok(departmentDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<DepartmentDto> updateDepartment(String id, DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if(optionalDepartment.isPresent()){
            Department department = new Department(
                    departmentDto.getId(),
                    departmentDto.getDepartmentName(),
                    departmentDto.getDescription(),
                    departmentDto.getDepartmentCode()
            );
            Department updatedDepartment = departmentRepository.save(department);
            DepartmentDto updatedDepartmentDto = new DepartmentDto(
                    updatedDepartment.getId(),
                    updatedDepartment.getDepartmentName(),
                    updatedDepartment.getDescription(),
                    updatedDepartment.getDepartmentCode()
            );
            return ResponseEntity.ok(updatedDepartmentDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<DepartmentDto> deleteDepartment(String id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if(optionalDepartment.isPresent()){
            departmentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
