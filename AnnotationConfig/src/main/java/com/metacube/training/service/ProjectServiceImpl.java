package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project getProjectById(int id) {

		return projectRepository.findOne(id);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	@Transactional
	public boolean deleteProject(int id) {
		try{
			projectRepository.deleteProject(id);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean updateProject(Project project) {
		try {
			projectRepository.save(project);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean createProject(Project project) {
		try {
			projectRepository.save(project);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public Project findProjectByName(String name) {
		// TODO Auto-generated method stub
		return projectRepository.findProjectByProjectName(name);
	}

}
