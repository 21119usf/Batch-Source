package com.revature.bap1;

public class ViewManager {
	
	private Bank bank;
	private UserInput ui;
	private UserOutput uo;
	
	public ViewManager() {
		bank = new Bank();
		ui = new UserInput();
		uo = new UserOutput();
	}
	
	public void run() {
		bank.readFiles();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		bank.writeFiles();
	}
	
	public void login() {
		
	}
}
