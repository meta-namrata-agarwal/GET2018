package com.meta.training.EmployeePortal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.meta.training.EmployeePortal.modal.Skills;

public class SkillsMapper implements RowMapper<Skills> {

	
	public Skills mapRow(ResultSet rs, int rowNum) throws SQLException {
	Skills skill=new Skills();
	skill.setSkillName(rs.getString("skillName"));
	skill.setSkillId(rs.getInt("skillId"));
	skill.setActive(rs.getBoolean("isActive"));
	
		return skill;
	}

}
