package com.example.employee_analyser.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmployeeDto {
    private String name;
    private int salary;
}
