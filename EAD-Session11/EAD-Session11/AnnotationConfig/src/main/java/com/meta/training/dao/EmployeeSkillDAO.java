package com.meta.training.dao;

import java.util.List;

import com.meta.training.model.EmployeeSkills;


public interface EmployeeSkillDAO {

	List<EmployeeSkills> getEmployeeSkilllsByEmpId(int empCode);

	List<EmployeeSkills> getmployeeSkilllsBySkillId(int skillId);

	List<EmployeeSkills> getAllemployeeSkillls();

	boolean deletemployeeSkilllsBySkill(int empCde,int skillId);
	
	boolean deleteAllEmployeeSkilllsByEmpId(int empCode);

	boolean updatemployeeSkillls(int empSkillId);

	boolean createmployeeSkillls(EmployeeSkills jd);
}
