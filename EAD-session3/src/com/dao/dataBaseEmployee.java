package com.dao;

public class dataBaseEmployee {

	public final static String addEmployee() {
		final String addQuery = "INSERT INTO employee(firstname,lastName,email,age)VALUES(?,?,?,?)";
		return addQuery;
	}

	public final static String searchEmployee() {
		final String searchQuery = "SELECT firstname,lastName,email,age FROM employee WHERE firstName=? and lastName=?";
		return searchQuery;
	}

	public static final String showEmployee() {
		final String showQuery = "SELECT firstname,lastName,email,age, id FROM employee";
		return showQuery;
	}

	public final static String getEmployeeById() {
		String updateQuery = "SELECT firstname,lastName,email,age,id FROM  employee WHERE id=?";
		return updateQuery;

	}

	public final static String updateDetails() {
		String updateQuery = "UPDATE EMPLOYEE SET firstName=?,lastName=?, email=? , age=?  WHERE id=?";
		return updateQuery;

	}

}
