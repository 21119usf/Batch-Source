package bankactors;

import java.util.ArrayList;
import java.util.Random;

import account.Account;

public class Customer extends Actor
{
	private static final long serialVersionUID = 6146192988439511126L;
	private int custID;
	private String username;
	private String password;
	private String email;
	private long phoneNum;
	private ArrayList<Account> accounts;
	
	public Customer(String username, String password, String firstName, String lastName,
			String email, String address, long phoneNum, long ssn)
	{
		Random r = new Random();
		custID = r.nextInt(100);
		setUsername(username);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setAddress(address);
		setPhoneNum(phoneNum);
		setSsn(ssn);
		accounts = new ArrayList<Account>();
		
	}

	public int getCustID() {return custID;}
	public String getUsername() {return username;}
	public String getPassword() {return password;}
	public String getEmail() {return email;}
	public long getPhoneNum() {return phoneNum;}
	public ArrayList<Account> getAccounts() {return accounts;}

	public void setCustID(int custID) {this.custID = custID;}
	public void setUsername(String username) {this.username = username;}
	public void setPassword(String password) {this.password = password;}
	public void setEmail(String email) {this.email = email;}
	public void setPhoneNum(long phoneNum) {this.phoneNum = phoneNum;}
	public void setAccounts(ArrayList<Account> accounts) {this.accounts = accounts;}

	@Override
	public String toString() {
		return "Customer [custID=" + custID + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phoneNum=" + phoneNum + ", accounts=" + accounts + "]";
	}
	
	
	
}
