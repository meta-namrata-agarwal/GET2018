package com.meta.training.service;

import java.util.List;

import com.meta.training.model.Skills;

public interface SkillInter {

	List<Skills> getAllSkills();

	Skills getSkillsById(int id);

	boolean createSkills(Skills skill);

	boolean updateSkills(Skills skill);

	boolean deleteSkills(int id);
}
