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

import com.cg.kanban.exception.UserException;
import com.cg.kanban.model.UserModel;
import com.cg.kanban.service.UserServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	UserModel user;
	
	@PostMapping("/add")
	public UserModel addUser(@RequestBody UserModel us) throws UserException{
		
		user= service.addUser(us);
		return user;
	}
	
	@PutMapping("/update")
	public UserModel updateUser(@RequestBody UserModel us) throws UserException{
		
		user= service.updateUser(us);
		return user;
	}
	
	@DeleteMapping("/delete/{id}")
	public UserModel deleteUser(@PathVariable("id") int id) throws UserException{
		
		user= service.deleteUser(id);
		return user;
	}
	
	@GetMapping("/list")
	public List<UserModel> getUserList() throws UserException{
		
		List<UserModel> list= service.getUserList();
		return list;
	}
	
	@GetMapping("/userlist")
	public List<UserModel> userList() throws UserException{
		
		List<UserModel> list= service.userList();
		return list;
	}
	
	@GetMapping("/devlist")
	public List<UserModel> devList() throws UserException{
		
		List<UserModel> list= service.devList();
		return list;
		
	}
	
	@GetMapping("/userid/{id}")
	public UserModel getUserById(@PathVariable("id") int id) throws UserException{
		
		user= service.getUserById(id);
		return user;
	}
	
	@GetMapping("/validate/{loginname}/{password}")
	public boolean validate(@PathVariable("loginname") String loginname, @PathVariable("password") String password) {
		
		boolean flag= service.validate(loginname, password);
		return flag;
	}
	
//	@GetMapping("/loginname/{login}")
//	public UserModel getUser(@PathVariable("loginname") String loginname) {
//		return this.service.getUserByUsername(loginname);
//	}
	
}
