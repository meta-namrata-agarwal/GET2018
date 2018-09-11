package com.meta.training.EmployeePortal.modal;

public class UserRoles {

	private String userNAme;
	private String role;
	private int userRoleId;
	/**
	 * @return the userNAme
	 */
	public String getUserNAme() {
		return userNAme;
	}
	/**
	 * @param userNAme the userNAme to set
	 */
	public void setUserNAme(String userNAme) {
		this.userNAme = userNAme;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the userRoleId
	 */
	public int getUserRoleId() {
		return userRoleId;
	}
	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRoles [userNAme=" + userNAme + ", role=" + role
				+ ", userRoleId=" + userRoleId + "]";
	}
	
}
