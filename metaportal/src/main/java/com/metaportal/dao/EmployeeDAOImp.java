package com.metaportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metaportal.modal.Employee;
import com.metaportal.modal.Employee;

public class EmployeeDAOImp {

	public static int insertEmployeeHelper(Employee emp) {
		String query = EmployeeQuery.insertEmployee;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {

			statement.setString(1, emp.getFirstName());
			statement.setString(2, emp.getLastName());
			statement.setDate(3, emp.getDob());
			statement.setString(4, emp.getGender());
			statement.setString(5, emp.getPriamryContact());
			statement.setString(6, emp.getEmailId());
			statement.setString(7, emp.getPassword());
			statement.executeUpdate();
			return 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return 0;
		}
	}

	public static List<Employee> getAllEmployeeHelper() {
		List<Employee> list = new ArrayList<Employee>();
		String query = EmployeeQuery.getAllEmployee;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {
			ResultSet rest = statement.executeQuery();

			while (rest.next()) {
				Employee emp = new Employee();
				emp.setEmpCode(rest.getInt("empCode"));
				emp.setFirstName(rest.getString("firstName"));
				emp.setLastName(rest.getString("lastName"));
				emp.setDob(rest.getDate("dob"));
				emp.setGender(rest.getString("gender"));
				emp.setPriamryContact(rest.getString("primaryContact"));
				emp.setEmailId(rest.getString("emailId"));
				emp.setPassword(rest.getString("password"));
				emp.setActive(rest.getBoolean("isActive"));
				list.add(emp);
			}
			return list;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
	}

	public static Employee getAllEmployeeHelperById(int id) {
		String query = EmployeeQuery.getAllEmployeeById;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {
			statement.setInt(1, id);
			ResultSet rest = statement.executeQuery();
			Employee emp = new Employee();
			while (rest.next()) {
				emp.setEmpCode(rest.getInt("empCode"));
				emp.setFirstName(rest.getString("firstName"));
				emp.setLastName(rest.getString("lastName"));
				emp.setDob(rest.getDate("dob"));
				emp.setGender(rest.getString("gender"));
				emp.setPriamryContact(rest.getString("primaryContact"));
				emp.setEmailId(rest.getString("emailId"));
				emp.setPassword(rest.getString("password"));
				emp.setActive(rest.getBoolean("isActive"));
			}
			return emp;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
	}

	public static int deleteEmployeeHelperById(int id) {
		String query = EmployeeQuery.deleteById;
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

	public static int updateEmployeeByIdHelper(Employee emp) {
		String query = EmployeeQuery.updateEmployee;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {

			statement.setString(1, emp.getFirstName());
			statement.setString(2, emp.getLastName());
			statement.setDate(3, emp.getDob());
			statement.setString(4, emp.getGender());
			// statement.setString(5, emp.getPriamryContact());
			statement.setString(5, emp.getEmailId());
			statement.setString(6, emp.getPassword());
			statement.setInt(7, emp.getEmpCode());
			statement.executeUpdate();
			return 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return 0;
		}
	}
}
