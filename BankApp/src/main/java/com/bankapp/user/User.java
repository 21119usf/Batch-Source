package com.bankapp.user;

import java.io.Serializable;

// Abstract Person class
public abstract class User implements Serializable {
	private static final long serialVersionUID = 2873971097414980959L;
	private String firstName;
	private String lastName;
	private long ssNumber;
	private String address;

	String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getSsNumber() {
		return ssNumber;
	}
	public void setSsNumber(long ssNumber) {
		this.ssNumber = ssNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
