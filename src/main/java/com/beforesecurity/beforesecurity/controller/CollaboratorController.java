package com.beforesecurity.beforesecurity.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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



@GetMapping("/showAll")
ResponseEntity<?> showAll (){


List<CollaboratorDtoReturn> listCollaborators = collaboratorServiceImpl.showAll();

return ResponseEntity.status(HttpStatus.ACCEPTED).body(listCollaborators);
}

@GetMapping("/findById/{id}")
ResponseEntity<?> findById (@PathVariable Long id){


CollaboratorDtoReturn idFound = collaboratorServiceImpl.findById(id);

return ResponseEntity.status(HttpStatus.ACCEPTED).body(idFound);
}

@DeleteMapping("/deleteById/{id}")
ResponseEntity<?> deleteById (@PathVariable Long id){


 collaboratorServiceImpl.deleteCollaborator(id);
    return ResponseEntity.noContent().build(); 
}


@PutMapping("/Update/{id}")
ResponseEntity<?> UpdateById (@PathVariable Long id, @RequestBody CollaboratorDtoInsert collaborator ) {

  CollaboratorDtoReturn entityUpdate = collaboratorServiceImpl.updateCollaborator(id, collaborator);

  return  ResponseEntity.status(HttpStatus.FOUND).body(entityUpdate);

}






























}
