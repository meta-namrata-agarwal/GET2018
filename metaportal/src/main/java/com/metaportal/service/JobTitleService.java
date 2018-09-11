package com.metaportal.service;

import java.util.List;

import com.metaportal.dao.JobTitleDAOImp;
import com.metaportal.dao.SkillsDAOImp;
import com.metaportal.modal.JobTitleMaster;
import com.metaportal.modal.Skills;

public class JobTitleService {

	public static List<JobTitleMaster> getAllJobTitle() {
		return JobTitleDAOImp.getAllJobHelper();
	}
	

	public static JobTitleMaster getJobtitleById(int id) {
		// TODO Auto-generated method stub
		return JobTitleDAOImp.getJobsByIdHelper(id);
	}

	public static void createJobTitle(JobTitleMaster title) {
		int value=JobTitleDAOImp.insertJobsHelper(title);
		
		
	}

	public static void updateJobtitle(JobTitleMaster job) {
		int value=JobTitleDAOImp.updateJobsHelper(job);
		
	}

	public static void deletejobtitle(int id) {
		// TODO Auto-generated method stub
		int value=JobTitleDAOImp.deleteJobsHelper(id);
		
	}
}
