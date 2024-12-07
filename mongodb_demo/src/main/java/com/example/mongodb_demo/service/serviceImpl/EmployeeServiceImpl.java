package com.example.mongodb_demo.service.serviceImpl;

import com.example.mongodb_demo.dto.EmployeeDto;
import com.example.mongodb_demo.entity.Employee;
import com.example.mongodb_demo.repository.EmployeeRepository;
import com.example.mongodb_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<EmployeeDto> addEmployee(EmployeeDto employeeDto) {
        try {
            Employee employee = new Employee(employeeDto.getId(), employeeDto.getName(), employeeDto.getAge(), employeeDto.getAddress(), employeeDto.getDepartmentId());
            Employee savedEmployee = employeeRepository.save(employee);
            EmployeeDto savedemployeeDto = new EmployeeDto(
                    savedEmployee.getId(),
                    savedEmployee.getName(),
                    savedEmployee.getAge(),
                    savedEmployee.getAddress(),
                    savedEmployee.getDepartmentId());

            return ResponseEntity.ok(savedemployeeDto);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
            EmployeeDto employeeDto = new EmployeeDto(
                    optionalEmployee.get().getId(),
                    optionalEmployee.get().getName(),
                    optionalEmployee.get().getAge(),
                    optionalEmployee.get().getAddress(),
                    optionalEmployee.get().getDepartmentId()
            );
            return ResponseEntity.ok(employeeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(String id, EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(employeeDto.getName());
            employee.setAge(employeeDto.getAge());
            employee.setAddress(employeeDto.getAddress());
            Employee updatedEmployee = employeeRepository.save(employee);
            EmployeeDto updatedemployeeDto = new EmployeeDto(
                    updatedEmployee.getId(),
                    updatedEmployee.getName(),
                    updatedEmployee.getAge(),
                    updatedEmployee.getAddress(),
                    updatedEmployee.getDepartmentId()
            );
            return ResponseEntity.ok(updatedemployeeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<EmployeeDto> deleteEmployee(String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
            employeeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<EmployeeDto> assignedEmployeeToDepartment(String id, String departmentId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setDepartmentId(departmentId);
            Employee updatedEmployee = employeeRepository.save(employee);
            EmployeeDto updatedEmployeeDto = new EmployeeDto(
                    updatedEmployee.getId(),
                    updatedEmployee.getName(),
                    updatedEmployee.getAge(),
                    updatedEmployee.getAddress(),
                    updatedEmployee.getDepartmentId());

            return ResponseEntity.ok(updatedEmployeeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
