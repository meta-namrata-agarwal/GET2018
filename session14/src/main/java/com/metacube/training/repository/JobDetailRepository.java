package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.model.JobDetails;

public interface JobDetailRepository extends JpaRepository<JobDetails, Integer>{

	public JobDetails findByEmpCode(int empCode);

//	@Modifying
//	@Query("update Jobdetails set isActive=false where empCode= ?1")
//	public int deleteJobDetails(int empCode);
}

