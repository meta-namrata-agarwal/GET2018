package com.meta.training.EmployeePortal.dao;

import java.util.List;

import com.meta.training.EmployeePortal.modal.Skills;

public interface SkillDAO {

	Skills getSkillsById(int id);

	List<Skills> getAllSkillss();

	boolean deleteSkills(int id);

	boolean updateSkills(Skills Skills);

	boolean createSkills(Skills Skills);

}
