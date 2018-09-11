package com.meta.training.EmployeePortal.dao;

import java.util.List;

import com.meta.training.EmployeePortal.modal.Employee;

public interface EmployeeDAO {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();

	boolean deleteEmployee(int id);

	boolean updateEmployee(Employee project);

	boolean createEmployee(Employee project);

}
