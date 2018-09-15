package com.meta.training.service;

import java.util.List;

import com.meta.training.model.JobDetails;


public interface JobDetailServicerInter {

	JobDetails getJobDetailByjobId(int id);
	
	JobDetails getJobDetailByEmpId(int id);

	List<JobDetails> getAllJobDetail();

	boolean deleteJobDetail(int Eid);

	boolean updateJobDetail(JobDetails jobDetail);

	boolean createJobDetail(JobDetails jobDetail);
}
