package com.meta.training.dao;

import java.util.List;

import com.meta.training.model.JobDetails;

public interface JobDetailsDAO {

	JobDetails getJobDetailByJobId(int jid);
	
	JobDetails getJobDetailByEmployeeId(int eId);

	List<JobDetails> getAllJobDetails();

	boolean deleteJobDetails(int empCde);

	boolean updateJobDetails(JobDetails jd);

	boolean createJobDetails(JobDetails jd);
}
