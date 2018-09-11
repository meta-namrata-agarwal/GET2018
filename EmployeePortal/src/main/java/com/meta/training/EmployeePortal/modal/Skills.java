package com.meta.training.EmployeePortal.modal;

public class Skills {
	private String skillName;
	private int skillId;
	private boolean isActive;
	
	/**
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @param skillName the skillName to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
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
		return "Skills [skillName=" + skillName + ", skillId=" + skillId + "]";
	}
	
}
