package com.revature.banking.user;

public class Applicants extends User {
	private int ID;
	private String username;
	private boolean joint;
	private int passEncrypt;
	private boolean approved;
	
	public Applicants(int custNum, String custAttempt, boolean joint, int encryption, boolean approved) {
		
		this.ID = custNum;
		this.username = custAttempt;
		this.joint = joint;
		this.passEncrypt = encryption;
		this.approved = approved;
		
	}
	public int getID() {
		return ID;
	}
	@Override
	public String toString() {
		return "Applicants [ID=" + ID + ", username=" + username + ", joint=" + joint + ", approved=" + approved + "]";
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isJoint() {
		return joint;
	}
	public void setJoint(boolean joint) {
		this.joint = joint;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	
}
