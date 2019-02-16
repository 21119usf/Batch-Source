package beans;

import java.util.ArrayList;

public class Customer extends User {
	
	protected double balance;
	protected int overseerAccount;
	protected boolean isJointAccount;
	protected ArrayList<Integer> jointAccounts;
	
	
	//Constructors
	public Customer() {
		super();
		this.balance = 0.0;
		this.overseerAccount = -1;
		this.isJointAccount = false;
		this.accessLevel = 2;
		jointAccounts = new ArrayList<Integer>();
	}
	
	public Customer(String name, String address, String email, String phoneNum, String userName, String password,
			int accountNum, int overseerAccount, boolean isJointAccount) {
		super(name, address, email, phoneNum, userName, password, accountNum, 2);
		this.balance = 0.0;
		this.overseerAccount = overseerAccount;
		this.isJointAccount = isJointAccount;
		jointAccounts = new ArrayList<Integer>();
	}


	//Setters and Getters (Except for ArrayList<Integer> jointAccounts)
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getOverseerAccount() {
		return overseerAccount;
	}

	public void setOverseerAccount(int overseerAccount) {
		this.overseerAccount = overseerAccount;
	}

	public boolean isJointAccount() {
		return isJointAccount;
	}

	public void setJointAccount(boolean isJointAccount) {
		this.isJointAccount = isJointAccount;
	}
	
	
	//Adding and removing accounts to the list of accounts adjoined to
	public void addJointAccount(int accountNum) {
		jointAccounts.add(accountNum);
	}
	
	public void removeJointAccount(int accountNum) {
		jointAccounts.remove(accountNum);
	}

	
	//Printing Methods
	@Override
	public String toString() {
		return "Customer [Name:" + name + ", Address:" + address + ", E-mail:" + email + ", Phone #:" + phoneNum
				+ ", Username:" + userName + ", Password:" + password + ", Account #:" + accountNum + ", Access Level:"
				+ accessLevel + ", Balance:" + balance + ", Overseer:" + overseerAccount + ", Joint Account:"
				+ isJointAccount + ", Joint Accounts:" + jointAccounts.toString() + "]";
	}


	@Override
	public void printAccountInfo() {
		System.out.println("Username: " + getUserName()
						+ "\nPassword: " + getPassword()
						+ "\nBalance: " + getBalance()
						+ "\nJoint Account: " + isJointAccount()
						+ "\nJoint Accounts: " + jointAccounts.toString()
						+ "\nAccount #: " + getAccountNum()
						+ "\nOverseer: " + getOverseerAccount()
						+ "\nAccess Level: " + getAccessLevel());
	}

}
