package com.cg.kanban.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="backlog_tbl")
public class BacklogModel {
	
	@Id
//	@Column(name="BID")
	Integer BID;
	
	@Column(name="PT_seq", length=20)
	String ptSequence;
	
	@Column(name="proj_identi", length=20)
	String projectIdentifier;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "backlog")
	ProjectModel project;
	
	@OneToMany(mappedBy = "backlog")
	@ElementCollection
	@JsonIgnore
	List<ProjectTaskModel> projectTask= new ArrayList<ProjectTaskModel>();

	public BacklogModel(Integer bID, String ptSequence, String projectIdentifier
			) {
		super();
		BID = bID;
		this.ptSequence = ptSequence;
		this.projectIdentifier = projectIdentifier;
	}
	
	

	public BacklogModel() {
		super();
	}



	public Integer getBID() {
		return BID;
	}

	public void setBID(Integer bID) {
		BID = bID;
	}

	public String getPtSequence() {
		return ptSequence;
	}

	public void setPtSequence(String ptSequence) {
		this.ptSequence = ptSequence;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

//	public ProjectModel getProject() {
//		return project;
//	}
//
//	public void setProject(ProjectModel project) {
//		this.project = project;
//	}

//	public List<ProjectTaskModel> getProjectTask() {
//		return projectTask;
//	}
//
//	public void setProjectTask(List<ProjectTaskModel> projectTask) {
//		this.projectTask = projectTask;
//	}

	@Override
	public String toString() {
		return "BacklogModel [BID=" + BID + ", ptSequence=" + ptSequence + ", projectIdentifier=" + projectIdentifier
				+ ", project=" + project + ", projectTask=" + projectTask + "]";
	}
	
	

	

	
	

}
