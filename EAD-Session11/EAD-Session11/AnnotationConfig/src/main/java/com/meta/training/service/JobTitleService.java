package com.meta.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meta.training.dao.JobTitleDAO;
import com.meta.training.model.JobTitleMaster;

@Service
public class JobTitleService implements JobTitleInter {
@Autowired
private JobTitleDAO jobTitleDAO;
	@Override
	public List<JobTitleMaster> getAllJobTitle() {
		return jobTitleDAO.getAllJobTitleMasters();
	}

	@Override
	public JobTitleMaster getJobtitleById(int id) {
		
		return jobTitleDAO.getJobTitleMasterById(id);
	}

	@Override
	public boolean createJobTitle(JobTitleMaster title) {
		return jobTitleDAO.createJobTitleMaster(title);
		
	}

	@Override
	public boolean updateJobtitle(JobTitleMaster job) {
	return jobTitleDAO.updateJobTitleMaster(job);
		
	}

	@Override
	public boolean deletejobtitle(int id) {
		return jobTitleDAO.deleteJobTitleMaster(id);
		
	}

	
}
