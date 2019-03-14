package com.revature.beans;

public class Employee {
	private String fname;
	private String lname;
	private String EId;
	
	
	
	public Employee(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEId() {
		return EId;
	}
	public void setEId(String eId) {
		EId = eId;
	}
}
