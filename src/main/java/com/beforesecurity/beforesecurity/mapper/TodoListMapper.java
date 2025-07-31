package com.beforesecurity.beforesecurity.mapper;

import org.mapstruct.Mapper;

import com.beforesecurity.beforesecurity.dto.CollaboratorDtoReturn;
import com.beforesecurity.beforesecurity.model.Collaborator;

@Mapper(componentModel= "spring")
public interface TodoListMapper {



  CollaboratorDtoReturn collaboratorToCollaboratorDtoReturn (Collaborator collaborator);

// debo crear un dto para las caracteristicas complejas del entity collaborator , que tienen set y list




}
