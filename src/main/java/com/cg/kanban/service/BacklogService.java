package com.cg.kanban.service;

import java.util.List;

import com.cg.kanban.exception.BacklogException;
import com.cg.kanban.model.BacklogModel;

public interface BacklogService {
	
	public List<BacklogModel> backlogList() throws BacklogException;
	
	public BacklogModel getBacklog(int id) throws BacklogException;
	
	public BacklogModel createBackog(BacklogModel backlog) throws BacklogException;
	
	public BacklogModel deleteBacklog(int id) throws BacklogException;

}
