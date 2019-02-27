package com.revature.interfaces;

import java.sql.SQLException;

public interface AdminInterface {
	void cancelAccount(int userID, int acctID) throws SQLException;
}
