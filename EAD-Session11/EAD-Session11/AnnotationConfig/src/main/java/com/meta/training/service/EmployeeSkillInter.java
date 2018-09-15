package com.meta.training.service;

import java.util.List;

import com.meta.training.model.EmployeeSkills;

public interface EmployeeSkillInter {

	List<EmployeeSkills> getAllEmpSkills();

	List<EmployeeSkills> getSkillsByEmpId(int Eid);
	
	List<EmployeeSkills> getSkillsBySkillId(int Sid);

	boolean createEmpSkills(EmployeeSkills skill);

	boolean updateEmpSkills(EmployeeSkills skill);

	boolean deleteEmpSkills(int Eid,int skillId);
	
	boolean deleteAllEmpbySkillId(int skillId);
	
	 boolean deleteallSkillbyEmpID(int empCode);
}
