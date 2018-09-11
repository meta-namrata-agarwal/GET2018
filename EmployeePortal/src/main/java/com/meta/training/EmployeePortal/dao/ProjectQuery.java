package com.meta.training.EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.meta.training.EmployeePortal.mappers.ProjectMapper;
import com.meta.training.EmployeePortal.modal.Project;

@Repository
public class ProjectQuery implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProjectQuery(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	final static String insertProject = "INSERT INTO PROJECT(projectName,description,startDate)VALUES(?,?,?)";

	final static String getAllProject = "SELECT * FROM PROJECT";

	public static String getAllProjectById = "SELECT * FROM PROJECT WHERE projectId=?";

	public static String updateProject = "update project set description = ? , startDate = ? , endDate = ?, projectLogo = ? , projectName = ? where"
			+ " projectId = ? ";

	public static String deleteById = " update project set isActive = false  where projectId = ? ";

	@Override
	public Project getProjectById(int id) {
		return jdbcTemplate.queryForObject(getAllProjectById,
				new Object[] { id }, new ProjectMapper());
	}

	@Override
	public List<Project> getAllProjects() {
		return jdbcTemplate.query(getAllProject, new ProjectMapper());
	}

	@Override
	public boolean deleteProject(Project project) {
		return jdbcTemplate.update(deleteById, project.getId()) > 0;
	}

	@Override
	public boolean updateProject(Project project) {
		return jdbcTemplate.update(updateProject, project.getDescription(),
				project.getStartDate(), project.getEndDate(),
				project.getLogo(), project.getName(), project.getId()) > 0;
	}

	@Override
	public boolean createProject(Project project) {
		return jdbcTemplate.update(insertProject, project.getName(),
				project.getDescription(), project.getStartDate()) > 0;
	}
}
