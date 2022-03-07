package com.cg.kanban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.kanban.exception.ProjectException;
import com.cg.kanban.model.ProjectModel;
import com.cg.kanban.model.ProjectTaskModel;
import com.cg.kanban.repository.ProjectTaskRepository;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService{
	
	@Autowired
	ProjectTaskRepository dao;
	ProjectTaskModel projectTask;
	
	@Override
	public ProjectTaskModel createProjectTask(ProjectTaskModel task) throws ProjectException {
		if(dao.existsById(task.getPtsk_Id())) {
			throw new ProjectException("Project Task Not Found");
		}else {
			projectTask= dao.save(task);
			return projectTask;
		}
	}
	
	@Override
	public ProjectTaskModel updateProjectTask(ProjectTaskModel task) throws ProjectException {
		
		if(dao.existsById(task.getPtsk_Id())) {
			projectTask= dao.save(task);
			return projectTask;
		}else {
			throw new ProjectException("Project Task Not Found");
		}
		
	}
	
	@Override
	public ProjectTaskModel deleteProjectTask(int id) throws ProjectException {
		if(dao.existsById(id)) {
			projectTask= dao.findById(id).get();
			dao.deleteById(id);
			return projectTask;
		}else {
			throw new ProjectException("Project Task Not Found");
		}
		
	}
	
	@Override
	public List<ProjectTaskModel> taskList() throws ProjectException{
		
		List<ProjectTaskModel> list= dao.findAll();
		if(list.size()>0) {
			return list;
		}else {
			throw new ProjectException("No Task Found");
		}
	}
	
	@Override
	public List<ProjectTaskModel> projectList(String proj_identi) throws ProjectException{
		
		List<ProjectTaskModel> list= dao.projectList(proj_identi);
		if(list.size()>0) {
			return list;
		}else {
			throw new ProjectException("No Task Found");
		}
	}
	
	public ProjectTaskModel viewProjectTask(int id) throws ProjectException {
		if(dao.existsById(id)) {
			projectTask= dao.findById(id).get();
			return projectTask;
		}
		throw new ProjectException("No Task Found");
	}


	}