package com.revature.dao;

import java.sql.SQLException;

public interface AccountDao {

	void createAccount(int customerID) throws SQLException;
}
