package com.beforesecurity.beforesecurity.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.beforesecurity.beforesecurity.dto.TaskDto;
import com.beforesecurity.beforesecurity.dto.TaskDtoInsert;
import com.beforesecurity.beforesecurity.mapper.TodoListMapper;
import com.beforesecurity.beforesecurity.model.AuditData;
import com.beforesecurity.beforesecurity.model.Collaborator;
import com.beforesecurity.beforesecurity.model.Priority;
import com.beforesecurity.beforesecurity.model.Project;
import com.beforesecurity.beforesecurity.model.Task;
import com.beforesecurity.beforesecurity.repository.CollaboratorRepository;
import com.beforesecurity.beforesecurity.repository.proyectrepository;
import com.beforesecurity.beforesecurity.repository.taskrepository;

@Service
public class TaskServiceImpl implements ITaskService {

  private static final Logger logger  = LoggerFactory.getLogger(TaskServiceImpl.class); 

  private final taskrepository taskrepository;
  private final TodoListMapper convert;
  private final proyectrepository projectRepository;
  private final CollaboratorRepository collaboratorRepository;

 


  public TaskServiceImpl(com.beforesecurity.beforesecurity.repository.taskrepository taskrepository,
      TodoListMapper convert, proyectrepository projectRepository, CollaboratorRepository collaboratorRepository) {
    this.taskrepository = taskrepository;
    this.convert = convert;
    this.projectRepository = projectRepository;
    this.collaboratorRepository = collaboratorRepository;
  }




  Project validateProject (Long idProject){
    Project projectFound = projectRepository.findById(idProject).orElseThrow(()-> new RuntimeException("No se encontro el id del proyecto que se quiere asignar a la Task")); 
    return projectFound;
  }

  Collaborator validateCollaborator (Long idCollaborator){
    Collaborator collaboratorFound = collaboratorRepository.findById(idCollaborator).orElseThrow(()-> new RuntimeException("No se encontro el colaborador con el id indicado para agregar a la Task"));
    return collaboratorFound;
  }




  @Override
  public TaskDto createTask(TaskDtoInsert task) {

      Task newTask = new Task();

      newTask.setTitle(task.getTitle());
      newTask.setDescription(task.getDescription());
      newTask.setPriority(Priority.valueOf(task.getPriority()));
      newTask.setDueDate(task.getDueDate());

      Project projectAssignet = validateProject(task.getProject());
      newTask.setProject(projectAssignet);
      projectAssignet.getTasks().add(newTask);

      Collaborator collaboratorFound = validateCollaborator(task.getColaborador());
      newTask.setColaborador(collaboratorFound);
      collaboratorFound.getTareas().add(newTask);

      AuditData auditoria = new AuditData();
      auditoria.setCreatedAt(LocalDateTime.now());
      auditoria.setCreatedBy(task.getDescription());

      newTask.setMetadata(auditoria);


      logger.info("create new task, information task, project and collaborator added : \"{}\"", newTask.getDescription(), newTask.getProject(), newTask.getColaborador());
      taskrepository.save(newTask);

    return convert.toTaskDto(newTask);
  }

  

  @Override
  public List<TaskDto> taskList() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'taskList'");
  }

  @Override
  public TaskDto findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public TaskDto updateId(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateId'");
  }

  @Override
  public void deleteTaskById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteTaskById'");
  }

}
