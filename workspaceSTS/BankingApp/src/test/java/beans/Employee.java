package beans;

import java.util.ArrayList;

public class Employee extends User {
	protected int overseerAccount;
	protected ArrayList<Integer> customerAccounts;
	
	
	//Constructor
	public Employee() {
		super();
		this.overseerAccount = -1;
		this.accessLevel = 1;
		customerAccounts = new ArrayList<Integer>();
	}
	
	public Employee(String name, String address, String email, String phoneNum, String userName, String password,
			int accountNum, int overseerAccount) {
		super(name, address, email, phoneNum, userName, password, accountNum, 1);
		this.overseerAccount = overseerAccount;
		customerAccounts = new ArrayList<Integer>();
	}

	
	//Setters and Getters (Except for ArrayList<Integer> customerAccounts)
	public int getOverseerAccount() {
		return overseerAccount;
	}

	public void setOverseerAccount(int overseerAccount) {
		this.overseerAccount = overseerAccount;
	}
	
	
	//Adding and removing accounts to the list of accounts adjoined to
	public void addCustomerAccount(int accountNum) {
		customerAccounts.add(accountNum);
	}
	
	public void removeCustomerAccount(int accountNum) {
		customerAccounts.remove(accountNum);
	}
	
	
	//Printing Methods
	@Override
	public String toString() {
		return "Employee [Name:" + name + ", Address:" + address + ", E-mail:" + email + ", Phone #:" + phoneNum
				+ ", Username:" + userName + ", Password:" + password + ", Account #:" + accountNum + ", Access Level:"
				+ accessLevel + ", Overseer:" + overseerAccount + ", Customer Accounts:" + customerAccounts.toString() + "]";
	}
	
	@Override
	public void printAccountInfo() {
		System.out.println("Username: " + getUserName()
						+ "\nPassword: " + getPassword()
						+ "\nCustomer Accounts: " + customerAccounts.toString()
						+ "\nAccount #: " + getAccountNum()
						+ "\nOverseer: " + getOverseerAccount()
						+ "\nAccess Level: " + getAccessLevel());
	}
}
