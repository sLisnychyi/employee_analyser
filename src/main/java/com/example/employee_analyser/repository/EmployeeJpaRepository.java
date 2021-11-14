package com.example.employee_analyser.repository;

import com.example.employee_analyser.entity.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public interface EmployeeJpaRepository extends CrudRepository<Employee, Integer> {
    Employee findByName(String name);

    List<Employee> findByNameLike(String name);

    List<Employee> findByNameLikeAndSalaryGreaterThan(String name, int salary);

    List<Employee> findTop3ByOrderBySalaryDesc();

}

