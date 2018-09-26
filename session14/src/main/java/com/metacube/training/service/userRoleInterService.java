package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.UserRole;

public interface userRoleInterService {

	List<UserRole> getEmployeeByEmailId(String emailId);

}
