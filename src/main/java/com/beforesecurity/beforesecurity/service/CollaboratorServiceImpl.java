package com.beforesecurity.beforesecurity.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.beforesecurity.beforesecurity.dto.CollaboratorDtoInsert;
import com.beforesecurity.beforesecurity.dto.CollaboratorDtoReturn;
import com.beforesecurity.beforesecurity.mapper.TodoListMapper;
import com.beforesecurity.beforesecurity.model.AuditData;
import com.beforesecurity.beforesecurity.model.Collaborator;
import com.beforesecurity.beforesecurity.repository.CollaboratorRepository;

@Service
public class CollaboratorServiceImpl implements ICollaboratorService {

  private final CollaboratorRepository collaboratorRepository;

  private final TodoListMapper todoListMapper;

  public CollaboratorServiceImpl(CollaboratorRepository collaboratorRepository, TodoListMapper todoListMapper) {
    this.collaboratorRepository = collaboratorRepository;
    this.todoListMapper = todoListMapper;
  }

  @Override
  public CollaboratorDtoReturn createCollaborator(CollaboratorDtoInsert collaborator) {


    Collaborator newCollaborator = new Collaborator();

    newCollaborator.setFullName(collaborator.getFullName());
    newCollaborator.setEmail(collaborator.getEmail());
    newCollaborator.setPosition(collaborator.getPosition());

    AuditData auditoria = new AuditData();

    auditoria.setCreatedAt(LocalDateTime.now());
    auditoria.setCreatedBy(collaborator.getFullName());

    newCollaborator.setMetadata(auditoria);

    collaboratorRepository.save(newCollaborator);
 
    return  todoListMapper.collaboratorToCollaboratorDtoReturn(newCollaborator);


  }













}
