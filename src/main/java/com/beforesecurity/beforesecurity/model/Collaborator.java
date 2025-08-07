package com.beforesecurity.beforesecurity.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;



@Entity
public class Collaborator {


  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Id
  private Long id;

  private String fullName;

  private String email;

  private String position;
  
  @Embedded
  private AuditData metadata;

  @ManyToMany(mappedBy="colaboradores")
  private Set<Project> proyectos ;

  @OneToMany(mappedBy="colaborador", cascade= CascadeType.ALL, orphanRemoval=true) 
  private List<Task> tareas ;

  public Collaborator() {

    proyectos = new HashSet<>();  
    tareas= new ArrayList<>();
  }

  public Collaborator(String fullName, String email, String position, AuditData metadata) {
    this();
    this.fullName = fullName;
    this.email = email;
    this.position = position;
    this.metadata = metadata;
    
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public AuditData getMetadata() {
    return metadata;
  }

  public void setMetadata(AuditData metadata) {
    this.metadata = metadata;
  }

  public Set<Project> getProyectos() {
    return proyectos;
  }

  public void setProyectos(Set<Project> proyectos) {
    this.proyectos = proyectos;
  }

  public List<Task> getTareas() {
    return tareas;
  }

  public void setTareas(List<Task> tareas) {
    this.tareas = tareas;
  }

  
  public void addTask (Task task){
    tareas.add(task);
  }

  @Override
  public String toString() {
    return "Collaborator [id=" + id + ", fullName=" + fullName + ", email=" + email + ", position=" + position
        + ", metadata=" + metadata + ", proyectos=" + proyectos + ", tareas=" + tareas + "]";
  }
  













}
