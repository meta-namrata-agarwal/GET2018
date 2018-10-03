package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;


//import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;
import com.metacube.training.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeInter {
@Autowired
private EmployeeRepository empRepo;
	@Override
	public Employee getEmployeeByEmailId(String mail) {
		return empRepo.findByEmailId(mail);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return empRepo.findOne(id) ;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll() ;
	}

	@Override
	@Transactional
	public boolean deleteEmployee(int id) {
		try{
		empRepo.deleteEmployee(id);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean createEmployee(Employee emp) {
		try {
			empRepo.save(emp);
		} catch (Exception e) {
			return false;
		}

		return true;
	}


	@Override
	public boolean updateEmployee(Employee emp) {
		try {
			empRepo.save(emp);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public Employee loginParam(String email, String password) {
		return empRepo.findByEmailIdAndPassword(email, password);

	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return empRepo.search("%"+name+"%");
	}

}
