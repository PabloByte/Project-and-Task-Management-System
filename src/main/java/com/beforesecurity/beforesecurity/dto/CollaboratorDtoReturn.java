package com.beforesecurity.beforesecurity.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.beforesecurity.beforesecurity.model.Project;
import com.beforesecurity.beforesecurity.model.Task;

public class CollaboratorDtoReturn {


 private Long id;

  private String fullName;

  private String email;

  private String position;

  private Set<ProjectDto> proyectos ;  
  private List<TaskDto> tareas ;


  public CollaboratorDtoReturn(Long id, String fullName, String email, String position, Set<ProjectDto> proyectos,
      List<TaskDto> tareas) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
    this.position = position;
    this.proyectos = proyectos;
    this.tareas = tareas;
  }




  public CollaboratorDtoReturn() {

    tareas = new ArrayList<>();
    proyectos = new HashSet<>();
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




  public Set<ProjectDto> getProyectos() {
    return proyectos;
  }




  public void setProyectos(Set<ProjectDto> proyectos) {
    this.proyectos = proyectos;
  }




  public List<TaskDto> getTareas() {
    return tareas;
  }




  public void setTareas(List<TaskDto> tareas) {
    this.tareas = tareas;
  }




  @Override
  public String toString() {
    return "CollaboratorDtoReturn [id=" + id + ", fullName=" + fullName + ", email=" + email + ", position=" + position
        + ", proyectos=" + proyectos + ", tareas=" + tareas + "]";
  }













}
