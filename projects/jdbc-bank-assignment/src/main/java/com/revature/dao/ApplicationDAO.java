package com.revature.dao;

import java.sql.SQLException;

public interface ApplicationDAO {
	void createApplication(int customerID) throws SQLException;
}
