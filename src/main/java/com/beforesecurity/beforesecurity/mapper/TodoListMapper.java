package com.beforesecurity.beforesecurity.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.beforesecurity.beforesecurity.dto.CollaboratorDtoReturn;
import com.beforesecurity.beforesecurity.dto.ProjectDto;
import com.beforesecurity.beforesecurity.dto.TaskDto;
import com.beforesecurity.beforesecurity.dto.UserAccountDtoInsert;
import com.beforesecurity.beforesecurity.dto.UserAccountDtoReturn;
import com.beforesecurity.beforesecurity.model.Collaborator;
import com.beforesecurity.beforesecurity.model.Project;
import com.beforesecurity.beforesecurity.model.Role;
import com.beforesecurity.beforesecurity.model.Task;
import com.beforesecurity.beforesecurity.model.UserAccount;

@Mapper(componentModel= "spring")
public interface TodoListMapper {



  CollaboratorDtoReturn collaboratorToCollaboratorDtoReturn (Collaborator collaborator);
  List<CollaboratorDtoReturn> collaboratorListToCollaboratorDtoReturnsList (List<Collaborator> list);



  default Set<String> mapRoles(Set<Role> roles) {
    if (roles == null) return null;

    return roles.stream()
            .map(Role::getRoleName) // 👈 ajusta según tu campo
            .collect(Collectors.toSet());
}

 @Mapping(target= "roles", expression= "java(mapRoles(userAccount.getRoles()))")
 List<UserAccountDtoReturn> listUserAccountToUserAccountDtoReturns ( List<UserAccount> list);
 UserAccountDtoReturn UserAccountToUserAccountDtoReturn (UserAccount userInf);



   @Mapping(source= "status", target="status")
  ProjectDto toDto (Project project);
  Set<ProjectDto> projectListToProjectDtoList ( Set<Project>  proyectos );  





  @Mapping(source= "priority", target="priority")
  @Mapping(source= "project.name", target="project")
  @Mapping(source= "colaborador.fullName", target="colaborador")
  TaskDto toTaskDto (Task task);
  List<TaskDto> listTaskToListTaskDtos (List<Task> tasks);
















  






}
