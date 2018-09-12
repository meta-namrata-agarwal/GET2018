package com.meta.training.EmployeePortal.service;

import java.util.List;

import com.meta.training.EmployeePortal.modal.Employee;
import com.meta.training.EmployeePortal.modal.JobDetails;

public interface EmployeeInter {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean deleteEmployee(int id);

	boolean createEmployee(Employee emp);

	boolean updateEmployee(Employee emp);

	List<Employee> EmpByName(String name);

	Employee loginParam(String email, String password);

	boolean editEmpProfile(Employee emp);

	JobDetails jobDetailsbyId(int id);

}
