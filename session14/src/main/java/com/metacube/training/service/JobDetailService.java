package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.JobDetails;
import com.metacube.training.repository.JobDetailRepository;
@Service
public class JobDetailService implements JobDetailServicerInter{

	@Autowired
	private JobDetailRepository jobDetailRepo;
	
	@Override
	public JobDetails getJobDetailByjobId(int id) {
		return jobDetailRepo.findOne(id);
	}

	@Override
	public JobDetails getJobDetailByEmpId(int id) {
		return jobDetailRepo.findByEmpCode(id);
	}

	@Override
	public List<JobDetails> getAllJobDetail() {
		return jobDetailRepo.findAll();
	}

	
	@Override
	@Transactional
	public boolean deleteJobDetail(int Eid) {
//		try{
//			jobDetailRepo.deleteJobDetails(Eid);
//		}
//		catch(Exception e){
//			return false;
//		}
		return true;
	}

	@Override
	public boolean updateJobDetail(JobDetails jobDetail) {
		try{
			jobDetailRepo.save(jobDetail);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean createJobDetail(JobDetails jobDetail) {
		try{
			jobDetailRepo.save(jobDetail);
		}
		catch(Exception e){
			return false;
		}
		return true;	}

}
