package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skills;

public interface SkillInter {

	List<Skills> getAllSkills();

	Skills getSkillsById(int id);

	boolean createSkills(Skills skill);

	boolean updateSkills(Skills skill);

	boolean deleteSkills(int id);

	Skills getSkillByName(String input);
}
