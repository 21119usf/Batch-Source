package daoImplementation;

import beans.BankAccount;
import beans.UserAccount;
import dataAccessObject.UserAccountDao;
import util.ConnFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

public class UserAccountDaoImpl implements UserAccountDao{
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createUserAccount(String firstName, String lastName, String streetAddress, String email,
			String phoneNum, int approval, int isAdmin) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "INSERT INTO USERS_TABLE VALUES(100,?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, streetAddress);
		ps.setString(4, email);
		ps.setString(5, phoneNum);
		ps.setInt(6, approval);
		ps.setInt(7, isAdmin);
		ps.executeUpdate();
	}

	@Override
	public ArrayList<UserAccount> getAllUsers() throws SQLException {
		ArrayList<UserAccount> users = new ArrayList<UserAccount>();
		Connection con = cf.getConnection();
		String sql = "SELECT * FROM USERS_TABLE";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		UserAccount user = null;
		while (rs.next()) {
			user = new UserAccount(rs.getInt(1), rs.getString(2), rs.getString(3),
									rs.getString(4), rs.getString(5), rs.getString(6),
									rs.getInt(7), rs.getInt(8));
			users.add(user);
		}
		return users;
	}

	@Override
	public UserAccount getUser(int userID) throws SQLException {
		UserAccount user = null;
		Connection con = cf.getConnection();
		String sql = "SELECT * FROM USERS_TABLE WHERE USER_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			user = new UserAccount(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6),
					rs.getInt(7), rs.getInt(8));
		return user;
	}

	@Override
	public void changeFirstName(int userID, String newFirstName) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "UPDATE USERS_TABLE SET FIRST_NAME = ?"
						+ "WHERE USER_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newFirstName);
		ps.setInt(2, userID);
		ps.executeUpdate();
	}

	@Override
	public void changeLastName(int userID, String newLastName) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "UPDATE USERS_TABLE SET LAST_NAME = ?"
						+ "WHERE USER_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newLastName);
		ps.setInt(2, userID);
		ps.executeUpdate();
	}

	@Override
	public void changeStreetAddress(int userID, String newStreetAddress) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "UPDATE USERS_TABLE SET STREET_ADDRESS = ?"
						+ "WHERE USER_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newStreetAddress);
		ps.setInt(2, userID);
		ps.executeUpdate();
	}

	@Override
	public void changeEmail(int userID, String newEmail) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "UPDATE USERS_TABLE SET EMAIL = ?"
						+ "WHERE USER_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newEmail);
		ps.setInt(2, userID);
		ps.executeUpdate();
	}

	@Override
	public void changePhoneNum(int userID, String newPhoneNum) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "UPDATE USERS_TABLE SET PHONE_NUM = ?"
						+ "WHERE USER_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newPhoneNum);
		ps.setInt(2, userID);
		ps.executeUpdate();
	}

	@Override
	public void changeApproval(int userID, int approval) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "UPDATE USERS_TABLE SET APPROVED = ?"
						+ "WHERE USER_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, approval);
		ps.setInt(2, userID);
		ps.executeUpdate();
	}

	@Override
	public void removeUser(int userID) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "DELETE FROM USERS_TABLE WHERE USER_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userID);
		ps.executeUpdate();
	}

}
