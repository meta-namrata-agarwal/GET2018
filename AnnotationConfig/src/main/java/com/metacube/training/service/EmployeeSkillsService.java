package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.repository.EmployeeSkillsRepository;
@Service
public class EmployeeSkillsService implements EmployeeSkillInter {

@Autowired
private EmployeeSkillsRepository employeeSkillRepo;

	@Override
	public List<EmployeeSkills> getAllEmpSkills() {
		return employeeSkillRepo.findAll();
	}

	@Override
	public List<EmployeeSkills> getSkillsByEmpId(int empCode) {
		return employeeSkillRepo.findByEmpCode(empCode);
	}

	@Override
	public List<EmployeeSkills> getSkillsBySkillId(int skillCode) {
		return employeeSkillRepo.findBySkillCode(skillCode);
	}

	@Override
	public boolean createEmpSkills(EmployeeSkills skill) {
		try {
			employeeSkillRepo.save(skill);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean updateEmpSkills(EmployeeSkills skill) {
		try {
			employeeSkillRepo.save(skill);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean deleteEmpSkills(int empCde, int skillId) {
		return false;
	}

	@Override
	public boolean deleteAllEmpbySkillId(int skillId) {
		return false;
	}

	@Override
	public boolean deleteallSkillbyEmpID(int empCode) {
		return false;
	}


}
