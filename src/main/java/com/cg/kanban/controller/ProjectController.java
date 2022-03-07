package com.cg.kanban.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.kanban.exception.BacklogException;
import com.cg.kanban.exception.ProjectException;
import com.cg.kanban.model.BacklogModel;
import com.cg.kanban.model.ProjectModel;
import com.cg.kanban.service.BacklogServiceImpl;
import com.cg.kanban.service.ProjectServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectServiceImpl service;
	@Autowired
	BacklogServiceImpl backlogservice;
	ProjectModel project;
	
	
	@PostMapping("/create")
	public ProjectModel createProject(@RequestBody ProjectModel proj) throws ProjectException, BacklogException{
		
		BacklogModel back= backlogservice.createBackog(proj.getBacklog()); 
		project= service.createProject(proj);
		return project;
	}
	
	@PutMapping("/update")
	public ProjectModel updateProject(@RequestBody ProjectModel proj) throws ProjectException{
		
		project= service.updateProject(proj);
		return project;
	}
	
	@DeleteMapping("/delete/{id}")
	public ProjectModel deleteProject(@PathVariable("id") int id) throws ProjectException, BacklogException{
		
		
		project= service.deleteProject(id);
		BacklogModel backlog= backlogservice.deleteBacklog(project.getBacklog().getBID());
		return project;
	}
	
	@GetMapping("/list")
	public List<ProjectModel> projectList() throws ProjectException{
		
		List<ProjectModel> list= service.projectList();
		return list;
	}
	
	@GetMapping("/viewproject/{id}")
	public ProjectModel viewProject(@PathVariable("id") int id) throws ProjectException{
		
		project= service.viewProject(id);
		return project;
	}

}
