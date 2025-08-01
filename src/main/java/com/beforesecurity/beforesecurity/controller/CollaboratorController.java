package com.beforesecurity.beforesecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beforesecurity.beforesecurity.dto.CollaboratorDtoInsert;
import com.beforesecurity.beforesecurity.dto.CollaboratorDtoReturn;
import com.beforesecurity.beforesecurity.service.CollaboratorServiceImpl;



@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {

private final CollaboratorServiceImpl collaboratorServiceImpl;

public CollaboratorController(CollaboratorServiceImpl collaboratorServiceImpl) {
  this.collaboratorServiceImpl = collaboratorServiceImpl;
}




@PostMapping("/create")
ResponseEntity<?> createCollaborator (@RequestBody CollaboratorDtoInsert collaboratorDtoInsert){


  CollaboratorDtoReturn collaborator = collaboratorServiceImpl.createCollaborator(collaboratorDtoInsert);

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(collaborator);
}






















}
