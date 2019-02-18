package com.revature.bap1;

public class Bank {
	
	private UserManager um;
	private AccountManager am;
	
	public Bank() {
		um = new UserManager();
		am = new AccountManager();
	}
	
	public void readFiles() {
		um.readFile();
		am.readFile();
	}
	
	public void writeFiles() {
		um.writeFile();
		am.writeFile();
	}
}
