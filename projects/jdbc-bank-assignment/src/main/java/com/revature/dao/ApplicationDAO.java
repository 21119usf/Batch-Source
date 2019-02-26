package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Application;

public interface ApplicationDAO {
	
	void createApplication(int customerID) throws SQLException;
	List<Application> getApplicationList() throws SQLException;
	boolean doesApplicatoinIDExist(int applicationID) throws SQLException;
}
