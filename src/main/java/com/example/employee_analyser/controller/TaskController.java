package com.example.employee_analyser.controller;

import com.example.employee_analyser.entity.Task;
import com.example.employee_analyser.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{page}")
    public List<Task> getTasks(@PathVariable("page") int page) {
        return taskService.findAll(page);
    }
}
