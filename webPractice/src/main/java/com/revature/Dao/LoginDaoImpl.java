package com.revature.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;

public class LoginDaoImpl {
	List<Object> creds = new ArrayList<Object>();
	
	public List<Object>studentLogin(User user) throws ClassNotFoundException {
		boolean status = false;
		if(creds.size()>0) {
			creds.clear();
		}
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection connector = DriverManager.getConnection("jdbc:oracle:thin:@bankapp1.clkgfudo2lkd.us-east-1.rds.amazonaws.com:1521:ORCL", 
						"forsaken", "halo0221");
			Statement state = connector.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM STUDENTUSERS WHERE username = '" 
					+ user.getUsername() + "' AND password = '"+ user.getPassword() +"'");
			if(rs.next()) {// if query finds match this means successful login if false no match no login 
				status =  true;
				creds.add(status);
				creds.add(rs.getInt(3));
			}
			else {
				status = false;
				creds.add(status);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return creds;
		
		
	}
	
	public boolean employeeLogin(User user) throws ClassNotFoundException {
		boolean status = false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection connector = DriverManager.getConnection("jdbc:oracle:thin:@bankapp1.clkgfudo2lkd.us-east-1.rds.amazonaws.com:1521:ORCL", 
						"forsaken", "halo0221");
			Statement state = connector.createStatement();
			ResultSet rs = state.executeQuery("SELECT username, password FROM EMPLOYEEUSERS WHERE username = '" 
					+ user.getUsername() + "' AND password = '"+ user.getPassword() +"'");
			if(rs.next()) {// if query finds match this means successful login if false no match no login 
				status =  true;
			}
			else {
				status = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
		
		public boolean BencoLogin(User user) throws ClassNotFoundException {
			boolean status = false;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 Connection connector = DriverManager.getConnection("jdbc:oracle:thin:@bankapp1.clkgfudo2lkd.us-east-1.rds.amazonaws.com:1521:ORCL", 
							"forsaken", "halo0221");
				Statement state = connector.createStatement();
				ResultSet rs = state.executeQuery("SELECT username, password FROM BENCOUSERS WHERE username = '" 
						+ user.getUsername() + "' AND password = '"+ user.getPassword() +"'");
				if(rs.next()) {// if query finds match this means successful login if false no match no login 
					status =  true;
				}
				else {
					status = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
		
		
	}
}
