package com.cg.kanban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.kanban.exception.UserException;
import com.cg.kanban.model.UserModel;
import com.cg.kanban.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository dao;
	UserModel user;
	
	@Override
	public UserModel addUser(UserModel us) throws UserException {
		if(dao.existsById(us.getId()))
			throw new UserException("User "+us.getId()+" already exist");
		user= dao.save(us);
		return user;
		
	}
	
	@Override
	public UserModel deleteUser(int id) throws UserException {
		if(dao.existsById(id)) {
			user= dao.findById(id).get();
			dao.deleteById(id);
			return user;
			
		}
		throw new UserException("User "+id+" not found");
		
	}
	
	@Override
	public UserModel updateUser(UserModel us) throws UserException {
		
		if(dao.existsById(us.getId())) {
			user= dao.save(us);
			return user;
		}
		throw new UserException("User "+us.getId()+" not found");
	}
	
	@Override
	public List<UserModel> getUserList() throws UserException{
		List<UserModel> list= dao.findAll();
		if(list.size()>0)
			return list;
		throw new UserException("No Users Found");
	}
	
	@Override
	public List<UserModel> userList() throws UserException{
		
		List<UserModel> list= dao.userList();
		if(list.size()>0)
			return list;
		throw new UserException("No Users Found");
	}
	
	@Override
	public List<UserModel> devList() throws UserException{
		
		List<UserModel> list= dao.devList();
		if(list.size()>0)
			return list;
		throw new UserException("No Users Found");
	}
	
	public UserModel getUserById(int id) throws UserException {
		if(dao.existsById(id)) {
			user= dao.findById(id).get();
			return user;		
		}
		throw new UserException("User not found");
	}
	
	public boolean validate(String loginname, String password) {
		List<UserModel> users=dao.findAll();
		for(UserModel u: users) {
			if(u.getLoginname().equals(loginname)&& u.getPassword().equals(password))
				return true;
		}
		return false;
	}
	
//	public boolean isUserExistByUsername(String username) {
//		
//		return this.dao.existByLoginName(username);
//	}
//	
//	public UserModel getUserByUsername(String loginname) {
//		return this.dao.findByloginName(loginname);
//	}
	

}
