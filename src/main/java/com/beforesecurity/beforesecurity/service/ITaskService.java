package com.beforesecurity.beforesecurity.service;

import java.util.List;

import com.beforesecurity.beforesecurity.dto.TaskDto;
import com.beforesecurity.beforesecurity.dto.TaskDtoInsert;
import com.beforesecurity.beforesecurity.model.Task;

public interface ITaskService {


  TaskDto createTask (TaskDtoInsert task);

  List<TaskDto> taskList ();

  TaskDto findById (Long id);

  TaskDto updateId(Long id);
  
  void deleteTaskById (Long id);

  public Task getTaskById(Long id);














}
