package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeskills")
public class EmployeeSkills {

	@Id
	@Column(name = "skillId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;

	@Column(name = "empCode")
	private int empCode;

	@Column(name = "skillCode")
	private int skillCode;

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
	 * @return the skillCode
	 */
	public int getSkillCode() {
		return skillCode;
	}

	/**
	 * @param skillCode
	 *            the skillCode to set
	 */
	public void setSkillCode(int skillCode) {
		this.skillCode = skillCode;
	}

	/**
	 * @return the skillId
	 */
	public int getSkillId() {
		return skillId;
	}

	/**
	 * @param skillId
	 *            the skillId to set
	 */
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeSkillls [empCode=" + empCode + ", skillCode="
				+ skillCode + ", skillId=" + skillId + "]";
	}

}
