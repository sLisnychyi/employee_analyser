package com.example.employee_analyser.service;

import com.example.employee_analyser.dto.EmployeeDto;
import com.example.employee_analyser.dto.EmployeeTasksDto;
import com.example.employee_analyser.entity.Employee;
import com.example.employee_analyser.repository.EmployeeJpaRepository;
import com.example.employee_analyser.transformer.EmployeeTransformer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeJpaRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final EmployeeTransformer employeeTransformer;

    public EmployeeService(EmployeeJpaRepository employeeRepository, ModelMapper modelMapper, EmployeeTransformer employeeTransformer) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.employeeTransformer = employeeTransformer;
    }

    public EmployeeDto getEmployee(String name) {
        Employee byName = employeeRepository.findByName(name);
        return modelMapper.map(byName, EmployeeDto.class);
    }

    public void save(List<Employee> employees) {
        employees.forEach(employeeRepository::save);
    }

    public List<Employee> getEmployees(String namepart){
        return employeeRepository.findByNameLike(namepart);
    }

    public List<Employee> getEmployeeBySalary(String name, int salary){
        return employeeRepository.findByNameLikeAndSalaryGreaterThan (name,salary);
    }

    public List<Employee> findTop3BySalary(){
        return employeeRepository.findTop3ByOrderBySalaryDesc();
    }

    public EmployeeTasksDto findById(int id){
        return employeeRepository.findById(id)
                .map(employeeTransformer::transform)
                .orElseThrow(IllegalArgumentException::new);
    }
}
