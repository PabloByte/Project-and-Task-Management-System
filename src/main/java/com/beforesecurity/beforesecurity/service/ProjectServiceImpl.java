package com.beforesecurity.beforesecurity.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.el.stream.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.beforesecurity.beforesecurity.dto.ProjectDto;
import com.beforesecurity.beforesecurity.dto.ProjectDtoInsert;
import com.beforesecurity.beforesecurity.mapper.TodoListMapper;
import com.beforesecurity.beforesecurity.model.AuditData;
import com.beforesecurity.beforesecurity.model.Project;
import com.beforesecurity.beforesecurity.model.Status;
import com.beforesecurity.beforesecurity.repository.proyectrepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjectServiceImpl implements IProjectService {

  private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

  private final proyectrepository proyectrepository;

  private final TodoListMapper todoListMapper;

  public ProjectServiceImpl(com.beforesecurity.beforesecurity.repository.proyectrepository proyectrepository,
      TodoListMapper todoListMapper) {
    this.proyectrepository = proyectrepository;
    this.todoListMapper = todoListMapper;
  }


  @Override
  public ProjectDto saveProject(ProjectDtoInsert project) {

logger.info("starting creating project for: \"{}\"",project.getName());

    Project newProject = new Project();

    newProject.setName(project.getName());
    newProject.setDescription(project.getDescription());
    newProject.setStatus(Status.valueOf(project.getStatus()));
    newProject.setCreationDate(project.getCreationDate());
    AuditData auditoria = new AuditData();

    auditoria.setCreatedAt(LocalDateTime.now());
    auditoria.setCreatedBy(project.getName());

    newProject.setMetadata(auditoria);

    proyectrepository.save(newProject);
     logger.info("project create sucessfully: \"{}\"", newProject.getName());

    return todoListMapper.toDto(newProject);

  

   

  }


  @Override
  public Set<ProjectDto> showAll() {

      List<Project> projectList = proyectrepository.findAll();

      Set<Project> projectSet = new HashSet<>(projectList);

      return todoListMapper.projectListToProjectDtoList(projectSet);
  }


  @Override
  public ProjectDto findById(Long id) {


    Project projectFound = proyectrepository.findById(id)
    .orElseThrow(()->{
      logger.info("not information in the db about the project: \"{}\"", id);
     return new RuntimeException("No se encontro el proyecto con el id "+ id);  });


     logger.info("Project found , information : \"{}\"", projectFound.getName());
    return todoListMapper.toDto(projectFound);
    
  }


  @Override
  public ProjectDto updateProject(Long id, ProjectDtoInsert projectDto) {

       java.util.Optional <Project> optionalProject = proyectrepository.findById(id);
    if (optionalProject.isEmpty()) {
        throw new EntityNotFoundException("Proyecto con ID " + id + " no encontrado.");
    }

    Project existingProject = optionalProject.get();
    existingProject.setName(projectDto.getName());
    existingProject.setDescription(projectDto.getDescription());

    existingProject.setStatus(Status.valueOf(projectDto.getStatus().toUpperCase()));

    existingProject.setCreationDate(projectDto.getCreationDate());

    Project updatedProject = proyectrepository.save(existingProject);

    return todoListMapper.toDto(updatedProject);
    
  }


  @Override
  public void deleteProjectById(Long Id) {

    if(!proyectrepository.existsById(Id)){
   throw new EntityNotFoundException("Proyecto con id "+ Id + "No encontrado"); }
   proyectrepository.deleteById(Id);

  }
























  

}
