package com.metacube.training.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobdetails")
public class JobDetails {

	@Id
	@Column(name = "jobDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobDetailId;
	
	@Column(name="empCode")
	private int empCode;
	
	@Column(name="dateOfJoining")
	private Date dateOfJoining;
	
	@Column(name="totalExp")
	private int totalExp;
	
	@Column(name="jobCode")
	private int jobCode;
	
	@Column(name="reportingManagerId")
	private int reportingManagerId;
	
	@Column(name="teamLeadId")
	private int teamLeadId;
	
	@Column(name="currProjId")
	private int currProjId;

	/**
	 * @return the empCode
	 */
	public int getEmpCode() {
		return empCode;
	}

	/**
	 * @param empCode
	 *            the empCode to set
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
	 * @param jobDetailId
	 *            the jobDetailId to set
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
	 * @param dateOfJoining
	 *            the dateOfJoining to set
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
	 * @param totalExp
	 *            the totalExp to set
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
	 * @param jobCode
	 *            the jobCode to set
	 */
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}

	/**
	 * @return the reportingManager
	 */
	public int getReportingManagerId() {
		return reportingManagerId;
	}

	/**
	 * @param reportingManager
	 *            the reportingManager to set
	 */
	public void setReportingManagerId(int reportingManagerId) {
		this.reportingManagerId = reportingManagerId;
	}



	/**
	 * @return the currProjId
	 */
	public int getCurrProjId() {
		return currProjId;
	}

	/**
	 * @param currProjId
	 *            the currProjId to set
	 */
	public void setCurrProjId(int currProjId) {
		this.currProjId = currProjId;
	}

	@Override
	public String toString() {
		return "JobDetails [jobDetailId=" + jobDetailId + ", empCode="
				+ empCode + ", dateOfJoining=" + dateOfJoining + ", totalExp="
				+ totalExp + ", jobCode=" + jobCode + ", reportingManagerId="
				+ reportingManagerId + ", teamLeadId=" + teamLeadId
				+ ", currProjId=" + currProjId + "]";
	}

	public int getTeamLeadId() {
		return teamLeadId;
	}

	public void setTeamLeadId(int teamLeadId) {
		this.teamLeadId = teamLeadId;
	}

	
}
