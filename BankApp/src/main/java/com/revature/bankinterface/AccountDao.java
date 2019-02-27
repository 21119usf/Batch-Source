package com.revature.bankinterface;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.people.Accounts;

public interface AccountDao {
	ArrayList<Accounts> getUserAccounts(int accountid) throws SQLException;
	void createAccount(Accounts a) throws SQLException;

}
