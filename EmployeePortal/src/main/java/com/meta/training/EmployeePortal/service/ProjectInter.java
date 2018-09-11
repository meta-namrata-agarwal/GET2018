package com.meta.training.EmployeePortal.service;

import java.util.List;

import com.meta.training.EmployeePortal.modal.Project;

public interface ProjectInter {

	Project getProjectById(int id);

	List<Project> getAllProjects();

	boolean deleteProject(int id);

	boolean updateProject(Project project);

	boolean createProject(Project project);

}
