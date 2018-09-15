package com.meta.training.dao;

import java.util.List;

import com.meta.training.model.Skills;

public interface SkillDAO {

	Skills getSkillsById(int id);

	List<Skills> getAllSkillss();

	boolean deleteSkills(int id);

	boolean updateSkills(Skills Skills);

	boolean createSkills(Skills Skills);

}
