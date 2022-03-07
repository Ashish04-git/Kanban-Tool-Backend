package com.cg.kanban.service;

import java.util.List;

import com.cg.kanban.exception.UserException;
import com.cg.kanban.model.UserModel;

public interface UserService {
	
	public UserModel addUser(UserModel us) throws UserException;
	
	public UserModel deleteUser(int id) throws UserException;

	public UserModel updateUser(UserModel us) throws UserException;
	
	public List<UserModel> getUserList() throws UserException;
	
	public List<UserModel> userList() throws UserException;
	
	public List<UserModel> devList() throws UserException;
	
//	public boolean isUserExistByUsername(String username);
//	
//	public UserModel getUserByUsername(String loginname);
}
