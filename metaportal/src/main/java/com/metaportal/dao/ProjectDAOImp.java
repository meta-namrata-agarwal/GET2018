package com.metaportal.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metaportal.modal.Project;

public class ProjectDAOImp {

	public  static int  insertProjectHelper(Project project) {
		String query = ProjectQuery.insertProject;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {

			statement.setString(1, project.getName());
			statement.setString(2,project.getDescription());
			statement.setDate(3,java.sql.Date.valueOf(project.getStartDate()) );
			statement.executeUpdate();
			return 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return 0;
		}
	}

	public static List<Project> getAllProjectHelper() {
		List<Project> list = new ArrayList<Project>();
		String query = ProjectQuery.getAllProject;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {
			ResultSet rest = statement.executeQuery();
			
			while (rest.next()) {
				Project project = new Project();
				project.setId(rest.getInt("projectId"));
				project.setName(rest.getString("projectName"));
				project.setDescription(rest.getString("description"));
				project.setStartDate(rest.getString("startDate"));
				project.setActive(rest.getBoolean("isActive"));
				
				list.add(project);
			}
			return list;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
	}

	public static Project getProjectByIdHelper(int id) {
		String query = ProjectQuery.getAllProjectById;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {
			statement.setInt(1,id);
			ResultSet rest = statement.executeQuery();
			Project project = new Project();
			while (rest.next()) {
				project.setId(rest.getInt("projectId"));
				project.setName(rest.getString("projectName"));
				project.setDescription(rest.getString("description"));
				project.setStartDate(rest.getString("startDate"));
				project.setActive(rest.getBoolean("isActive"));
				
			}
			return project;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
	}

	public static int updateProjectHelper(Project project) {
		// TODO Auto-generated method stub
		String query=ProjectQuery.updateProject;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {

			
			statement.setString(1,project.getDescription());
			statement.setDate(2,java.sql.Date.valueOf(project.getStartDate()));
			statement.setDate(3,java.sql.Date.valueOf(project.getEndDate()));
			statement.setString(4, project.getLogo());
			statement.setString(5, project.getName());
			statement.setInt(6, project.getId());
			statement.executeUpdate();
			return 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return 0;
		}
		
	}

	public static int deleteProjectHelper(int id) {
		// TODO Auto-generated method stub
		String query=ProjectQuery.deleteById;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {

			statement.setInt(1, id);
			statement.executeUpdate();
			return 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return 0;
		}
	}
}
