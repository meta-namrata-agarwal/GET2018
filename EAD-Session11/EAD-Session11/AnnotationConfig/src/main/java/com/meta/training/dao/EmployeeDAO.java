package com.meta.training.dao;

import java.util.List;

import com.meta.training.model.Employee;
import com.meta.training.model.JobDetails;

public interface EmployeeDAO {

	Employee getEmployeeById(int id);
	
	Employee getEmployeeByMail(String email);

	List<Employee> getAllEmployees();

	boolean deleteEmployee(int id);

	boolean updateEmployee(Employee project);

	boolean createEmployee(Employee project);

	List<Employee> empByName(String firstName);

	Employee loginParameter(String email, String password);


	List<Employee> getEmpByName(String name);


}
