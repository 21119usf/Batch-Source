package com.revature.bankApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MappingAccountAndUser {//Managaer Map
	
	private Map<Account, ArrayList<User>> mapOfAccountOwners = new HashMap<Account, ArrayList<User>>();//creating map between Accounts obj and ArrayOfUsers
	
	
	public void addUserToExisitingAccount(Account account, User user) {
		if(mapOfAccountOwners.containsKey(account)) {
			mapOfAccountOwners.get(account).add(user);//getting the key of the account. and then adding user to the array of users associated with the key
		}
	}

	
	public void addNewAccount(User user, double balance, CustomerFunctions manager) {
		
		ArrayList<User> customers = new ArrayList<User>();
		customers.add(user);
		Account account = new Account(balance);
		manager.getFullMap().put(user, account); // putting customers into the map of customer and account
		mapOfAccountOwners.put(account, customers); // putting customer in to the map of the for the administrator map
	}
	
	
	
	
	public Map<Account, ArrayList<User>> getFullAccountAndUserMap(){
		return mapOfAccountOwners;
	}
	
}
