package com.revature.beans;

import java.io.Serializable;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2592595094082649118L;
	private String username;
	private String password;
	private String name;
	private int AccountNumber;
	private int AccountValue;
	private int joint1;
	private int joint2;
	private int jointBalance1;
	private int jointBalance2;
	
	public int getJoint1() {
		return joint1;
	}
	public void setJoint1(int joint1) {
		this.joint1 = joint1;
	}
	public int getJoint2() {
		return joint2;
	}
	public void setJoint2(int joint2) {
		this.joint2 = joint2;
	}
	public int getJointBalance1() {
		return jointBalance1;
	}
	public void setJointBalance1(int jointBalance1) {
		this.jointBalance1 = jointBalance1;
	}
	public int getJointBalance2() {
		return jointBalance2;
	}
	public void setJointBalance2(int jointBalance2) {
		this.jointBalance2 = jointBalance2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public int getAccountValue() {
		return AccountValue;
	}
	public void setAccountValue(int accountValue) {
		AccountValue = accountValue;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	
	public Customer(String username, String password, String name, int accountNumber, int accountValue) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		AccountNumber = accountNumber;
		AccountValue = accountValue;
	}
	
	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", name=" + name + ", AccountNumber="
				+ AccountNumber + ", AccountValue=" + AccountValue + "]";
	}
	
	
	
}
