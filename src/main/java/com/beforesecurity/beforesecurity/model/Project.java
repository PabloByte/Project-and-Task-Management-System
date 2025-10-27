package com.beforesecurity.beforesecurity.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;





@Entity
public class Project {


  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Id
  private Long id;

  private String name;

  private String description;
  
  @Enumerated(EnumType.STRING)
  private Status status;

  private LocalDate creationDate;

  @Embedded
  private AuditData metadata;

  @OneToMany(mappedBy="project",orphanRemoval=true,cascade=CascadeType.ALL)
   private List<Task> tasks;


   @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
   private Set<Collaborator> colaboradores;

  public Project() {

    tasks= new ArrayList<>();
    this.colaboradores = new HashSet<>();
  }

  public Project(Long id, String name, String description, Status status, LocalDate creationDate, AuditData metadata) {
    this();
    this.name = name;
    this.description = description;
    this.status = status;
    this.creationDate = creationDate;
    this.metadata = metadata;
    
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

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public AuditData getMetadata() {
    return metadata;
  }

  public void setMetadata(AuditData metadata) {
    this.metadata = metadata;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public Set<Collaborator> getColaboradores() {
    return colaboradores;
  }

  public void setColaboradores(Set<Collaborator> colaboradores) {
    this.colaboradores = colaboradores;
  }


public void addTask (Task task){
  tasks.add(task);
}

@Override
public String toString() {
  return "Project [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
      + ", creationDate=" + creationDate + ", metadata=" + metadata +  "]";
}
  

   




 





}
