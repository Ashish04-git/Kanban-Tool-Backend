package com.cg.kanban.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.kanban.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{
	

	@Query("select u from UserModel u where u.role not in ('Admin')")
	public List<UserModel> userList();
	
	@Query("select u from UserModel u where u.role='Developer'")
	public List<UserModel> devList();
	
//	public boolean existByLoginName(String username);
//	
//	public UserModel findByloginName(String loginname);

}
