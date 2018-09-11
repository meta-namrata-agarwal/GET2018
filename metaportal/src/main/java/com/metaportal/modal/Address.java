package com.metaportal.modal;

public class Address {
	private int addressId;
	private String empCode;
	private String addLine1;
	private String addLine2;
	private String city;
	private String state;
	private String pincode;
	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
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
	 * @return the addLine1
	 */
	public String getAddLine1() {
		return addLine1;
	}
	/**
	 * @param addLine1 the addLine1 to set
	 */
	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}
	/**
	 * @return the addLine2
	 */
	public String getAddLine2() {
		return addLine2;
	}
	/**
	 * @param addLine2 the addLine2 to set
	 */
	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", empCode=" + empCode
				+ ", addLine1=" + addLine1 + ", addLine2=" + addLine2
				+ ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}
	
	
}
