package com.reavature.service;

import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.AccountStatus;
import com.revature.beans.Employee;
import com.revature.beans.User;
import com.revature.io.FileIO;

public class AccountsService {
	public static ArrayList<Account> getUsersAccounts(int userId) {
		ArrayList<Account> usersAccounts = new ArrayList<Account>();
		ArrayList<Account> accounts = FileIO.getFromFile("accounts.txt");
		
		for (Account x : accounts) {
			if (x.getOwners().contains(userId)) {
				usersAccounts.add(x);
			}
		}
		
		return usersAccounts;
	}
	
	public static ArrayList<Account> getPendingAccounts() {
		ArrayList<Account> accounts = FileIO.getFromFile("accounts.txt");
		ArrayList<Account> pendingAccounts = new ArrayList<Account>();
		for (Account x : accounts) {
			if (x.getStatus() == AccountStatus.pending) {
				pendingAccounts.add(x);
			}
		}
		return pendingAccounts;
	}
	
	public static User getUser(Account a) {
		ArrayList<User> users = FileIO.getFromFile("users.txt");
		for (User x : users) {
			if (a.getOwners().contains(x.getUserId())) {
				return x;
			}
		}
		return null;
	}
	
	public static void updateAccount(Account a) {
		ArrayList<Account> accounts = FileIO.getFromFile("accounts.txt");
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getId() == a.getId()) {
				accounts.set(i, a);
			}
		}
		FileIO.savedata(accounts, "accounts.txt");
	}
	
	public static void closeAccount(Account a) {
		a.setStatus(AccountStatus.closed);
		updateAccount(a);
	}
	
	public static void closeAccount(int accountId) {
		Account a = getAccountById(accountId);
		a.setStatus(AccountStatus.closed);
		updateAccount(a);
	}
	
	public static Account getAccountById(int accountId) {
		ArrayList<Account> accounts = FileIO.getFromFile("accounts.txt");
		for (Account x : accounts) {
			if (x.getId() == accountId) {
				return x;
			}
		}
		return null;
	}
	
	public static ArrayList<Account> getAccounts() {
		ArrayList<Account> accounts = FileIO.getFromFile("accounts.txt");
		return accounts;
	}
	
//	public static void addUserToAccount(int accountId, int userId) throws ValidationException {
//		Account a = getAccountById(accountId);
//		User u = UserService.getUserById(userId);
//		ArrayList<Integer> owners = a.getOwners();
//		owners.add(u.getUserId());
//		updateAccount(a);
//	}
	
	public static void addUserToAccount(Account a, int userId) {
		ArrayList<Integer> owners = a.getOwners();
		owners.add(userId);
		updateAccount(a);
	}
	
	public static ArrayList<User> getEmployeeClients(Employee e) {
		ArrayList<User> users = FileIO.getFromFile("users.txt");
		ArrayList<User> clients = new ArrayList<User>();
		for (User x : users) {
			if (e.getClients().contains(x.getUserId())) {
				clients.add(x);
			}
		}
		return clients;
	}
	
	public static ArrayList<Account> getEmployeeAccounts(Employee e) {
		ArrayList<User> clients = getEmployeeClients(e);
		ArrayList<Account> accounts = AccountsService.getAccounts();
		ArrayList<Account> clientAccounts = new ArrayList<Account>();
		for (Account a : accounts) {
			for (int i = 0 ; i < a.getOwners().size(); i++) {
				if (e.getClients().contains(a.getOwners().get(i))) {
					clientAccounts.add(a);
				}
			}
		}
		return clientAccounts;
	}
}
 