package com.metaportal.service;

import java.util.List;

import com.metaportal.dao.EmployeeDAOImp;
import com.metaportal.modal.Employee;

public class EmployeeService {

	public static List<Employee> getAllEmployee() {
		System.out.println(EmployeeDAOImp.getAllEmployeeHelper().toString());
		return EmployeeDAOImp.getAllEmployeeHelper();
	}

	public static Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return EmployeeDAOImp.getAllEmployeeHelperById(id);
	}

	public static void deleteEmployee(int id) {
		int result=EmployeeDAOImp.deleteEmployeeHelperById(id);
		
	}

	public static void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		int result=EmployeeDAOImp.insertEmployeeHelper(emp);
	}

	public static void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		int result=EmployeeDAOImp.updateEmployeeByIdHelper(emp);
		
	}

}
