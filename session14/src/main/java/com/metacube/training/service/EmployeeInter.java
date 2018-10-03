package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeInter {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean deleteEmployee(int id);

	boolean createEmployee(Employee emp);

	boolean updateEmployee(Employee emp);

	Employee loginParam(String email, String password);

	Employee getEmployeeByEmailId(String EmailId);

	List<Employee> getEmployeeByName(String name);

}
