package com.beforesecurity.beforesecurity.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Task {


@Id  
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String title;

private String description;

@Enumerated(EnumType.STRING)
private  Priority priority;

private LocalDate dueDate;

private AuditData metadata;

@ManyToOne
@JoinColumn(name="project_id")
private Project project;

@JoinColumn(name="colaborador_id")
@ManyToOne 
private Collaborator colaborador;

public Task() {
}

public Task(Long id, String title, String description, Priority priority, LocalDate dueDate, AuditData metadata,
    Project project, Collaborator colaborador) {
  this.id = id;
  this.title = title;
  this.description = description;
  this.priority = priority;
  this.dueDate = dueDate;
  this.metadata = metadata;
  this.project = project;
  this.colaborador = colaborador;
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

public Priority getPriority() {
  return priority;
}

public void setPriority(Priority priority) {
  this.priority = priority;
}

public LocalDate getDueDate() {
  return dueDate;
}

public void setDueDate(LocalDate dueDate) {
  this.dueDate = dueDate;
}

public AuditData getMetadata() {
  return metadata;
}

public void setMetadata(AuditData metadata) {
  this.metadata = metadata;
}

public Project getProject() {
  return project;
}

public void setProject(Project project) {
  this.project = project;
}

public Collaborator getColaborador() {
  return colaborador;
}

public void setColaborador(Collaborator colaborador) {
  this.colaborador = colaborador;
}

@Override
public String toString() {
  return "Task [id=" + id + ", title=" + title + ", description=" + description + ", priority=" + priority
      + ", dueDate=" + dueDate + ", metadata=" + metadata + ", project=" + project + ", colaborador=" + colaborador
      + "]";
}






















}
