package com.revature.person;

public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7127239345100663407L;
	private int userID;
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	
	/*public void approveAccount(Account a) {
		a.setOpen(true);
	}
	public void denyAccount (Account a) {
		a.setOpen(false);
	}*/
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
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
	public Employee(int userID, String userName, String password, String email, String firstName, String lastName) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Employee [userID=" + userID + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	

}
