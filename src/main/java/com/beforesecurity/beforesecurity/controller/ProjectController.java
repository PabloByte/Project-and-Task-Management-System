package com.beforesecurity.beforesecurity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beforesecurity.beforesecurity.ProjectValidation;
import com.beforesecurity.beforesecurity.dto.ProjectDto;
import com.beforesecurity.beforesecurity.dto.ProjectDtoInsert;
import com.beforesecurity.beforesecurity.service.ProjectServiceImpl;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/project")
public class ProjectController {


private final ProjectServiceImpl projectServiceImpl;
private final ProjectValidation validationProject;

public ProjectController(ProjectServiceImpl projectServiceImpl, ProjectValidation validationProject) {
  this.projectServiceImpl = projectServiceImpl;
  this.validationProject = validationProject;
}


@PreAuthorize("hasRole('ADMINISTRATOR')")
@PostMapping("/createProject")
ResponseEntity<?> createProject (@RequestBody ProjectDtoInsert project, BindingResult result ){

  validationProject.validate(project, result);

  if(result.hasErrors()){

    return projectValidation(result);
  }

  ProjectDto newProject = projectServiceImpl.saveProject(project);

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(newProject);

}

@PreAuthorize("hasAnyRole('USER','ADMINISTRATOR')")
@GetMapping("/ShowAll")
ResponseEntity<?> showAllProjects (){

  Set<ProjectDto> projectList = projectServiceImpl.showAll();

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectList);

}

@PreAuthorize("hasAnyRole('USER','ADMINISTRATOR')")
@GetMapping("/findById/{id}")
ResponseEntity<?> findByID (@PathVariable Long id){

  ProjectDto projectFound = projectServiceImpl.findById(id);

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectFound);

}

@PreAuthorize("hasRole('ADMINISTRATOR')")
@PutMapping("/update/{id}")
ResponseEntity<?> updateProject (@PathVariable  Long id, @RequestBody ProjectDtoInsert project){


  ProjectDto projectUpdate = projectServiceImpl.updateProject(id, project);

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectUpdate);
}

@PreAuthorize("hasRole('ADMINISTRATOR')")
@DeleteMapping("/deleteProject/{id}")
public ResponseEntity<?> deleteProject (@RequestParam Long id ){

  projectServiceImpl.deleteProjectById(id);
  return ResponseEntity.noContent().build();


}

    private ResponseEntity<?> projectValidation(BindingResult result) {

        Map<String,String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {

          errors.put(err.getField(), "El campo" + err.getField()+ ""+ err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);


    }

































}
