package com.meta.training.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "empCode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empCode;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "primaryContact")
	private String primaryContact;
	
	@Column(name = "secondaryContact")
	private String secondaryContact;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "skypeId")
	private String skypeId;
	
	@Column(name = "profilePicture")
	private String profilePicture;
	
	@Column(name="password",nullable=false)
	private String password="1234";
	
	@Column(name="isActive",nullable=false)
	private boolean isActive=true;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the primaryContact
	 */
	public String getPrimaryContact() {
		return primaryContact;
	}

	/**
	 * @param primaryContact
	 *            the primaryContact to set
	 */
	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	/**
	 * @return the secondaryContact
	 */
	public String getSecondaryContact() {
		return secondaryContact;
	}

	/**
	 * @param secondaryContact
	 *            the secondaryContact to set
	 */
	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the skypeId
	 */
	public String getSkypeId() {
		return skypeId;
	}

	/**
	 * @param skypeId
	 *            the skypeId to set
	 */
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	/**
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * @param profilePicture
	 *            the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isActive
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", gender="
				+ gender + ", primaryContact=" + primaryContact
				+ ", secondaryContact=" + secondaryContact + ", emailId="
				+ emailId + ", skypeId=" + skypeId + ", profilePicture="
				+ profilePicture + ", password=" + password + ", isActive="
				+ isActive + "]";
	}

}