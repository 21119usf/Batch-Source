package beans;

import java.util.ArrayList;

public class Customer extends User {
	
	protected double balance;
	protected boolean isJointAccount;
	protected ArrayList<Integer> jointAccounts;
	
	
	//Constructors
	public Customer() {
		super();
		this.balance = 0.0;
		this.isJointAccount = false;
		this.accessLevel = 2;
		jointAccounts = new ArrayList<Integer>();
	}
	
	public Customer(String name, String address, String email, String phoneNum, String userName, String password,
			int accountNum, boolean isJointAccount) {
		super(name, address, email, phoneNum, userName, password, accountNum, 2);
		this.balance = 0.0;
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
		return "Customer [\nName: " + name + "\nAddress: " + address + "\nE-mail: " + email + "\nPhone #: " + phoneNum
				+ "\nUsername: " + userName + "\nPassword: " + password + "\nAccount #: " + accountNum + "\nAccess Level: "
				+ accessLevel + "\nBalance: " + balance + "\nJoint Account: "
				+ isJointAccount + "\nJoint Accounts: " + jointAccounts.toString() + "\n]";
	}


	@Override
	public void printAccountInfo() {
		System.out.println("Username: " + getUserName()
						+ "\nPassword: " + getPassword()
						+ "\nBalance: " + getBalance()
						+ "\nJoint Account: " + isJointAccount()
						+ "\nJoint Accounts: " + jointAccounts.toString()
						+ "\nAccount #: " + getAccountNum()
						+ "\nAccess Level: " + getAccessLevel());
	}

}
