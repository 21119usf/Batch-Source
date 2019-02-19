package banking.beans;

import java.io.Serializable;

public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3114700200225598528L;
	private String accountName;
	private String ownerName;
	private String jointOwnerName;
	private boolean isJoint;
	private double balance;
	public static final String fileName = "Accounts";
	private boolean approved;	
	
	public Account(String name, String owner, double balance, boolean joint, String jointName, boolean approved) {
		this.accountName = name;
		this.ownerName = owner;
		this.balance = balance;
		this.isJoint = joint;
		this.jointOwnerName = jointName;
		this.approved = approved;
	}
	
	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getJointOwnerName() {
		return jointOwnerName;
	}
	public void setJointOwnerName(String jointOwnerName) {
		this.jointOwnerName = jointOwnerName;
	}
	public boolean isJoint() {
		return isJoint;
	}
	public void setJoint(boolean isJoint) {
		this.isJoint = isJoint;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		
		if(approved == false) {
			return "Account " + accountName + " is awaiting approval.";
		}
		
		if(isJoint)
			return "Account " + accountName +  " [ownerName=" + ownerName + ", jointOwnerName=" + jointOwnerName
				+ ", balance=" + balance + "]";
		else
			return "Account " + accountName +  " [ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	
	


}
