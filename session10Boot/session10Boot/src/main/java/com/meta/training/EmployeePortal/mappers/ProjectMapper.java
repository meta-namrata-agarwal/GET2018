package com.meta.training.EmployeePortal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.meta.training.EmployeePortal.modal.Project;

public class ProjectMapper implements RowMapper<Project> {

	public Project mapRow(ResultSet rest, int i) throws SQLException {

		Project project = new Project();
		project.setId(rest.getInt("projectId"));
		project.setName(rest.getString("projectName"));
		project.setDescription(rest.getString("description"));
		project.setStartDate(rest.getString("startDate"));
		project.setStartDate(rest.getString("endDate"));
		project.setLogo(rest.getString("projectLogo"));
		project.setActive(rest.getBoolean("isActive"));
		return project;
	}

}
