package com.revature.bankingapp;

public class Joint extends Individual{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 818216464881917955L;
	
	int accountNum;
	float balance;
	String custFirst;
	String custLast;
	String coFirst;
	String coLast;
	String userName;
	String Password;
	String coUserName;
	String coUserPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getCoUserName() {
		return coUserName;
	}

	public void setCoUserName(String coUserName) {
		this.coUserName = coUserName;
	}

	public String getCoUserPassword() {
		return coUserPassword;
	}

	public void setCoUserPassword(String coUserPassword) {
		this.coUserPassword = coUserPassword;
	}

	public String getCoFirst() {
		return coFirst;
	}

	@Override
	void deposit(float depAmount) {
		this.balance = balance+depAmount;
		// TODO Auto-generated method stub
		
	}

	@Override
	void withdraw(float wdAmount) {
		this.balance = balance+wdAmount;
	}

	@Override
	void transfer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void view() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public String toString() {
		return "Joint Account Details: \nAccount Number: " + accountNum +
				"\nPrimary Owner Name: "+custFirst+ " "+custLast+", Co Owner Name: " + coFirst
				+ " " + coLast+"\nBalance: $" + balance;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getCustFirst() {
		return custFirst;
	}

	public void setCustFirst(String custFirst) {
		this.custFirst = custFirst;
	}

	public String getCustLast() {
		return custLast;
	}

	public void setCustLast(String custLast) {
		this.custLast = custLast;
	}

	public Joint() {
		// TODO Auto-generated constructor stub
	}
	public String getCofirst() {
		return coFirst;
	}

	public void setCoFirst(String coFirst) {
		this.coFirst = coFirst;
	}

	public String getCoLast() {
		return coLast;
	}

	public void setCoLast(String coLast) {
		this.coLast = coLast;
	}

}
