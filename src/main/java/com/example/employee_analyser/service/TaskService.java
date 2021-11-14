package com.example.employee_analyser.service;

import com.example.employee_analyser.entity.Task;
import com.example.employee_analyser.repository.TaskRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(int page){
        Sort sort = Sort.by("title").descending();
        PageRequest pageRequest = PageRequest.of(page, 2, sort);
        return taskRepository.findAll(pageRequest).stream().toList();
    }
}
