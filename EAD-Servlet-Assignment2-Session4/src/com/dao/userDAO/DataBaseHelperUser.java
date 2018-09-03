package com.dao.userDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.tomcat.util.http.fileupload.FileItem;

import com.dao.DBInfo;

import com.enums.Status;
import com.model.User;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class DataBaseHelperUser {

	public static int insertUserHelper(String firstName, String lastName,
			Date dob, String email, String password, String contactNumber,
			String company) {

		String addQuery = userQuery.insertUser();
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(addQuery);) {

			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setDate(3, dob);
			statement.setString(4, email);
			statement.setString(5, password);
			statement.setString(6, contactNumber);
			statement.setString(7, company);
			statement.executeUpdate();
			return 1;

		} catch (MySQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null,
					"Duplicate entry for email found!!");
			e.printStackTrace();
			return -1;
		} catch (SQLException sqlException) {
			JOptionPane.showMessageDialog(null, "registration failed");
			sqlException.printStackTrace();
			return 0;
		}
	}

	public static Status userLogInValidationHelper(String email, String password) {
		String query = userQuery.userLogInValidation();

		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {

			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rst = statement.executeQuery();
			if (!rst.next())
				return Status.NOT_FOUND;
			else
				return Status.SUCCESS;
		} catch (SQLException sqlException) {
			JOptionPane.showMessageDialog(null, "registration failed");
			sqlException.printStackTrace();
			return Status.FAILED;
		}
	}

	public static User userbyEmailHelper(String email) {
		String query = userQuery.userbyEmail();

		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {

			statement.setString(1, email);
			ResultSet rest = statement.executeQuery();
			User u = new User();
			while (rest.next()) {
				u.setFirstName(rest.getString("firstName"));
				u.setLastName(rest.getString("lastName"));
				u.setCompany(rest.getString("company"));
				u.setDob(rest.getDate("dob"));
				u.setContactNumber(rest.getString("contactNumber"));
				u.setEmail(rest.getString("email"));
				u.setPassword(rest.getString("password"));
				u.setId(rest.getInt("id"));
			}
			return u;
		} catch (SQLException sqlException) {

			sqlException.printStackTrace();
			return null;
		}
	}

	public static User getUserByIdHelper(int userId) {
		String query = userQuery.userById();

		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {

			statement.setInt(1, userId);
			ResultSet rest = statement.executeQuery();
			User u = new User();
			while (rest.next()) {
				u.setFirstName(rest.getString("firstName"));
				u.setLastName(rest.getString("lastName"));
				u.setCompany(rest.getString("company"));
				u.setDob(rest.getDate("dob"));
				u.setContactNumber(rest.getString("contactNumber"));
				u.setEmail(rest.getString("email"));
				u.setPassword(rest.getString("password"));
				u.setId(rest.getInt("id"));
			}
			return u;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
	}

	public static boolean UpdateuserloyeeByIdHelper(String fname, String lname,
			Date dob, String contactNumber, int id) {
		String query = userQuery.updateDetails();

		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {
			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setDate(3, dob);
			statement.setString(4, contactNumber);
			statement.setInt(5, id);
			statement.executeUpdate();
			return true;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return false;
		}
	}

	public static List<com.model.User> showAllUserHelper(String company, int id) {
		List<User> userList = new ArrayList<User>();

		String addQuery = userQuery.showAlluser();
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(addQuery);) {
			statement.setString(1, company);
			statement.setInt(2, id);
			ResultSet rset = statement.executeQuery();
			while (rset.next()) {
				User user = new User();
				user.setFirstName(rset.getString("firstName"));
				user.setLastName(rset.getString("lastName"));
				user.setEmail(rset.getString("email"));
				user.setId(rset.getInt("id"));
				user.setCompany(rset.getString("company"));
				user.setContactNumber(rset.getString("contactNumber"));
				userList.add(user);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return userList;
	}

	public static User uploadPic(int userId, String item) {
		// TODO Auto-generated method stub
		String query = userQuery.insertProfilePic();

		try {
			Connection connection = DBInfo.getConn();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, userId);
			Blob blob = (Blob) connection.createBlob();
			blob.setBytes(1, item.getBytes());
			statement.setBlob(2, blob);
			ResultSet rest = statement.executeQuery();
			User u = new User();
			while (rest.next()) {
				u.setImage(rest.getBlob("image"));
			}
			return u;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
	}
}
