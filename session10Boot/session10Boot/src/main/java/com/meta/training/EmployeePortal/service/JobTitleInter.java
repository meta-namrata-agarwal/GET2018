package com.meta.training.EmployeePortal.service;

import java.util.List;

import com.meta.training.EmployeePortal.modal.JobTitleMaster;

public interface JobTitleInter {

	List<JobTitleMaster> getAllJobTitle();

	JobTitleMaster getJobtitleById(int id);

	boolean createJobTitle(JobTitleMaster title);

	boolean updateJobtitle(JobTitleMaster job);

	boolean deletejobtitle(int id);
}
