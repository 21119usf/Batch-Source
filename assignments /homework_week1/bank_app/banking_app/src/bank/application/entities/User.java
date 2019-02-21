package bank.application.entities;

public class User {
	protected String firstname; 
	protected String lastname; 
	protected String email;
	protected String phone_number; 
	protected String address;
	protected String userID;
	
	public User(String firstname, String lastname, String address, String userID, String email, String pn){
		this.firstname = firstname; 
		this.lastname = lastname; 
		this.address = address;
		this.userID = userID; 
		this.phone_number = pn; 
		this.email = email; 
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	//user 
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", phone_number="
				+ phone_number + ", address=" + address + ", userID=" + userID + "]";
	}

	
	
	//utility method for user
	
	
}
