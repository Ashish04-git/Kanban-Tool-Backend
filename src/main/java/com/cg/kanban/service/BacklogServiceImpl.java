package com.cg.kanban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.kanban.exception.BacklogException;
import com.cg.kanban.model.BacklogModel;
import com.cg.kanban.repository.BacklogRepository;

@Service
public class BacklogServiceImpl implements BacklogService{
	
	@Autowired
	BacklogRepository dao;
	
	@Override
	public List<BacklogModel> backlogList() throws BacklogException{
		
		List<BacklogModel> list= dao.findAll();
		if(list.size()>0) {
			return list;
		}
		throw new BacklogException("No Backlogs Found");
	}
	
	@Override
	public BacklogModel getBacklog(int id) throws BacklogException {
		if(dao.existsById(id)) {
			BacklogModel backlog= dao.findById(id).get();
			return backlog;
		}
		throw new BacklogException("No Backlog Found");
	}
	
	@Override
	public BacklogModel createBackog(BacklogModel backlog) throws BacklogException {
		if(dao.existsById(backlog.getBID())) {
			throw new BacklogException("Backlog "+backlog.getBID()+" already exist");
		}else {
			BacklogModel backlg= dao.save(backlog);
			return backlg;
		}
		
	}
	
	@Override
	public BacklogModel deleteBacklog(int id) throws BacklogException {
		if(dao.existsById(id)) {
			BacklogModel backlg= dao.findById(id).get();
			dao.deleteById(id);
			return backlg;
		}else {
			throw new BacklogException("Backlog "+id+" doesnt exist");
		}
		
	}
	
	

}
