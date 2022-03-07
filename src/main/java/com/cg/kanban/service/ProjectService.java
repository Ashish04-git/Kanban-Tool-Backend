package com.cg.kanban.service;

import java.util.List;

import com.cg.kanban.exception.ProjectException;
import com.cg.kanban.model.ProjectModel;

public interface ProjectService {
	
	public ProjectModel createProject(ProjectModel proj) throws ProjectException;
	
	public ProjectModel updateProject(ProjectModel proj) throws ProjectException;
	
	public ProjectModel deleteProject(int id) throws ProjectException;
	
	public List<ProjectModel> projectList() throws ProjectException;

}
