package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
