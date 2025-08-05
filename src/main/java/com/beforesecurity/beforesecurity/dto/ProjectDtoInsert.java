package com.beforesecurity.beforesecurity.dto;

import java.time.LocalDate;



public class ProjectDtoInsert {



   private String name;

  private String description;
  

  private String status;

  private LocalDate creationDate;

  public ProjectDtoInsert(String description, String status, LocalDate creationDate) {
    this.description = description;
    this.status = status;
    this.creationDate = creationDate;
  }

  public ProjectDtoInsert() {
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
