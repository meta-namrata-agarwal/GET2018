package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



import com.metacube.training.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	@Modifying
	@Query("update Project set isActive=false where id= ?1")
	public int deleteProject(int id);

	public Project findProjectByProjectName(String name);
	
	
}
