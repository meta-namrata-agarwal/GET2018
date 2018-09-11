package com.metaportal.dao;

public class SkillsQuery {

	final static String getAllSkills="Select * from skills";

	final static String insertSkill = "INSERT INTO skills(skillName)VALUES(?)";


	final static String getSkillById = "SELECT * FROM skills WHERE skillId= ? ";

	final static String updateSkill = "update skills set skillName= ?  where skillId = ? ";

	final static String deleteById = " update skills set isActive = false  where skillId = ? ";

}
