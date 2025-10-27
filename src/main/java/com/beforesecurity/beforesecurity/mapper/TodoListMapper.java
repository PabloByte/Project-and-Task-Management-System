package com.beforesecurity.beforesecurity.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.beforesecurity.beforesecurity.dto.CollaboratorDtoReturn;
import com.beforesecurity.beforesecurity.dto.ProjectDto;
import com.beforesecurity.beforesecurity.dto.TaskDto;
import com.beforesecurity.beforesecurity.model.Collaborator;
import com.beforesecurity.beforesecurity.model.Project;
import com.beforesecurity.beforesecurity.model.Task;

@Mapper(componentModel= "spring")
public interface TodoListMapper {



  CollaboratorDtoReturn collaboratorToCollaboratorDtoReturn (Collaborator collaborator);
  List<CollaboratorDtoReturn> collaboratorListToCollaboratorDtoReturnsList (List<Collaborator> list);



   @Mapping(source= "status", target="status")
  ProjectDto toDto (Project project);
  Set<ProjectDto> projectListToProjectDtoList ( Set<Project>  proyectos );  





  @Mapping(source= "priority", target="priority")
  @Mapping(source= "project.name", target="project")
  @Mapping(source= "colaborador.fullName", target="colaborador")
  TaskDto toTaskDto (Task task);
  List<TaskDto> listTaskToListTaskDtos (List<Task> tasks);
















  






}
