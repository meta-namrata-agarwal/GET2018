package com.metaportal.modal;

public class EmployeeSkillls {

	private String empCode;
	private String skillCode;
	private int skillId;
	
	
	/**
	 * @return the empCode
	 */
	public String getEmpCode() {
		return empCode;
	}


	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}


	/**
	 * @return the skillCode
	 */
	public String getSkillCode() {
		return skillCode;
	}


	/**
	 * @param skillCode the skillCode to set
	 */
	public void setSkillCode(String skillCode) {
		this.skillCode = skillCode;
	}


	/**
	 * @return the skillId
	 */
	public int getSkillId() {
		return skillId;
	}


	/**
	 * @param skillId the skillId to set
	 */
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeSkillls [empCode=" + empCode + ", skillCode="
				+ skillCode + ", skillId=" + skillId + "]";
	}
	
	
	
}
