package com.metaportal.modal;

import java.util.Date;

public class JobDetails {

	private int empCode;
	private int jobDetailId;
	private Date dateOfJoining;
	private int totalExp;
	private int jobCode;
	private int reportingManager;
	private int teamLead;
	private int currProjId;
	/**
	 * @return the empCode
	 */
	public int getEmpCode() {
		return empCode;
	}
	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}
	/**
	 * @return the jobDetailId
	 */
	public int getJobDetailId() {
		return jobDetailId;
	}
	/**
	 * @param jobDetailId the jobDetailId to set
	 */
	public void setJobDetailId(int jobDetailId) {
		this.jobDetailId = jobDetailId;
	}
	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	/**
	 * @return the totalExp
	 */
	public int getTotalExp() {
		return totalExp;
	}
	/**
	 * @param totalExp the totalExp to set
	 */
	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
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
	 * @return the reportingManager
	 */
	public int getReportingManager() {
		return reportingManager;
	}
	/**
	 * @param reportingManager the reportingManager to set
	 */
	public void setReportingManager(int reportingManager) {
		this.reportingManager = reportingManager;
	}
	/**
	 * @return the teamLead
	 */
	public int getTeamLead() {
		return teamLead;
	}
	/**
	 * @param teamLead the teamLead to set
	 */
	public void setTeamLead(int teamLead) {
		this.teamLead = teamLead;
	}
	/**
	 * @return the currProjId
	 */
	public int getCurrProjId() {
		return currProjId;
	}
	/**
	 * @param currProjId the currProjId to set
	 */
	public void setCurrProjId(int currProjId) {
		this.currProjId = currProjId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JobDetails [empCode=" + empCode + ", jobDetailId="
				+ jobDetailId + ", dateOfJoining=" + dateOfJoining
				+ ", totalExp=" + totalExp + ", jobCode=" + jobCode
				+ ", reportingManager=" + reportingManager + ", teamLead="
				+ teamLead + ", currProjId=" + currProjId + "]";
	}
	
	
}
