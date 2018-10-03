package com.meta.training.service;

import java.util.List;

import com.meta.training.model.Project;

public interface ProjectInter {

	Project getProjectById(int id);

	List<Project> getAllProjects();

	boolean deleteProject(int id);

	boolean updateProject(Project project);

	boolean createProject(Project project);

}
