package com.revature.beans;

public class Student{
	private String fname;
	private String lname;
	private int studentID;
	
	public Student(String sID) {
		super();
		this.studentID = Integer.parseInt(sID);
	}

	public Student(String firstname, String lastname, int sID){
		this.fname=firstname;
		this.lname=lastname;
		this.studentID=sID;
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

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

}
