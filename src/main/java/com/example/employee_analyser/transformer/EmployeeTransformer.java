package com.example.employee_analyser.transformer;

import com.example.employee_analyser.dto.EmployeeTasksDto;
import com.example.employee_analyser.entity.Employee;
import com.example.employee_analyser.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeTransformer {

    public EmployeeTasksDto transform(Employee e) {
        List<String> tasksTitle = Optional.ofNullable(e.getTasks())
                .map(item -> item.stream().map(Task::getTitle).collect(Collectors.toList()))
                .orElseGet(List::of);

        return new EmployeeTasksDto()
                .setTasksTitle(tasksTitle)
                .setEmployeeName(e.getName());
    }
}
