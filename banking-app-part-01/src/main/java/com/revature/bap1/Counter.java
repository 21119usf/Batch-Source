package com.revature.bap1;

import java.io.Serializable;

public class Counter implements Serializable {

	private static final long serialVersionUID = -1295017985558786683L;
	
	private int userCounter;
	private int accountCounter;
	private int appCounter;	
	
	public Counter() {
		super();
	}

	public Counter(int userCounter, int accountCounter, int appCounter) {
		super();
		this.userCounter = userCounter;
		this.accountCounter = accountCounter;
		this.appCounter = appCounter;
	}

	public int getUserCounter() {
		return userCounter;
	}

	public void setUserCounter(int userCounter) {
		this.userCounter = userCounter;
	}
	
	public void incrementUserCounter() {
		this.userCounter++;
	}

	public int getAccountCounter() {
		return accountCounter;
	}

	public void setAccountCounter(int accountCounter) {
		this.accountCounter = accountCounter;
	}
	
	public void incrementAccountCounter() {
		this.accountCounter++;
	}

	public int getAppCounter() {
		return appCounter;
	}

	public void setAppCounter(int appCounter) {
		this.appCounter = appCounter;
	}
	
	public void incrementAppCounter() {
		this.appCounter++;
	}
}
