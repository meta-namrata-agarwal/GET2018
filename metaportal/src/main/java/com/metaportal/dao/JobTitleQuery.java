package com.metaportal.dao;

public class JobTitleQuery {

	final static String getAllJobs="Select * from jobtitlemaster";

	final static String insertJob = "INSERT INTO jobtitlemaster(jobTitle)VALUES(?)";


	final static String getJobById = "SELECT * FROM jobtitlemaster WHERE jobCode= ? ";

	final static String updateJob = "update jobtitlemaster set jobTitle= ?  where jobCode = ? ";

	final static String deleteById = " update jobtitlemaster set isActive = false  where jobCode = ? ";
}

