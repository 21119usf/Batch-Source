package beans;

import java.util.ArrayList;

public class Customer extends User {
	
	protected double balance;
	protected ArrayList<String> jointAccounts;
	
	
	//Constructors
	public Customer() {
		super();
		this.balance = 0.0;
		this.accessLevel = 2;
		jointAccounts = new ArrayList<String>();
	}
	
	public Customer(String name, String address, String email, String phoneNum, String userName, String password,
			int accountNum) {
		super(name, address, email, phoneNum, userName, password, accountNum, 2);
		this.balance = 0.0;
		jointAccounts = new ArrayList<String>();
	}


	//Setters and Getters (Except for ArrayList<Integer> jointAccounts)
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	//Adding and removing accounts to the list of accounts adjoined to
	public void addJointAccount(String username) {
		jointAccounts.add(username);
	}
	
	public void removeJointAccount(int accountNum) {
		jointAccounts.remove(accountNum);
	}
	
	//Utility methods
	public boolean deposit(double amount) {
		if (amount < 0) {
			System.out.println("Cannot deposit a negative amount");
		}
		else {
			setBalance(getBalance() + amount);
			return true;
		}
		return false;
	}
	
	public boolean withdraw(double amount) {
		if (amount < 0)
			System.out.println("Cannot withdraw a negative amount");
		else if (amount > getBalance())
			System.out.println("Insufficient Funds");
		else {
			setBalance(getBalance() - amount);
			return true;
		}
		return false;
	}
	
	public boolean transfer(Customer destination, double amount) {
		if (amount < 0)
			System.out.println("Cannot transfer a negative amount");
		else if (amount > getBalance())
			System.out.println("Insufficient Funds");
		else {
			this.setBalance(this.getBalance() - amount);
			destination.setBalance(destination.getBalance() + amount);
			return true;
		}
		return false;
	}

	
	//Printing Methods
	@Override
	public String toString() {
		return "Customer [\nName: " + name + "\nAddress: " + address + "\nE-mail: " + email + "\nPhone #: " + phoneNum
				+ "\nUsername: " + userName + "\nPassword: " + password + "\nAccount #: " + accountNum + "\nAccess Level: "
				+ accessLevel + "\nBalance: $" + balance + "\nJoint Accounts: " + jointAccounts.toString() + "\n]";
	}


	@Override
	public void printAccountInfo() {
		System.out.println("Username: " + getUserName()
						+ "\nPassword: " + getPassword()
						+ "\nBalance: $" + getBalance()
						+ "\nJoint Accounts: " + jointAccounts.toString()
						+ "\nAccount #: " + getAccountNum()
						+ "\nAccess Level: " + getAccessLevel());
	}

}
