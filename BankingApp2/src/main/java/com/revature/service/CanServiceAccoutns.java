package com.revature.service;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.reavture.beans.Account;

public interface CanServiceAccoutns {
	ArrayList<Account> getAccounts();
	void createAccount(Account a);
	PriorityQueue<Account> getPendingAccounts();
}
