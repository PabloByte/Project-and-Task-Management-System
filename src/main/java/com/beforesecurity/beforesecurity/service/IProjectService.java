package com.beforesecurity.beforesecurity.service;

import java.util.List;
import java.util.Set;

import com.beforesecurity.beforesecurity.dto.ProjectDto;
import com.beforesecurity.beforesecurity.dto.ProjectDtoInsert;

public interface IProjectService {


  ProjectDto saveProject (ProjectDtoInsert project);

  Set<ProjectDto> showAll ();

  ProjectDto findById (Long id);

  ProjectDto updateProject (Long id, ProjectDtoInsert project);

  void deleteProjectById (Long Id);











}
