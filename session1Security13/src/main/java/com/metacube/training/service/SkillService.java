package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;
import com.metacube.training.model.Skills;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.repository.SkillsRepository;

@Service
public class SkillService implements SkillInter {

	@Autowired
	private SkillsRepository skillsRepository;

	@Override
	public List<Skills> getAllSkills() {
		return skillsRepository.findAll();
	}

	@Override
	public Skills getSkillsById(int id) {
		return skillsRepository.findOne(id);
	}

	@Override
	public boolean createSkills(Skills skill) {
		try {
			skillsRepository.save(skill);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean updateSkills(Skills skill) {
		try {
			skillsRepository.save(skill);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean deleteSkills(int id) {
		try{
			skillsRepository.deleteSkills(id);
		}
		catch(Exception e){
			return false;
		}
		return true;

	}

	@Override
	@Transactional
	public Skills getSkillByName(String input) {
			
	return skillsRepository.findBySkillName(input);}

}
