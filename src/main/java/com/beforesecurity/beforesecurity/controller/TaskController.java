package com.beforesecurity.beforesecurity.controller;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beforesecurity.beforesecurity.dto.TaskDto;
import com.beforesecurity.beforesecurity.dto.TaskDtoInsert;
import com.beforesecurity.beforesecurity.model.Task;
import com.beforesecurity.beforesecurity.service.TaskServiceImpl;


@RestController
@RequestMapping("/task")
public class TaskController {

  private final TaskServiceImpl taskServiceImpl;

  public TaskController(TaskServiceImpl taskServiceImpl) {
    this.taskServiceImpl = taskServiceImpl;
  }

  @PreAuthorize("hasAnyRole('USER','ADMINISTRATOR')")
  @PostMapping("/create")
  ResponseEntity<?> createTask (@RequestBody TaskDtoInsert task ){

    TaskDto taskCreate = taskServiceImpl.createTask(task);

      // Generar URL de descarga usando el ID de la Task creada
    String pdfUrl = "http://localhost:8080/task/" + taskCreate.getId() + "/download";
    taskCreate.setPdfPath(pdfUrl); // Asegúrate de agregar este campo en TaskDto

      Map<String, Object> response = new HashMap<>();
    response.put("task", taskCreate);
    response.put("pdfDownloadUrl", pdfUrl);

    return ResponseEntity.status(HttpStatus.CREATED).body(taskCreate);

  }


  @PreAuthorize("hasAnyRole('USER','ADMINISTRATOR')")
  @GetMapping("/{id}/download")
public ResponseEntity<ByteArrayResource> downloadPdf(@PathVariable Long id) throws IOException {
    Task task = taskServiceImpl.getTaskById(id); // Necesitas este método en el service

    Path pdfPath = Path.of(task.getPdfPath()); // Ruta del PDF guardada en la entidad
    byte[] pdfBytes = Files.readAllBytes(pdfPath);

    return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=task_" + id + ".pdf")
            .contentType(MediaType.APPLICATION_PDF)
            .contentLength(pdfBytes.length)
            .body(new ByteArrayResource(pdfBytes));
}


  

















}
