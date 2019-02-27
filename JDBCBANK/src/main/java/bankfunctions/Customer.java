package bankfunctions;

import java.util.ArrayList;
import java.util.Scanner;

import bankdata.UserInfo;
import bankdata.Writers;

public class Customer{
	private String custxID;
	private String password;
	 private String username;
	 private String name;
	 private String social;
	 
	 @Override
	public String toString() {
		return "Customer [custxID=" + custxID + ", password=" + password + ", username=" + username + ", name=" + name
				+ ", social=" + social + "]";
	}

	public String getCustxID() {
		return custxID;
	}

	public void setCustxID(String custxID) {
		this.custxID = custxID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = social;
	}

///////////////////////////////
	public Customer(String cstID, String user, String pwrd, String namer, String soc) {
		super();
		this.custxID = cstID;
		this.username = user;
		this.password = pwrd;
		this.name = namer;
		this.social = soc;
	}
	
	static void custInfo (){
	//Get customer's personal info from database 
	//Get customer's bank info from database
		
	}
	
	
}
