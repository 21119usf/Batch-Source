package beans;

import java.util.ArrayList;

public class Customer extends User {
	
	protected double balance;
	protected int overseerAccount;
	protected boolean isJointAccount;
	protected ArrayList<Integer> jointAccounts;
	
	
	//Constructor
	public Customer(String name, String address, String email, String phoneNum, String userName, String password,
			int accountNum, int accessLevel, double balance, int overseerAccount, boolean isJointAccount) {
		super(name, address, email, phoneNum, userName, password, accountNum, accessLevel);
		this.balance = balance;
		this.overseerAccount = overseerAccount;
		this.isJointAccount = isJointAccount;
		jointAccounts = new ArrayList<Integer>();
	}


	//Setters and Getters (Except for int[] jointAccounts
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


	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", email=" + email + ", phoneNum=" + phoneNum
				+ ", userName=" + userName + ", password=" + password + ", accountNum=" + accountNum + ", accessLevel="
				+ accessLevel + ", balance=" + balance + ", overseerAccount=" + overseerAccount + ", isJointAccount="
				+ isJointAccount + ", jointAccounts=" + jointAccounts + "]";
	}
	
	

}
