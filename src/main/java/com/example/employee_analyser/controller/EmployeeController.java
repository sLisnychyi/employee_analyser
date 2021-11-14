package com.example.employee_analyser.controller;

import com.example.employee_analyser.dto.EmployeeDto;
import com.example.employee_analyser.dto.EmployeeTasksDto;
import com.example.employee_analyser.entity.Employee;
import com.example.employee_analyser.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    EmployeeDto getEmployee(@RequestParam(value = "name") String name) {
        return employeeService.getEmployee(name);
    }

    @PostMapping
    void getEmployee(@RequestBody List<Employee> employees) {
        employeeService.save(employees);
    }

    @GetMapping ("/{name}/{salary}")
    Map<String, List<Employee>> getAgregateResult(@PathVariable ("name") String name, @PathVariable ("salary") int salary ){
        List<Employee> employees = employeeService.getEmployees(name);
        List<Employee> employeeBySalary = employeeService.getEmployeeBySalary(name, salary);
        List<Employee> top3BySalary = employeeService.findTop3BySalary();
        return Map.of("name_like", employees,
                "name_salary_like", employeeBySalary,
                "top3_salary", top3BySalary);
    }

    @GetMapping("/{id}/tasks")
    public EmployeeTasksDto getEmployeeTasks(@PathVariable ("id") int id){
        return employeeService.findById(id);
    }
}
