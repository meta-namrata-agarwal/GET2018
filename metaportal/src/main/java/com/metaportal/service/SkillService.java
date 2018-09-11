package com.metaportal.service;

import java.util.List;

import com.metaportal.dao.SkillsDAOImp;
import com.metaportal.modal.Skills;

public class SkillService {

	public static List<Skills> getAllSkills() {
		return SkillsDAOImp.getAllSkillHelper();
	}
	

	public static Skills getSkillsById(int id) {
		// TODO Auto-generated method stub
		return SkillsDAOImp.getSkillsByIdHelper(id);
	}

	public static void createSkills(Skills skill) {
		int value=SkillsDAOImp.insertSkillsHelper(skill);
		
		
	}

	public static void updateSkills(Skills skill) {
		int value=SkillsDAOImp.updateSkillsHelper(skill);
		
	}

	public static void deleteSkills(int id) {
		// TODO Auto-generated method stub
		int value=SkillsDAOImp.deleteSkillsHelper(id);
		
	}

}
