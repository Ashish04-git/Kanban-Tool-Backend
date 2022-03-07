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

import com.cg.kanban.exception.ProjectException;
import com.cg.kanban.model.ProjectTaskModel;
import com.cg.kanban.service.ProjectTaskServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/projectTask")
public class ProjectTaskController {

	@Autowired
	ProjectTaskServiceImpl service;
	ProjectTaskModel projecttsk;
	
	@PostMapping("/create")
	public ProjectTaskModel createProjectTask(@RequestBody ProjectTaskModel task) throws ProjectException{
		
		projecttsk= service.createProjectTask(task);
		return projecttsk;
	}
	
	@PutMapping("/update")
	public ProjectTaskModel updateProjectTask(@RequestBody ProjectTaskModel task) throws ProjectException{
		
		projecttsk= service.updateProjectTask(task);
		return projecttsk;
	}
	
	@DeleteMapping("/delete/{id}")
	public ProjectTaskModel deleteProjectTask(@PathVariable("id") int id) throws ProjectException{
		
		projecttsk= service.deleteProjectTask(id);
		return projecttsk;
	}
	
	@GetMapping("/list")
	public List<ProjectTaskModel> taskList() throws ProjectException{
		
		List<ProjectTaskModel> list= service.taskList();
		return list;
	}
	
	@GetMapping("/projlist/{proj_identi}")
	public List<ProjectTaskModel> projectList(@PathVariable("proj_identi") String proj_identi) throws ProjectException{
		
		List<ProjectTaskModel> list= service.projectList(proj_identi);
		return list;
	}
	
	@GetMapping("/viewtask/{id}")
	public ProjectTaskModel viewProject(@PathVariable("id") int id) throws ProjectException{
		
		projecttsk= service.viewProjectTask(id);
		return projecttsk;
	}
	
	
}