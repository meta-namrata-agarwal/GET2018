package com.meta.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meta.training.dao.EmployeeSkillDAO;
import com.meta.training.model.EmployeeSkills;
@Service
public class EmployeeSkillsService implements EmployeeSkillInter {

	@Autowired
	private EmployeeSkillDAO empSkillDAO;

	@Override
	public List<EmployeeSkills> getAllEmpSkills() {
		return empSkillDAO.getAllemployeeSkillls();
	}

	@Override
	public List<EmployeeSkills> getSkillsByEmpId(int empCode) {
		return empSkillDAO.getEmployeeSkilllsByEmpId(empCode);
	}

	@Override
	public List<EmployeeSkills> getSkillsBySkillId(int skillId) {
		return empSkillDAO.getmployeeSkilllsBySkillId(skillId);
	}

	@Override
	public boolean createEmpSkills(EmployeeSkills skill) {
		return empSkillDAO.createmployeeSkillls(skill);
	}

	@Override
	public boolean updateEmpSkills(EmployeeSkills skill) {
		return empSkillDAO.updatemployeeSkillls(skill.getEmpCode());
	}

	@Override
	public boolean deleteEmpSkills(int empCde, int skillId) {
		return empSkillDAO.deletemployeeSkilllsBySkill(empCde, skillId);
	}

	@Override
	public boolean deleteAllEmpbySkillId(int skillId) {
		return false;
	}

	@Override
	public boolean deleteallSkillbyEmpID(int empCode) {
		return empSkillDAO.deleteAllEmployeeSkilllsByEmpId(empCode);
	}

}
