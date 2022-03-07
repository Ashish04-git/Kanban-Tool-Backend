package com.cg.kanban.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_tbl")
public class UserModel {
	
	@Id
	Integer id;
	
	@Column(length=20)
	String name;
	
	@Column(length=20)
	String email;
	
	@Column(length=20)
	String contact;
	
	@Column(length=20)
	String loginname;
	
	@Column(length=20)
	String password;
	
	@Column(length=20)
	String status;
	
	@Column(length=20)
	String role;
	
	public UserModel() {
		super();
	}

	public UserModel(Integer id, String name, String email, String contact, String loginname, String password,
			String status, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.loginname = loginname;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", loginname="
				+ loginname + ", password=" + password + ", status=" + status + ", role=" + role + "]";
	}
	
	

}
