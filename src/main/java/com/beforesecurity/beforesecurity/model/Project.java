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
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
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

   




 





}
