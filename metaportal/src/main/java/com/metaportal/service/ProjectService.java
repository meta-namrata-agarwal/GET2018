package com.metaportal.service;

import java.util.List;

import com.metaportal.dao.ProjectDAOImp;
import com.metaportal.modal.Project;


public class ProjectService {

	public static List<Project> getAllProjects() {
		System.out.println( ProjectDAOImp.getAllProjectHelper().toString());
		return ProjectDAOImp.getAllProjectHelper();
	}

	public static Project getProjectById(int id) {
		// TODO Auto-generated method stub
		return ProjectDAOImp.getProjectByIdHelper(id);
	}

	public static void createProject(Project project) {
		int value=ProjectDAOImp.insertProjectHelper(project);
		
		
	}

	public static void updateProject(Project project) {
		int value=ProjectDAOImp.updateProjectHelper(project);
		
	}

	public static void deleteProject(int id) {
		// TODO Auto-generated method stub
		int value=ProjectDAOImp.deleteProjectHelper(id);
		
	}
}
