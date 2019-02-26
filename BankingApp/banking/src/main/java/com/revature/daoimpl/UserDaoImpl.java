package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.banking.AdminAccess;
import com.revature.banking.IO;
import com.revature.banking.NewUser;
import com.revature.banking.UserDashboard;
import com.revature.beans.UserInfo;
import com.revature.dao.UserDao;
import com.revature.util.ConnFactory;
import com.revature.util.ExceptionCatcher;

public class UserDaoImpl implements UserDao {
	private static Logger logger = LogManager.getLogger(AdminAccess.class);
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	public void createUser(String userName, int passEncrypt, String firstName, 
			String lastName, String address, String city, String state, 
			String phone, String email) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call CREATEUSER(?,?,?,?,?,?,?,?,?,?)";
		CallableStatement call=conn.prepareCall(sql);
		call.setString(1, userName);
		call.setInt(2, passEncrypt);
		call.setInt(3, 1);
		call.setString(4, firstName);
		call.setString(5, lastName);
		call.setString(6, address);
		call.setString(7, city);
		call.setString(8, state);
		call.setString(9, phone);
		call.setString(10, email);
		call.execute();      
		   

	}

	public void logonAttempt(String response, int encryption) throws SQLException {
		Connection conn = cf.getConnection();
		boolean success = false;
		while (!success) {
			IO io = new IO();
			String dataprop = io.readInputStreamContents("database.properties");
			String[] dataPropList = dataprop.split(System.getProperty("line.separator"));
			String adminUser = dataPropList[5];
			String adminPassStr = dataPropList[7];
			Integer adminPassInt=adminPassStr.hashCode();
			int adminPass = (adminPassInt*500003477)%1009747;
			if ((response.equals(adminUser))&&encryption==adminPass) {

	    		System.out.println("Welcome, " + adminUser);
	    		System.out.println("=================================================================");
	    		UserDashboard.dash(3, 10000);

				logger.info("User 10000 logged in");
	    		break;
			}
			else {
		 String sql = "SELECT * FROM USERTABLE WHERE USERNAME = '" + 
				 response + "' AND PASSENCRYPT =" + encryption;        
		    PreparedStatement ps = conn.prepareStatement(sql);

		    	ResultSet rs = ps.executeQuery();
//		    	while(rs.next()) {
		    	if (rs.next()) {
		    		int userID = rs.getInt(1);
		    		String userName = rs.getString(2);
		    		int accessType = rs.getInt(4);
		    		System.out.println("Welcome, " + userName);
		    		System.out.println("=================================================================");
		    		UserDashboard.dash(accessType, userID);
					logger.info("User " + userID + " logged in");
		    		break;
		    	}
		    	else {
		    		System.out.println("=================================================================\n" + 
		    				"Incorrect Username or Password. Please try again.");
		    		break;
		    	//}
		    	}
//			}
//			catch() {
//				
//			}
		}
		}
	}

	@Override
	public void getUserInfo(int userID) throws SQLException {
		
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERINFO WHERE USER_ID =" + userID);
		
		while (rs.next()) {
			int userqueryID = rs.getInt("USER_ID");
			String firstName = rs.getString("FIRSTNAME");
			String lastName = rs.getString("LASTNAME");
			String address = rs.getString("ADDRESS");
			String city = rs.getString("CITY");
			String state = rs.getString("STATE_LOC");
			String phoneNumber = rs.getString("PHONE");
			String eMail = rs.getString("EMAIL");
			UserInfo u = new UserInfo(userqueryID,firstName, 
					lastName, address, city, state, 
					phoneNumber, eMail);
			System.out.println(u.toString());
			
	}

}

	@Override
	public boolean checkUser(String response) throws SQLException {
		boolean exists = false;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERTABLE WHERE USERNAME = '" + 
				 response + "'";
		PreparedStatement ps = conn.prepareStatement(sql);

    	ResultSet rs = ps.executeQuery();
    	if (rs.next()) {
    		exists = true;
    	}
    	
		return exists;
		
		
	}
	public int findUserID(String username) throws SQLException {
		int userID=0;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERTABLE WHERE USERNAME = '" + 
				 username + "'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			userID = rs.getInt(1);
		}
		
		return userID;
	}
	
	
	public void updateUser(int userID, String username) throws SQLException {
		ExceptionCatcher ec = new ExceptionCatcher();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERINFO WHERE USER_ID = '" + 
				 userID + "'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String firstName = rs.getString("FIRSTNAME");
			String lastName = rs.getString("LASTNAME");
			String address = rs.getString("ADDRESS");
			String city = rs.getString("CITY");
			String state = rs.getString("STATE_LOC");
			String phoneNumber = rs.getString("PHONE");
			String eMail = rs.getString("EMAIL");
			boolean loggedout=false;
			while (!loggedout) {
			System.out.println("What information would you like to update?");
			System.out.println(	"1 - Password\n"
					+ 			"2 - Address\n"
					+ 			"3 - Phone Number"
					+ 			"4 - Email Address"
					+ 			"5 - First & Last Name"
					+ 			"0 - Go Back");
			Scanner input = new Scanner(System.in);
			String response = input.nextLine();
			Integer choice =ec.parseIntCheck(response);
			switch(choice) {
			case 1:
				System.out.println("Please input the new password:");
				NewUser pc = new NewUser();
				String password = pc.passCheck();
				
				
				break;
			case 2:
				System.out.println("Please input the new address below.");
				System.out.println("Street Address:");
				String newAddress = input.nextLine();
				System.out.println("City:");
				String newCity = input.nextLine();
				System.out.println("State:");
				String newState = input.nextLine();
				sql = "{ call UPDATE_USERINFO(?,?,?,?,?,?,?,?)";
				CallableStatement call=conn.prepareCall(sql);
				call.setInt(1, userID);
				call.setString(2, firstName);
				call.setString(3, lastName);
				call.setString(4, newAddress);
				call.setString(5, newCity);
				call.setString(6, newState);
				call.setString(7, phoneNumber);
				call.setString(8, eMail);
				call.execute();
				break;
			case 3:
				System.out.println("Please input the new phone number below.");
				System.out.println("Phone number:");
				String newPhone = input.nextLine();
				sql = "{ call UPDATE_USERINFO(?,?,?,?,?,?,?,?)";
				call=conn.prepareCall(sql);
				call.setInt(1, userID);
				call.setString(2, firstName);
				call.setString(3, lastName);
				call.setString(4, address);
				call.setString(5, city);
				call.setString(6, state);
				call.setString(7, newPhone);
				call.setString(8, eMail);
				call.execute();
				break;
			case 4:
				System.out.println("Please input the new Email Address below.");
				System.out.println("Email Address:");
				String newEmail = input.nextLine();
				sql = "{ call UPDATE_USERINFO(?,?,?,?,?,?,?,?)";
				call=conn.prepareCall(sql);
				call.setInt(1, userID);
				call.setString(2, firstName);
				call.setString(3, lastName);
				call.setString(4, address);
				call.setString(5, city);
				call.setString(6, state);
				call.setString(7, phoneNumber);
				call.setString(8, newEmail);
				call.execute();
				break;
			case 5:
				System.out.println("Please input full name below.");
				System.out.println("First Name:");
				String newFirstName = input.nextLine();
				System.out.println("Last Name:");
				String newLastName = input.nextLine();
				sql = "{ call UPDATE_USERINFO(?,?,?,?,?,?,?,?)";
				call=conn.prepareCall(sql);
				call.setInt(1, userID);
				call.setString(2, newFirstName);
				call.setString(3, newLastName);
				call.setString(4, address);
				call.setString(5, city);
				call.setString(6, state);
				call.setString(7, phoneNumber);
				call.setString(8, eMail);
				call.execute();
				break;
			case 0:
				loggedout=true;
				break;
			}
			
			}
	}
	}

	public void deleteUser(String response) throws SQLException {
		Scanner input = new Scanner(System.in);
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERTABLE WHERE USERNAME = '" + 
				 response + "'";        
		    PreparedStatement ps = conn.prepareStatement(sql);
		    	ResultSet rs = ps.executeQuery();
		    	if (rs.next()) {
		    		int userID = rs.getInt(1);
		    			AccountDaoImpl adi = new AccountDaoImpl();
		    			List<Integer> accID = adi.pullAccountID(userID);
		    			int numAcc = accID.size();
		    			for (int i=0;i<numAcc;i++) {
		    				int iAccID=accID.get(i);
		    				adi.deleteAccount(iAccID, 10000);
		    			}
		    			System.out.println("Are you sure you want to delete " + response + "? (Y or N)");
		    			String choice = input.nextLine();
		    			if (choice.equals("Y")) {
		    			conn = cf.getConnection();
		    			sql = "{ call DELETE_USER(?)";
		    			CallableStatement call=conn.prepareCall(sql);
		    			call.setInt(1, userID);
		    			call.execute();
		    			System.out.println("User " + userID + " deleted!");
		    			System.out.println("=================================================================");
		    			logger.info("User 10000 deleted " + userID);
		    			}
		    			
		    			
		    	}
		    	else {
		    		System.out.println("=================================================================\n" + 
		    				"User does not exist.");
		    	}
		
	}
}
