package com.beforesecurity.beforesecurity.dto;

import java.time.LocalDate;
import java.util.List;



public class ProjectDto {


 private Long id;

  private String name;

  private String description;
 
  private String status;

  private LocalDate creationDate;

  private List<TaskDto> tasks;

  private List<CollaboratorDtoReturn> colaboradores ;

  public ProjectDto() {
  }


  public ProjectDto(Long id, String name, String description, String status, LocalDate creationDate,
      List<TaskDto> tasks, List<CollaboratorDtoReturn> colaboradores) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.status = status;
    this.creationDate = creationDate;
    this.tasks = tasks;
    this.colaboradores = colaboradores;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }


  public List<TaskDto> getTasks() {
    return tasks;
  }


  public void setTasks(List<TaskDto> tasks) {
    this.tasks = tasks;
  }


  public List<CollaboratorDtoReturn> getColaboradores() {
    return colaboradores;
  }


  public void setColaboradores(List<CollaboratorDtoReturn> colaboradores) {
    this.colaboradores = colaboradores;
  }


  @Override
  public String toString() {
    return "ProjectDto [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
        + ", creationDate=" + creationDate + ", tasks=" + tasks + ", colaboradores=" + colaboradores + "]";
  }

  











}
