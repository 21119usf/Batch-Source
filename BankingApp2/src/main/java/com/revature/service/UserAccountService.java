package com.revature.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.PriorityQueue;

import com.reavature.dao.UserAccountsDAO;
import com.reavture.beans.Account;
import com.reavture.beans.User;
import com.revature.utilities.DAOUtilities;
import com.revature.utilities.LoggerUtil;

public class UserAccountService implements CanServiceAccoutns {

	User u;
	
	public UserAccountService(User u) {
		this.u = u;
	}

	@Override
	public ArrayList<Account> getAccounts() {
		try {
			ArrayList<Account> accounts = DAOUtilities.getUserAccountDAO().getUserAccounts(u.getId());
			new LoggerUtil().log("Got Accounts");
			return accounts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Account>();
	}

	@Override
	public void createAccount(Account a) {
		UserAccountsDAO dao = DAOUtilities.getUserAccountDAO();
		try {
			dao.createAccount(a);
			new LoggerUtil().log("Created Account: " + a.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public PriorityQueue<Account> getPendingAccounts() {
		PriorityQueue<Account> queue = new PriorityQueue<Account>();
		try {
			queue = DAOUtilities.getUserAccountDAO().getPendingAccounts();
			new LoggerUtil().log("Got Pending Accounts");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queue;
	}

}
