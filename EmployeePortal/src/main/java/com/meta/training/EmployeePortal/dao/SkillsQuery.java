package com.meta.training.EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.meta.training.EmployeePortal.mappers.SkillsMapper;
import com.meta.training.EmployeePortal.modal.Skills;

@Repository
public class SkillsQuery implements SkillDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SkillsQuery(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	final static String getAllSkills="Select * from skills";

	final static String insertSkill = "INSERT INTO skills(skillName)VALUES(?)";


	final static String getSkillById = "SELECT * FROM skills WHERE skillId= ? ";

	final static String updateSkill = "update skills set skillName= ?  where skillId = ? ";

	final static String deleteById = " update skills set isActive = false  where skillId = ? ";

	@Override
	public Skills getSkillsById(int id) {
		return jdbcTemplate.queryForObject(getSkillById,new Object[] { id }, new SkillsMapper());
	}

	@Override
	public List<Skills> getAllSkillss() {
		return jdbcTemplate.query(getAllSkills, new SkillsMapper());
	}

	@Override
	public boolean deleteSkills(int id) {
		return jdbcTemplate.update(deleteById, id) > 0;
	}

	@Override
	public boolean updateSkills(Skills Skills) {
		return jdbcTemplate.update(updateSkill, Skills.getSkillName(), Skills.getSkillId()) > 0;
	}

	@Override
	public boolean createSkills(Skills Skills) {
		return jdbcTemplate.update(insertSkill, Skills.getSkillName()) > 0;
	}
}
