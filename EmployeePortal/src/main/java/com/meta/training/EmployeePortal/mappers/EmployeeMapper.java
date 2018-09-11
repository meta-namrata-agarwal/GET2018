package com.meta.training.EmployeePortal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.meta.training.EmployeePortal.modal.Employee;


public class EmployeeMapper implements RowMapper<Employee>{

	
	public Employee mapRow(ResultSet rest, int arg1) throws SQLException {
		Employee emp=new Employee();
		emp.setEmpCode(rest.getInt("empCode"));
		emp.setFirstName(rest.getString("firstName"));
		emp.setLastName(rest.getString("lastName"));
		emp.setDob(rest.getDate("dob"));
		emp.setGender(rest.getString("gender"));
		emp.setPriamryContact(rest.getString("primaryContact"));
		emp.setEmailId(rest.getString("emailId"));
		emp.setPassword(rest.getString("password"));
		emp.setActive(rest.getBoolean("isActive"));
		return emp;
	}

	

}
