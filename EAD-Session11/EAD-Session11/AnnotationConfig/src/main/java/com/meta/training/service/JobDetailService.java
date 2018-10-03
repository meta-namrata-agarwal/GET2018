package com.meta.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meta.training.dao.JobDetailsDAO;
import com.meta.training.model.JobDetails;
@Service
public class JobDetailService implements JobDetailServicerInter{

	@Autowired
	private JobDetailsDAO jobDetailsDao;
	@Override
	public JobDetails getJobDetailByjobId(int id) {
		return jobDetailsDao.getJobDetailByJobId(id);
	}

	@Override
	public JobDetails getJobDetailByEmpId(int id) {
		return jobDetailsDao.getJobDetailByEmployeeId(id);
	}

	@Override
	public List<JobDetails> getAllJobDetail() {
		return jobDetailsDao.getAllJobDetails();
	}

	@Override
	public boolean deleteJobDetail(int Eid) {
		return jobDetailsDao.deleteJobDetails(Eid);
	}

	@Override
	public boolean updateJobDetail(JobDetails jobDetail) {
		return jobDetailsDao.updateJobDetails(jobDetail);
	}

	@Override
	public boolean createJobDetail(JobDetails jobDetail) {
		return jobDetailsDao.createJobDetails(jobDetail);	}

}
