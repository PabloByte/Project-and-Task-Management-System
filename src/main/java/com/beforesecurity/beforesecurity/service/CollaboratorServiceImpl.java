package com.beforesecurity.beforesecurity.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.beforesecurity.beforesecurity.dto.CollaboratorDtoInsert;
import com.beforesecurity.beforesecurity.dto.CollaboratorDtoReturn;
import com.beforesecurity.beforesecurity.mapper.TodoListMapper;
import com.beforesecurity.beforesecurity.model.AuditData;
import com.beforesecurity.beforesecurity.model.Collaborator;
import com.beforesecurity.beforesecurity.repository.CollaboratorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CollaboratorServiceImpl implements ICollaboratorService {

  private final CollaboratorRepository collaboratorRepository;

  private final TodoListMapper todoListMapper;

  private static final Logger logger = LoggerFactory.getLogger(CollaboratorServiceImpl.class);

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

    logger.info("new collaborator created :\"{}\"",newCollaborator);

    collaboratorRepository.save(newCollaborator);
 
    return  todoListMapper.collaboratorToCollaboratorDtoReturn(newCollaborator);


  }

  @Override
  public List<CollaboratorDtoReturn> showAll() {
    List<Collaborator> list = collaboratorRepository.findAll();

    return todoListMapper.collaboratorListToCollaboratorDtoReturnsList(list);
  }

  @Override
  public CollaboratorDtoReturn findById(Long id) {

   Collaborator idFound  = collaboratorRepository.findById(id)
   .orElseThrow(()-> { 
    logger.info("not information found in the db about the id : \"{}\"",id);  
    return new RuntimeException("No se encontro el id");   
  });


    logger.info("Collaborator found sucessfully : \"{}\"",id);
    return todoListMapper.collaboratorToCollaboratorDtoReturn(idFound);
  }

  @Override
  public void deleteCollaborator(Long id) {

    if (!collaboratorRepository.existsById(id)) {
        throw new EntityNotFoundException("Colaborador con id " + id + " no encontrado");
    }

    collaboratorRepository.deleteById(id);
  }





  @Override
  public CollaboratorDtoReturn updateCollaborator(Long id, CollaboratorDtoInsert collaboratorDto) {

    Collaborator existingCollaborator = collaboratorRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Colaborador con id " + id + " no encontrado"));
    existingCollaborator.setFullName(collaboratorDto.getFullName());
    existingCollaborator.setEmail(collaboratorDto.getEmail());
    existingCollaborator.setPosition(collaboratorDto.getPosition());


    AuditData audit = existingCollaborator.getMetadata();
    if (audit == null) {
        audit = new AuditData();
    }
    audit.setUpdatedAt(LocalDateTime.now());
    audit.setUpdatedBy(collaboratorDto.getFullName());

    existingCollaborator.setMetadata(audit);

  
    collaboratorRepository.save(existingCollaborator);

    return todoListMapper.collaboratorToCollaboratorDtoReturn(existingCollaborator);
  }













}
