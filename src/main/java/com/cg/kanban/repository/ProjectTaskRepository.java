package com.cg.kanban.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.kanban.model.ProjectTaskModel;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTaskModel, Integer>{
	
	@Query("select p from ProjectTaskModel p where p.backlog.projectIdentifier=:p1")
	public List<ProjectTaskModel> projectList(@Param("p1") String proj_identi);


}
