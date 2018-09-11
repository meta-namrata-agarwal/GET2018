package com.metaportal.dao;

public class EmployeeQuery {

	final static String insertEmployee = " insert into employee (firstName, lastName, dob, gender, primaryContact, emailId,password)"
			+ "values(?,?,?,?,?,?,?)";

	final static String getAllEmployee = "SELECT * FROM employee";

	public static String getAllEmployeeById = "SELECT * FROM employee WHERE empCode=?";

	public static String updateEmployee = "update employee set firstName = ? , lastName = ? , dob = ?, gender = ?  ,emailId= ?, password=?  where"
			+ " empCode = ? ";

	public static String deleteById = " update employee set isActive = false  where empCode = ? ";
}
