package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.UserRole;

@Repository
public interface UserRoleRepoInter extends JpaRepository<UserRole, Integer>{

	
	public List<UserRole> findByEmailId(String email);
}
