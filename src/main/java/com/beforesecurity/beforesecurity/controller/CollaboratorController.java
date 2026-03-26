package com.beforesecurity.beforesecurity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import jakarta.validation.Valid;


@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {

private final CollaboratorServiceImpl collaboratorServiceImpl;

public CollaboratorController(CollaboratorServiceImpl collaboratorServiceImpl) {
  this.collaboratorServiceImpl = collaboratorServiceImpl;
}



@PreAuthorize("hasAnyRole('USER','ADMINISTRATOR')")
@PostMapping("/create")
ResponseEntity<?> createCollaborator (@RequestBody @Valid CollaboratorDtoInsert collaboratorDtoInsert, BindingResult result ){

  if(result.hasFieldErrors()) {return Validation(result);}


  CollaboratorDtoReturn collaborator = collaboratorServiceImpl.createCollaborator(collaboratorDtoInsert);

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(collaborator);
}

@PreAuthorize("hasAnyRole('USER','ADMINISTRATOR')")
@GetMapping("/showAll")
ResponseEntity<?> showAll (){


List<CollaboratorDtoReturn> listCollaborators = collaboratorServiceImpl.showAll();

return ResponseEntity.status(HttpStatus.ACCEPTED).body(listCollaborators);
}
@PreAuthorize("hasAnyRole('USER','ADMINISTRATOR')")
@GetMapping("/findById/{id}")
ResponseEntity<?> findById (@PathVariable Long id){


CollaboratorDtoReturn idFound = collaboratorServiceImpl.findById(id);

return ResponseEntity.status(HttpStatus.ACCEPTED).body(idFound);
}


@PreAuthorize("hasRole('ADMINISTRATOR')")
@DeleteMapping("/deleteById/{id}")
ResponseEntity<?> deleteById (@PathVariable Long id){


 collaboratorServiceImpl.deleteCollaborator(id);
    return ResponseEntity.noContent().build(); 
}

@PreAuthorize("hasRole('ADMINISTRATOR')")
@PutMapping("/Update/{id}")
ResponseEntity<?> UpdateById (@PathVariable Long id, @RequestBody CollaboratorDtoInsert collaborator ) {

  CollaboratorDtoReturn entityUpdate = collaboratorServiceImpl.updateCollaborator(id, collaborator);

  return  ResponseEntity.status(HttpStatus.FOUND).body(entityUpdate);

}



    private ResponseEntity<?> Validation(BindingResult result) {

      Map<String,String> errors = new HashMap<>();
      result.getFieldErrors().forEach(err -> {

        errors.put(err.getField(), "el campo "+ err.getField() + " "+ err.getDefaultMessage());
      });

      return ResponseEntity.badRequest().body(errors);
    }






























}
