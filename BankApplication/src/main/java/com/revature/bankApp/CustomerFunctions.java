package com.revature.bankApp;

import java.util.HashMap;
import java.util.Map;

public class CustomerFunctions {  //customer map
	
	//Deposit, Withdraw, Transfer, Apply for joint account
	private Map<User, Account> mapOfAccountOwner = new HashMap<User, Account>();
	
	public void deposit(User user, double amount) {
		mapOfAccountOwner.get(user).deposit(amount);
	}
	
	public void withdraw(User user, double amount) {
		mapOfAccountOwner.get(user).withdraw(amount);
	}
	
	public void transfer(User user1, User user2, double amount) {
		mapOfAccountOwner.get(user1).withdraw(amount);
		mapOfAccountOwner.get(user2).deposit(amount);
	}
	
	public void addUserToMap(User user, Account account) {
		mapOfAccountOwner.put(user, account);
	}
	
	public void deleteUser(User user) {
		mapOfAccountOwner.remove(user);
	}
	
	public void getBalanceUser(User user) {
		mapOfAccountOwner.get(user).getBalance();
	}
	
	public Map<User, Account> getFullMap(){
		return mapOfAccountOwner;
	}
	
	
	
}
