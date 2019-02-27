package com.revature.bankApp1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import com.revature.logs.Logging;
import com.revature.util.ConnFactory;


	public final class Login{
		public static ConnFactory cf = ConnFactory.getInstance();					
		private ArrayList<Object>logList = new ArrayList<Object>();
		static final Scanner myScanner = new Scanner(System.in);
		String usr;
		String pass;
		String usrAtmp;
		String passAtmp;
		Object obj;
		boolean noAccount = true;
		
		// only users can login
		public Login(String username, String password, Object obj) {						// sets the account into database
			this.usr = username;
			this.pass = password;
			this.obj = obj;
			this.logList.add(0,false);
		}
		
		// login
		public ArrayList<Object> login() throws SQLException {
			Connection conn = cf.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs;
			ResultSet rs2;
			System.out.println("\n>>>>> Almost there ........\n");
			switch(obj.getClass().getSimpleName()) {
			
				case "Admin":
					rs = stmt.executeQuery("SELECT ADMIN_ID FROM EMPLOYEDUSERS WHERE USERNAME="+"'"+usr+"'"+" AND "+"PASSWORD="+"'"+pass+"'");
					rs.next();
					logList.set(0, true);
					logList.add(1,rs.getInt(1));
					noAccount = false;
					Logging.LOGGER.info("Admin Login=> Username:" + usr);
					break;
					//System.out.println("Login Successful. Welcome Back!");
					
					

				case "Employee":
					rs = stmt.executeQuery("SELECT EMPLOYEE_ID FROM EMPLOYEDUSERS WHERE USERNAME="+"'"+usr+"'"+" AND "+"PASSWORD="+"'"+pass+"'");
					while(rs.next()) {
						logList.set(0, true);
						logList.add(1,rs.getInt(1));
						noAccount = false;
						System.out.println("Login Successful. Welcome Back!");
						Logging.LOGGER.info("Admin Eployee => Username:" + usr);
					}
					break;

				case "Customer":
					rs = stmt.executeQuery("SELECT USER_ID FROM USERS WHERE USERNAME="+"'"+usr+"'"+" AND "+"PASSWORD="+"'"+pass+"'");
					while(rs.next()) {
						logList.add(0,true);
						logList.add(1,rs.getInt(1));
						noAccount = false;
						System.out.println("Login Successful. Welcome Back!");
						Logging.LOGGER.info("Customer Login=> Username:" + usr);
					}
					
					rs2 = stmt.executeQuery("SELECT USERNAME FROM PENDINGACCOUNTS WHERE USERNAME ="+"'"+usr+"' AND PASSWORD =" + "'"+pass+"'");
					while(rs2.next()) {
						System.out.println("Your account is still pending... Try again later or contact Customer Service. Thank you.");
						noAccount = false;
						Logging.LOGGER.info("Pending Customer Login attempt => Username:" + usr);
					}
					break;
				}
			
				if(noAccount==true) {
					System.out.println("No account associate with this username and/or password.");
				}
			
			return logList;
		}
			
}
		
