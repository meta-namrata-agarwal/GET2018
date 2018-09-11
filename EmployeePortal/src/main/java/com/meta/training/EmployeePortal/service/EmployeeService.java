package com.meta.training.EmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meta.training.EmployeePortal.dao.EmployeeDAO;
import com.meta.training.EmployeePortal.modal.Employee;

@Service
public class EmployeeService implements EmployeeInter {

	@Autowired
	private EmployeeDAO empDao;

	@Override
	public Employee getEmployeeById(int id) {
		return empDao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empDao.getAllEmployees();
	}

	@Override
	public boolean deleteEmployee(int id) {
		return empDao.deleteEmployee(id);
	}

	@Override
	public boolean createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.createEmployee(emp);
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.updateEmployee(emp);
	}

}
