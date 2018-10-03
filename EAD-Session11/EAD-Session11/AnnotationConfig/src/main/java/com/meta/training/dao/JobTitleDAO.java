package com.meta.training.dao;

import java.util.List;

import com.meta.training.model.JobTitleMaster;

public interface JobTitleDAO {

	JobTitleMaster getJobTitleMasterById(int id);

	List<JobTitleMaster> getAllJobTitleMasters();

	boolean deleteJobTitleMaster(int id);

	boolean updateJobTitleMaster(JobTitleMaster JobTitleMaster);

	boolean createJobTitleMaster(JobTitleMaster JobTitleMaster);

}
