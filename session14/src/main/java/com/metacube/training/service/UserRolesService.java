package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.UserRole;
import com.metacube.training.repository.UserRoleRepoInter;

@Service
public class UserRolesService implements userRoleInterService {

	@Autowired
	UserRoleRepoInter userRoleRepo;
	@Override
	public List<UserRole> getEmployeeByEmailId(String mail) {
		return userRoleRepo.findByEmailId(mail);
	}

	
	
}
