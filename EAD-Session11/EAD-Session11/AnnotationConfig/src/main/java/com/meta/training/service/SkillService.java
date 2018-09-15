package com.meta.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meta.training.dao.SkillDAO;
import com.meta.training.model.Skills;

@Service
public class SkillService implements SkillInter{

	@Autowired
	private SkillDAO skillDAO;
	@Override
	public List<Skills> getAllSkills() {
		return skillDAO.getAllSkillss();
	}

	@Override
	public Skills getSkillsById(int id) {
		return skillDAO.getSkillsById(id);
	}

	@Override
	public boolean  createSkills(Skills skill) {
		// TODO Auto-generated method stub
	
		return skillDAO.createSkills(skill);
	}

	@Override
	public boolean updateSkills(Skills skill) {
		return skillDAO.updateSkills(skill);
		
	}

	@Override
	public boolean deleteSkills(int id) {
	return skillDAO.deleteSkills(id);
		
	}

}
