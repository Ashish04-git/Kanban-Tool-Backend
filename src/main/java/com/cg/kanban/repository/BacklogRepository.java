package com.cg.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.kanban.model.BacklogModel;

@Repository
public interface BacklogRepository extends JpaRepository<BacklogModel, Integer>{

}
