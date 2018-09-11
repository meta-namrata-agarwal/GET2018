package com.meta.training.EmployeePortal.service;

import java.util.List;

import com.meta.training.EmployeePortal.modal.Employee;

public interface EmployeeInter {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean deleteEmployee(int id);

	boolean createEmployee(Employee emp);

	boolean updateEmployee(Employee emp);

}
