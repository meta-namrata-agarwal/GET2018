package com.meta.training.EmployeePortal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.meta.training.EmployeePortal.modal.JobTitleMaster;

public class JobTitleMasterMapper implements RowMapper<JobTitleMaster> {

	public JobTitleMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		JobTitleMaster jm = new JobTitleMaster();
		jm.setJobCode(rs.getInt("jobCode"));
		jm.setJobTitle(rs.getString("jobTitle"));
		return jm;
	}

}
