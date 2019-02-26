package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Application;
import com.revature.beans.ConnFactory;
import com.revature.dao.ApplicationDAO;

public class ApplicationDaoImpl implements ApplicationDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createApplication(int customerID) throws SQLException {
		Connection conn = cf.getConnection();

		String sql = "INSERT INTO APPLICATION_BANK_APP VALUES (APPLICATION_ID.NEXTVAL, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, customerID);
		ps.executeUpdate();
	}

	@Override
	public List<Application> getApplicationList() throws SQLException {
		List<Application> applicationList = new ArrayList<Application>();
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM APPLICATION_BANK_APP");
		Application a = null;
		while (rs.next()) {
			a = new Application(rs.getInt(1), rs.getInt(2));
			applicationList.add(a);
		}
		
		return applicationList;
	}	
}
