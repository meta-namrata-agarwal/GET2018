package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.JobTitleMaster;
import com.metacube.training.repository.TitleMasterRepository;

@Service
public class JobTitleService implements JobTitleInter {

	@Autowired
	private TitleMasterRepository titleMasterRepo;
	@Override
	public List<JobTitleMaster> getAllJobTitle() {
		return titleMasterRepo.findAll();
	}

	@Override
	public JobTitleMaster getJobtitleById(int id) {
		
		return titleMasterRepo.findOne(id);
	}

	@Override
	public boolean createJobTitle(JobTitleMaster title) {
		try{
			titleMasterRepo.save(title);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean updateJobtitle(JobTitleMaster job) {
		try{
			titleMasterRepo.save(job);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
		
	}

	@Override
	public boolean deletejobtitle(int id) {
		try{
			titleMasterRepo.deleteJobTitle(id);
		}
		catch(Exception e){
			return false;
		}
		return true;
		
	}
	
	@Override
	public JobTitleMaster findBytitle(String input){
		return titleMasterRepo.findByJobTitle(input);
	}

	
}
