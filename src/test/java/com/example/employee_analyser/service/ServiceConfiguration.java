package com.example.employee_analyser.service;

import com.example.employee_analyser.repository.EmployeeJpaRepository;
import com.example.employee_analyser.transformer.EmployeeTransformer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    public EmployeeService employeeService(EmployeeJpaRepository emplRepo,
                                           EmployeeTransformer emplTransf){
        return new EmployeeService(emplRepo, new ModelMapper(), emplTransf);
    }
}
