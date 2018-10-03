package com.meta.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skills")
public class Skills {
	
	@Column(name="skillName")
	private String skillName;
	
	@Id
	@Column(name = "skillId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	
	@Column(name="isActive",nullable=false)
	private boolean isActive=true;
	
	/**
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
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
