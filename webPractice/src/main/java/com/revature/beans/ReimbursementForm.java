package com.revature.beans;

public class ReimbursementForm {
private String fname;
private String lname;
private String street;
private String city;
private String state;
private String zipCode;
private String phoneNumber;
private String email;
private int sID;
private String letterGrade;
private double grade;
private String time;
private String date;
private  String grade_format;
private String eventType;
private String justification;
private double cost;
private String month;
private String day;
private String year;

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getGrade_format() {
	return grade_format;
}

public void setGrade_format(String grade_format) {
	this.grade_format = grade_format;
}

public String getEventType() {
	return eventType;
}

public void setEventType(String eventType) {
	this.eventType = eventType;
}

public String getJustification() {
	return justification;
}

public void setJustification(String justification) {
	this.justification = justification;
}

public double getCost() {
	return cost;
}

public void setCost(double cost) {
	this.cost = cost;
}
private String status;

public ReimbursementForm() {
	
}

public ReimbursementForm(String studentID) {
	this.sID = Integer.parseInt(studentID);
	}

public ReimbursementForm(String date, String time, double cost, String grade_format, String eventType,String justification, String lettergrade, double grade) {
	this.date=date;
	this.time=time;
	this.cost=cost;
	this.grade_format=grade_format;
	this.eventType=eventType;
	this.justification=justification;
	this.letterGrade=lettergrade;
	this.grade=grade;
}
		
public ReimbursementForm(String fname, String lname, String street, String city, String state, String zipCode,
		String phoneNumber, String email, String sID) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.street = street;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.sID = Integer.parseInt(sID);
}

public ReimbursementForm(String fname2, String lname2, String eID, String cost2, String grade2,
		String eventType2, String comments, String month, String day, String year, String street, String city, String state)  {
	this.fname = fname2;
	this.lname = lname2;
	this.sID=Integer.parseInt(eID);
	this.cost = Double.parseDouble(cost2);
	this.grade = Double.parseDouble(grade2);
	this.eventType = eventType2;
	this.justification = comments;
	this.setMonth(month);
	this.setDay(day);
	this.setYear(year);
	this.street = street;
	this.city = city;
	this.state = state;
}

public String getLetterGrade() {
	return letterGrade;
}

public void setLetterGrade(String letterGrade) {
	this.letterGrade = letterGrade;
}

public double getGrade() {
	return grade;
}

public void setGrade(double grade) {
	this.grade = grade;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
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
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getZipCode() {
	return zipCode;
}
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getsID() {
	return sID;
}
public void setsID(int sID) {
	this.sID = sID;
}

public String getMonth() {
	return month;
}

public void setMonth(String month) {
	this.month = month;
}

public String getDay() {
	return day;
}

public void setDay(String day) {
	this.day = day;
}

public String getYear() {
	return year;
}

public void setYear(String year) {
	this.year = year;
}
}
