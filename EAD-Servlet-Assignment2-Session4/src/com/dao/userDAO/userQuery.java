package com.dao.userDAO;

public class userQuery {

	public static String insertUser() {
		final String query = "insert into user(firstName,lastName,dob,email,password,contactNumber,company)values(?,?,?,?,?,?,?)";
		return query;
	}

	public static String userLogInValidation() {
		final String query = "select * from user where email=? and password=?";
		return query;
	}

	public static String userbyEmail() {
		// TODO Auto-generated method stub
		final String query = "select * from user where email=? ";
		return query;
	}

	public static String userById() {
		final String query = "select * from user where id=? ";
		return query;
	}

	public final static String updateDetails() {
		String updateQuery = "UPDATE user SET firstName=?,lastName=?, dob=? , contactNumber=?  WHERE id=?";
		return updateQuery;
	}

	public static String showAlluser() {
		final String showQuery = "SELECT * FROM user where company=? and not id =?";
		return showQuery;
	}

	public static String insertProfilePic() {
		final String showQuery = "update user set image=? where id=?";
		return showQuery;
	}
}
