package com.beforesecurity.beforesecurity.service;

import java.util.List;

import com.beforesecurity.beforesecurity.dto.CollaboratorDtoInsert;
import com.beforesecurity.beforesecurity.dto.CollaboratorDtoReturn;
import com.beforesecurity.beforesecurity.model.Collaborator;

public interface ICollaboratorService {


  CollaboratorDtoReturn createCollaborator (CollaboratorDtoInsert collaborator );

  List<CollaboratorDtoReturn> showAll ();

  CollaboratorDtoReturn findById (Long id);

 void deleteCollaborator (Long id);

  CollaboratorDtoReturn updateCollaborator(Long id, CollaboratorDtoInsert collaboratorDto);













  

}
