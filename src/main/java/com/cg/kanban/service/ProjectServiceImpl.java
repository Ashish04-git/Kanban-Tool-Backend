package com.cg.kanban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.kanban.exception.ProjectException;
import com.cg.kanban.model.ProjectModel;
import com.cg.kanban.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository dao;
	ProjectModel project;
	
	@Override
	public ProjectModel createProject(ProjectModel proj) throws ProjectException {
		if(dao.existsById(proj.getId()))
			throw new ProjectException("Project "+proj.getId()+" already exist");
		project= dao.save(proj);
		return project;
	}
	
	@Override
	public ProjectModel updateProject(ProjectModel proj) throws ProjectException {
		
		if(dao.existsById(proj.getId())) {
			project= dao.save(proj);
			return project;
		}
		throw new ProjectException("Project "+proj.getId()+" already exist");
	}
	
	@Override
	public ProjectModel deleteProject(int id) throws ProjectException {
		
		if(dao.existsById(id)) {
			project= dao.findById(id).get();
			dao.deleteById(id);
			return project;
		}
		throw new ProjectException("Invalid Project ID "+id);
	}
	
	@Override
	public List<ProjectModel> projectList() throws ProjectException{
		
		List<ProjectModel> list= dao.findAll();
		 if(list.size()==0) {
			throw new ProjectException("Projects Not Found"); 
		 }
		 return list;
	}
	
	public ProjectModel viewProject(int id) throws ProjectException {
		if(dao.existsById(id)) {
			project= dao.findById(id).get();
			return project;
		}
		throw new ProjectException("Project not found");
	}

}