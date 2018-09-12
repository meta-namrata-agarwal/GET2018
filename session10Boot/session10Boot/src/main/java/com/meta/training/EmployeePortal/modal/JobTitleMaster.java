package com.meta.training.EmployeePortal.modal;

public class JobTitleMaster {

	 private int jobCode;
	 private String jobTitle;
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
