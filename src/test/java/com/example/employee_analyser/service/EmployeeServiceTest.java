package com.example.employee_analyser.service;

import com.example.employee_analyser.dto.EmployeeTasksDto;
import com.example.employee_analyser.repository.EmployeeJpaRepository;
import com.example.employee_analyser.transformer.EmployeeTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class EmployeeServiceTest {

//
//    @Test
//    public void should_getEmployee_when_idExists() {
//        assertThat(employeeService.findById(1))
//                .extracting(EmployeeTasksDto::getEmployeeName)
//                .isEqualTo("Artem");
//
//    }


}