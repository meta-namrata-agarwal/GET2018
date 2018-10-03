package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.UserRole;
@Service
public class CustomUserRoleService implements UserDetailsService {


	@Autowired
	EmployeeInter employeeService;

	@Autowired
	userRoleInterService  userRolesService;

	@Override
	public UserDetails loadUserByUsername(String emailId)
	throws UsernameNotFoundException {
	Employee user=employeeService.getEmployeeByEmailId(emailId);
	if(user==null){
	           throw new UsernameNotFoundException("Username not found"); 
	       }
	           return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), 
	                user.getIsActive(), true, true, true, getGrantedAuthorities(emailId));
	}

	private List<GrantedAuthority> getGrantedAuthorities(String emailId){
	       List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	       List<UserRole> listOfUserRoles=userRolesService.getEmployeeByEmailId(emailId);
	       for(UserRole userRoles : listOfUserRoles){
	    	   System.out.println(userRoles.getRole());
	           authorities.add(new SimpleGrantedAuthority("ROLE_"+userRoles.getRole()));
	       }
	       return authorities;
	   }

	}

