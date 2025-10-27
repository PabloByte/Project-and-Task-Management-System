package com.beforesecurity.beforesecurity.dto;

import java.time.LocalDate;

public class TaskDto {


private Long id;

private String title;

private String description;


private  String priority;

private LocalDate dueDate;

private String project;

private String colaborador;

private String pdfPath;









public TaskDto(Long id, String title, String description, String priority, LocalDate dueDate, String project,
    String colaborador, String pdfPath) {
  this.id = id;
  this.title = title;
  this.description = description;
  this.priority = priority;
  this.dueDate = dueDate;
  this.project = project;
  this.colaborador = colaborador;
  this.pdfPath = pdfPath;
}



public TaskDto() {
}



public Long getId() {
  return id;
}

public void setId(Long id) {
  this.id = id;
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



public String getProject() {
  return project;
}



public void setProject(String project) {
  this.project = project;
}



public String getColaborador() {
  return colaborador;
}



public void setColaborador(String colaborador) {
  this.colaborador = colaborador;
}



@Override
public String toString() {
  return "TaskDto [id=" + id + ", title=" + title + ", description=" + description + ", priority=" + priority
      + ", dueDate=" + dueDate + ", project=" + project + ", colaborador=" + colaborador + "]";
}



public String getPdfPath() {
  return pdfPath;
}



public void setPdfPath(String pdfPath) {
  this.pdfPath = pdfPath;
}














}
