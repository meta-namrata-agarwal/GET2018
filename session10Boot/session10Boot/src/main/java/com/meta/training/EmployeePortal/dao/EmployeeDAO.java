package com.meta.training.EmployeePortal.dao;

import java.util.List;

import com.meta.training.EmployeePortal.modal.Employee;
import com.meta.training.EmployeePortal.modal.JobDetails;

public interface EmployeeDAO {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();

	boolean deleteEmployee(int id);

	boolean updateEmployee(Employee project);

	boolean createEmployee(Employee project);

	List<Employee> empByName(String firstName);

	Employee loginParameter(String email, String password);

	boolean editEmpProfile(Employee emp);

	JobDetails jobDetailsbyId(int id);

}
