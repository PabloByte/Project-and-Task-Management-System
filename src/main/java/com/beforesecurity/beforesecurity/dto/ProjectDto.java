package com.beforesecurity.beforesecurity.dto;

import java.time.LocalDate;



public class ProjectDto {


 private Long id;

  private String name;

  private String description;
 
  private String status;

  private LocalDate creationDate;

  public ProjectDto() {
  }

  public ProjectDto(Long id, String name, String description, String status, LocalDate creationDate) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.status = status;
    this.creationDate = creationDate;
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

  











}
