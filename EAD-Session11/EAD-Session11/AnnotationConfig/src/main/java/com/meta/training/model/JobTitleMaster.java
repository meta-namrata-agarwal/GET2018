package com.meta.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobtitlemaster")
public class JobTitleMaster {

	@Id
	@Column(name = "jobCode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int jobCode;
	
	@Column(name="jobTitle")
	 private String jobTitle;
	
	@Column(name="isActive",nullable=false)
	private boolean isActive=true;
	
	
	/**
	 * @return the isActive
	 */
	public boolean getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the jobCode
	 */
	public int getJobCode() {
		return jobCode;
	}
	/**
	 * @param jobCode the jobCode to set
	 */
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}
	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JobTitleMaster [jobCode=" + jobCode + ", jobTitle=" + jobTitle
				+ "]";
	}
	 
}
