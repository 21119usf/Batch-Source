package bank.beans;

public class Customers
{
	private int customerID;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String ssn;
	private String phoneNum;
	//constrcutors
	
	//getters
	public int getCustomerID() {return customerID;}
	public Customers(int customerID, String firstName, String lastName, String username, String password,
			String address, String ssn, String phoneNum) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.ssn = ssn;
		this.phoneNum = phoneNum;
	}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getUsername() {return username;}
	public String getPassword() {return password;}
	public String getAddress() {return address;}
	public String getSsn() {return ssn;}
	public String getPhoneNum() {return phoneNum;}
	//setters
	public void setCustomerID(int customerID) {this.customerID = customerID;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setUsername(String username) {this.username = username;}
	public void setPassword(String password) {this.password = password;}
	public void setAddress(String address) {this.address = address;}
	public void setSsn(String ssn) {this.ssn = ssn;}	
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	@Override
	public String toString() {
		return "Customers [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + ", address=" + address + ", ssn=" + ssn
				+ ", phoneNum=" + phoneNum + "]";
	}	
}
