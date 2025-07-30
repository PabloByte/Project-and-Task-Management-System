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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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




















}
