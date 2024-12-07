package com.example.mongodb_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDto {
    private String id;
    private String departmentName;
    private String description;
    private String departmentCode;
}
