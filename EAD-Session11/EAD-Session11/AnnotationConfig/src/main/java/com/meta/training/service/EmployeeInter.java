package com.meta.training.service;

import java.util.List;

import com.meta.training.model.Employee;
import com.meta.training.model.JobDetails;

public interface EmployeeInter {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean deleteEmployee(int id);

	boolean createEmployee(Employee emp);

	boolean updateEmployee(Employee emp);

	List<Employee> EmpByName(String name);

	Employee loginParam(String email, String password);


	Employee getEmployeeByMail(String mail);

	List<Employee> getEmployeeByName(String name);


}
