package com.meta.training.EmployeePortal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.meta.training.EmployeePortal.modal.JobDetails;



public class JobDetailsMapper implements RowMapper<JobDetails> {


	public JobDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		JobDetails jd=new JobDetails();
		jd.setEmpCode(rs.getInt("empCode"));
		jd.setCurrProjId(rs.getInt("currProjId"));
		jd.setDateOfJoining(rs.getDate("dateOfJoining"));
		jd.setJobCode(rs.getInt("jobCode"));
		jd.setJobDetailId(rs.getInt("jobDetailId"));
		jd.setReportingManager(rs.getInt("reportingManager"));
		jd.setTeamLead(rs.getInt("teamLead"));
		jd.setTotalExp(rs.getInt("totalExp"));
		return jd;
		
	}

}
