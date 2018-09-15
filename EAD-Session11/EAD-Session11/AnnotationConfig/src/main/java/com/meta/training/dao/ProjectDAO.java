package com.meta.training.dao;

import java.util.List;

import com.meta.training.model.Project;

public interface ProjectDAO {

	Project getProjectById(int id);

	List<Project> getAllProjects();

	boolean deleteProject(Project project);

	boolean updateProject(Project project);

	boolean createProject(Project project);
}
