package daoImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.UserAccount;
import dataAccessObject.UserAccountDao;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import util.ConnFactory;

public class UserAccountDaoImpl implements UserAccountDao{
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createUserAccount(int userID, String firstName, String lastName, String streetAddress,
			String email, String phoneNum, int approval, int isAdmin) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "INSERT INTO USERS_TABLE VALUES(? ,?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userID);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setString(4, streetAddress);
		ps.setString(5, email);
		ps.setString(6, phoneNum);
		ps.setInt(7, approval);
		ps.setInt(8, isAdmin);
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
	public ArrayList<UserAccount> getPendingUsers() throws SQLException {
		ArrayList<UserAccount> users = new ArrayList<UserAccount>();
		Connection con = cf.getConnection();
		String sql = "{call GET_ALL_PENDING_ACCOUNTS(?)}";
		CallableStatement stmt = con.prepareCall(sql);
		stmt.registerOutParameter(1, OracleTypes.CURSOR);
		stmt.execute();
		ResultSet rs = ((OracleCallableStatement)stmt).getCursor(1);
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
	public ArrayList<UserAccount> getAllRegularUsers() throws SQLException {
		ArrayList<UserAccount> users = new ArrayList<UserAccount>();
		Connection con = cf.getConnection();
		String sql = "{call GET_ALL_USER_ACCOUNTS(?)}";
		CallableStatement stmt = con.prepareCall(sql);
		stmt.registerOutParameter(1, OracleTypes.CURSOR);
		stmt.execute();
		ResultSet rs = ((OracleCallableStatement)stmt).getCursor(1);
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
	public ArrayList<UserAccount> getAllAdmins() throws SQLException {
		ArrayList<UserAccount> users = new ArrayList<UserAccount>();
		Connection con = cf.getConnection();
		String sql = "{call GET_ALL_ADMIN_ACCOUNTS(?)}";
		CallableStatement stmt = con.prepareCall(sql);
		stmt.registerOutParameter(1, OracleTypes.CURSOR);
		stmt.execute();
		ResultSet rs = ((OracleCallableStatement)stmt).getCursor(1);
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
