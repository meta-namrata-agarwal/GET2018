package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.util.DBInfo;

public class DataBaseHelper {

	public static boolean addEmployeeHelper(String fname, String lname, String email, int age) {

		String addQuery = dataBaseEmployee.addEmployee();
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection.prepareStatement(addQuery);) {

			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setString(3, email);
			statement.setInt(4, age);
			statement.executeUpdate();
			return true;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return false;
		}

	}

	public static List<Employee> searchEmployeeHelper(String fname, String lname) {
		List<Employee> empList = new ArrayList<Employee>();

		String addQuery = dataBaseEmployee.searchEmployee();
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection.prepareStatement(addQuery);) {

			statement.setString(1, fname);
			statement.setString(2, lname);
			ResultSet rset = statement.executeQuery();
			while (rset.next()) {
				Employee emp = new Employee();
				emp.setFirstName(rset.getString("firstName"));
				emp.setLastName(rset.getString("lastName"));
				emp.setEmailId(rset.getString("email"));
				emp.setAge(rset.getInt("age"));
				empList.add(emp);

			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return empList;

	}

	public static List<com.model.Employee> showEmployeeHelper() {
		List<Employee> empList = new ArrayList<Employee>();

		String addQuery = dataBaseEmployee.showEmployee();
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection.prepareStatement(addQuery);) {

			ResultSet rset = statement.executeQuery();
			while (rset.next()) {
				Employee emp = new Employee();
				emp.setFirstName(rset.getString("firstName"));
				emp.setLastName(rset.getString("lastName"));
				emp.setEmailId(rset.getString("email"));
				emp.setAge(rset.getInt("age"));
				emp.setId(rset.getInt("id"));
				empList.add(emp);

			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return empList;

	}

	public static Employee getEmployeeByIdHelper(int id) {

		Employee emp = new Employee();
		String query = dataBaseEmployee.getEmployeeById();
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setInt(1, id);
			ResultSet rset = statement.executeQuery();
			while (rset.next()) {

				emp.setFirstName(rset.getString("firstName"));
				emp.setLastName(rset.getString("lastName"));
				emp.setEmailId(rset.getString("email"));
				emp.setAge(rset.getInt("age"));
				emp.setId(rset.getInt("id"));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();

		}
		return emp;
	}

	public static boolean UpdateEmployeeByIdHelper(String fname, String lname, String email, int age, int id) {
		String query = dataBaseEmployee.updateDetails();

		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setString(3, email);
			statement.setInt(4, age);
			statement.setInt(5, id);
			statement.executeUpdate();
			return true;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return false;
		}
	}
}
