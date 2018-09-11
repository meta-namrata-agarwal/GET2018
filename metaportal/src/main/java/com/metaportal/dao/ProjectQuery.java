package com.metaportal.dao;

public class ProjectQuery {

	final static String insertProject = "INSERT INTO PROJECT(projectName,description,startDate)VALUES(?,?,?)";

	final static String getAllProject = "SELECT * FROM PROJECT";

	public static String getAllProjectById = "SELECT * FROM PROJECT WHERE projectId=?";

	public static String updateProject = "update project set description = ? , startDate = ? , endDate = ?, projectLogo = ? , projectName = ? where"
			+ " projectId = ? ";

	public static String deleteById = " update project set isActive = false  where projectId = ? ";

}
