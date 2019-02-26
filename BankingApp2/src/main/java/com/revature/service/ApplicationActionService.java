package com.revature.service;

import java.sql.SQLException;

import com.reavture.beans.Account;
import com.revature.utilities.DAOUtilities;
import com.revature.utilities.LoggerUtil;

public class ApplicationActionService {

	Account a;
	public ApplicationActionService(Account a) {
		this.a = a;
	}
	
	public void approveApplication() {
		try {
			DAOUtilities.getUserAccountDAO().approveAccounts(a.getAccountId());
			LoggerUtil.LOGGER.info("Account Application Approved. Id: " + a.getAccountId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void denyApplication() {
		try {
			DAOUtilities.getUserAccountDAO().denyAccount(a.getAccountId());
			LoggerUtil.LOGGER.info("Account Application Denined. Id: " + a.getAccountId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
