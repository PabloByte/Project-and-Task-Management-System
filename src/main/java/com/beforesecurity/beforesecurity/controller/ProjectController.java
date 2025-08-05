package com.beforesecurity.beforesecurity.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beforesecurity.beforesecurity.dto.ProjectDto;
import com.beforesecurity.beforesecurity.dto.ProjectDtoInsert;
import com.beforesecurity.beforesecurity.service.ProjectServiceImpl;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/project")
public class ProjectController {


private final ProjectServiceImpl projectServiceImpl;

public ProjectController(ProjectServiceImpl projectServiceImpl) {
  this.projectServiceImpl = projectServiceImpl;
}


@PostMapping("/createProject")
ResponseEntity<?> createProject (@RequestBody ProjectDtoInsert project ){

  ProjectDto newProject = projectServiceImpl.saveProject(project);

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(newProject);

}

@GetMapping("/ShowAll")
ResponseEntity<?> showAllProjects (){

  Set<ProjectDto> projectList = projectServiceImpl.showAll();

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectList);

}


@GetMapping("/findById/{id}")
ResponseEntity<?> findByID (@PathVariable Long id){

  ProjectDto projectFound = projectServiceImpl.findById(id);

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectFound);

}


@PutMapping("/update/{id}")
ResponseEntity<?> updateProject (@PathVariable  Long id, @RequestBody ProjectDtoInsert project){


  ProjectDto projectUpdate = projectServiceImpl.updateProject(id, project);

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectUpdate);
}


@DeleteMapping("/deleteProject/{id}")
public ResponseEntity<?> deleteProject (@RequestParam Long id ){

  projectServiceImpl.deleteProjectById(id);
  return ResponseEntity.noContent().build();


}

































}
