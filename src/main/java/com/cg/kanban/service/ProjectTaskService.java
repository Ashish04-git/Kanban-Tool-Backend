package com.cg.kanban.service;

import java.util.List;

import com.cg.kanban.exception.ProjectException;
import com.cg.kanban.model.ProjectTaskModel;

public interface ProjectTaskService {
	
	public ProjectTaskModel createProjectTask(ProjectTaskModel task) throws ProjectException;
	
	public ProjectTaskModel updateProjectTask(ProjectTaskModel task) throws ProjectException;
	
	public ProjectTaskModel deleteProjectTask(int id) throws ProjectException;
	
	public List<ProjectTaskModel> taskList() throws ProjectException;
	
	public List<ProjectTaskModel> projectList(String proj_identi) throws ProjectException;

}
