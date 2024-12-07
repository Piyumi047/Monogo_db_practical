package com.example.mongodb_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private String id;
    private String name;
    private int age;
    private String address;
    private String departmentId;
}
