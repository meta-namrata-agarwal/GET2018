package com.metaportal.modal;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Project {

	private int projectId;
	private String name;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String endDate;
	private String logo;
	private boolean isActive;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getId() {
		return projectId;
	}

	public void setId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name
				+ ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", logo=" + logo + "]";
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	

}
