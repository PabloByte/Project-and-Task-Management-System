package com.beforesecurity.beforesecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beforesecurity.beforesecurity.dto.TaskDto;
import com.beforesecurity.beforesecurity.dto.TaskDtoInsert;
import com.beforesecurity.beforesecurity.service.TaskServiceImpl;

@RestController
@RequestMapping("/task")
public class TaskController {

  private final TaskServiceImpl taskServiceImpl;

  public TaskController(TaskServiceImpl taskServiceImpl) {
    this.taskServiceImpl = taskServiceImpl;
  }


  @PostMapping("/create")
  ResponseEntity<?> createTask (@RequestBody TaskDtoInsert task ){

    TaskDto taskCreate = taskServiceImpl.createTask(task);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskCreate);

  }

  

















}
