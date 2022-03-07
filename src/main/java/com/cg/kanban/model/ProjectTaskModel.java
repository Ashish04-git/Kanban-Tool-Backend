package com.cg.kanban.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="projecttask_tbl")
public class ProjectTaskModel {
	
	@Id
	Integer Ptsk_Id;
	
	@Column(name="proj_seq", length=20)
	String projectSequence;
	
	@Column(length=20)
	String summary;
	
	@Column(name="acceptance", length=20)
	String acceptanceCriteria;
	
	@Column(length=20)
	String status;

	@Column
	Integer priority;
	
	@Column
	LocalDate dueDate;
	
	@ManyToOne
	BacklogModel backlog;
	
	@Column
	LocalDate createdAt;
	
	@Column
	LocalDate updatedAt;

	public ProjectTaskModel(Integer ptsk_Id, String projectSequence, String summary, String acceptanceCriteria,
			String status, Integer priority, LocalDate dueDate, BacklogModel backlog, 
			LocalDate createdAt, LocalDate updatedAt) {
		super();
		this.Ptsk_Id = ptsk_Id;
		this.projectSequence = projectSequence;
		this.summary = summary;
		this.acceptanceCriteria = acceptanceCriteria;
		this.status = status;
		this.priority = priority;
		this.dueDate = dueDate;
		this.backlog = backlog;
//		this.projectIdentifier = projectIdentifier;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public ProjectTaskModel() {
		super();
	}

	public Integer getPtsk_Id() {
		return Ptsk_Id;
	}

	public void setPtsk_Id(Integer ptsk_Id) {
		Ptsk_Id = ptsk_Id;
	}

	public String getProjectSequence() {
		return projectSequence;
	}

	public void setProjectSequence(String projectSequence) {
		this.projectSequence = projectSequence;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public BacklogModel getBacklog() {
		return backlog;
	}

	public void setBacklog(BacklogModel backlog) {
		this.backlog = backlog;
	}

//	public String getProjectIdentifier() {
//		return projectIdentifier;
//	}
//
//	public void setProjectIdentifier(String projectIdentifier) {
//		this.projectIdentifier = projectIdentifier;
//	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}


	
	
	
	
	
}
