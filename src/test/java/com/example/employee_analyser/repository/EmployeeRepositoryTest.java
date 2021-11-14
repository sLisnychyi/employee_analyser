package com.example.employee_analyser.repository;

import com.example.employee_analyser.entity.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Set;


import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
//@ActiveProfiles("test")
class EmployeeRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EmployeeJpaRepository employeeRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Sql("/test.sql")
    public void should_getEmployeeByName_when_employeeExists() {
        Employee artem = employeeRepository.findByName("Artem2");
        assertThat(artem).extracting(Employee::getId)
                .isEqualTo(1);
    }

    @Test
    @Sql("/test.sql")
    public void should_findTop3SalariesForEmployess() {
        List<Employee> result = employeeRepository.findTop3ByOrderBySalaryDesc();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result)
                .extracting(Employee::getName)
                .containsExactly("Artem", "Artem2", "Artem4");
    }


}