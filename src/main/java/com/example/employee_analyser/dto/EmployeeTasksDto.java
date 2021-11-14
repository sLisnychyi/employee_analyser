package com.example.employee_analyser.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeTasksDto {
    @JsonProperty("employee_name")
    private String employeeName;
    @JsonProperty("task_title")
    private List<String> tasksTitle;
}
