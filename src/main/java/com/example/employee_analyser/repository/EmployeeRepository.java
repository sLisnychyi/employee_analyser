package com.example.employee_analyser.repository;

import com.example.employee_analyser.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee findByName(String name);

    List<Employee> findAll();

    void save(List<Employee> employees);

    long count();
}
