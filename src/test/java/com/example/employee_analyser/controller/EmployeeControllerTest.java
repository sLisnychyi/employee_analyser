package com.example.employee_analyser.controller;

import com.example.employee_analyser.dto.EmployeeDto;
import com.example.employee_analyser.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    EmployeeService employeeService;

    @Test
    public void should__when_() throws Exception {
        String name = "aaa";
        when(employeeService.getEmployee(name)).thenReturn(
                new EmployeeDto().setName(name)
        );
        mockMvc.perform(get("/employees?name=aaa"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json("{'name'='aaa', 'salary'=0}"));
    }

}