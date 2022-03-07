package com.cg.kanban.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="project_tbl")
public class ProjectModel {
	
	@Id
	@Column(name="pid")
	Integer id;
	
	@Column(name="proj_nm", length=20)
	String projectName;
	
	@Column(name="proj_identifier", length=20)
	String projectIdentifier;
	
	@Column(name="des", length=20)
	String description;
	
	@Column
	LocalDate startDate;
	
	@Column
	LocalDate endDate;
	
	@Column
	LocalDate createdAt;
		
	@Column
	LocalDate updateAt;
	
	@OneToOne
	BacklogModel backlog;

	public ProjectModel(Integer id, String projectName, String projectIdentifier, String description,
			LocalDate startDate, LocalDate endDate, LocalDate createdAt, LocalDate updateAt, BacklogModel backlog) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectIdentifier = projectIdentifier;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
//		this.backlog = backlog;
	}

	public ProjectModel() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDate updateAt) {
		this.updateAt = updateAt;
	}

	public BacklogModel getBacklog() {
		return backlog;
	}

	public void setBacklog(BacklogModel backlog) {
		this.backlog = backlog;
	}

	@Override
	public String toString() {
		return "ProjectModel [id=" + id + ", projectName=" + projectName + ", projectIdentifier=" + projectIdentifier
				+ ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", createdAt="
				+ createdAt + ", updateAt=" + updateAt +  "]";
	}

	
	
	

	
}
