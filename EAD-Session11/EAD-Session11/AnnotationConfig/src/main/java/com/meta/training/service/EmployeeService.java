package com.meta.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meta.training.dao.EmployeeDAO;
import com.meta.training.model.Employee;
import com.meta.training.model.JobDetails;

@Service
public class EmployeeService implements EmployeeInter {

	@Autowired
	private EmployeeDAO empDao;

	@Override
	public Employee getEmployeeByMail(String mail) {
		return empDao.getEmployeeByMail(mail);
	};

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

	@Override
	public List<Employee> EmpByName(String name) {
		return empDao.empByName(name);
	}

	@Override
	public Employee loginParam(String email, String password) {
		return empDao.loginParameter(email, password);

	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return empDao.getEmpByName(name);

	}

}
