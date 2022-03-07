package com.cg.kanban.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.kanban.exception.BacklogException;
import com.cg.kanban.model.BacklogModel;
import com.cg.kanban.service.BacklogServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/backlog")
public class BacklogController {

	@Autowired
	BacklogServiceImpl service;
	
	@GetMapping("/list")
	public List<BacklogModel> backlogList() throws BacklogException{
		
		List<BacklogModel> list= service.backlogList();
		return list;
	}
	
	@GetMapping("/backlog/{id}")
	public BacklogModel getBacklog(@PathVariable("id") int id) throws BacklogException{
		
		BacklogModel backlog= service.getBacklog(id);
		return backlog;
	}
	
	@PostMapping("/create")
	public BacklogModel createBackog(@RequestBody BacklogModel backlog) throws BacklogException{
		
		BacklogModel backlg= service.createBackog(backlog);
		return backlg;
	}
	
	@DeleteMapping("/delete/{id}")
	public BacklogModel deleteBacklog(@PathVariable("id") int id) throws BacklogException{
		
		BacklogModel backlg= service.deleteBacklog(id);
		return backlg;
	}
}
