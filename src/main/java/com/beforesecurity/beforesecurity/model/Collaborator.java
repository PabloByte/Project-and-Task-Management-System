package com.beforesecurity.beforesecurity.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Collaborator {


  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Id
  private Long id;

  private String fullName;

  private String email;

  private String position;

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

  













}
