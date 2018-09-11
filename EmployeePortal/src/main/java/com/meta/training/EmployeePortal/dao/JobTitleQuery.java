package com.meta.training.EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.meta.training.EmployeePortal.mappers.JobTitleMasterMapper;
import com.meta.training.EmployeePortal.modal.JobTitleMaster;
import com.meta.training.EmployeePortal.modal.JobTitleMaster;

@Repository
public class JobTitleQuery implements JobTitleDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JobTitleQuery(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	final static String getAllJobs = "Select * from jobtitlemaster";

	final static String insertJob = "INSERT INTO jobtitlemaster(jobTitle)VALUES(?)";

	final static String getJobById = "SELECT * FROM jobtitlemaster WHERE jobCode= ? ";

	final static String updateJob = "update jobtitlemaster set jobTitle= ?  where jobCode = ? ";

	final static String deleteById = " update jobtitlemaster set isActive = false  where jobCode = ? ";

	@Override
	public JobTitleMaster getJobTitleMasterById(int id) {
		return jdbcTemplate.queryForObject(getJobById, new Object[] { id },
				new JobTitleMasterMapper());
	}

	@Override
	public List<JobTitleMaster> getAllJobTitleMasters() {
		return jdbcTemplate.query(getAllJobs, new JobTitleMasterMapper());
	}

	@Override
	public boolean deleteJobTitleMaster(int id) {
		return jdbcTemplate.update(deleteById, id) > 0;
	}

	@Override
	public boolean updateJobTitleMaster(JobTitleMaster JobTitleMaster) {
		return jdbcTemplate.update(updateJob, JobTitleMaster.getJobTitle(),
				JobTitleMaster.getJobCode()) > 0;
	}

	@Override
	public boolean createJobTitleMaster(JobTitleMaster JobTitleMaster) {
		return jdbcTemplate.update(insertJob, JobTitleMaster.getJobTitle()) > 0;
	}
}
