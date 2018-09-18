package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.model.JobTitleMaster;

public interface TitleMasterRepository extends
		JpaRepository<JobTitleMaster, Integer> {

	@Modifying
	@Query("update JobTitleMaster set isActive=false where jobCode= ?1")
	public boolean deleteJobTitle(int id);

	public JobTitleMaster findByJobTitle(String jobTitle);
}
