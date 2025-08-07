package com.beforesecurity.beforesecurity.dto;

import java.time.LocalDate;


public class TaskDtoInsert {

private String title;

private String description;

private  String priority;

private LocalDate dueDate;

private Long project;

private Long colaborador;

public TaskDtoInsert(String title, String description, String priority, LocalDate dueDate, Long project,
    Long colaborador) {
  this.title = title;
  this.description = description;
  this.priority = priority;
  this.dueDate = dueDate;
  this.project = project;
  this.colaborador = colaborador;
}

public TaskDtoInsert() {
}

public String getTitle() {
  return title;
}

public void setTitle(String title) {
  this.title = title;
}

public String getDescription() {
  return description;
}

public void setDescription(String description) {
  this.description = description;
}

public String getPriority() {
  return priority;
}

public void setPriority(String priority) {
  this.priority = priority;
}

public LocalDate getDueDate() {
  return dueDate;
}

public void setDueDate(LocalDate dueDate) {
  this.dueDate = dueDate;
}

public Long getProject() {
  return project;
}

public void setProject(Long project) {
  this.project = project;
}

public Long getColaborador() {
  return colaborador;
}

public void setColaborador(Long colaborador) {
  this.colaborador = colaborador;
}

@Override
public String toString() {
  return "TaskDtoInsert [title=" + title + ", description=" + description + ", priority=" + priority + ", dueDate="
      + dueDate + ", project=" + project + ", colaborador=" + colaborador + "]";
}














}
