package daoImplementation;

import beans.BankAccount;
import beans.LoginAccount;
import dataAccessObject.BankAccountDao;
import util.ConnFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

public class BankAccountDaoImpl implements BankAccountDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createBankAccount(int userID, double balance, String accountType) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "INSERT INTO BANK_TABLE VALUES(100,?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userID);
		ps.setDouble(2, balance);
		ps.setString(3, accountType);
		ps.executeUpdate();
	}

	@Override
	public ArrayList<BankAccount> getAllBankAccounts() throws SQLException {
		ArrayList<BankAccount> banks = new ArrayList<BankAccount>();
		Connection con = cf.getConnection();
		String sql = "SELECT * FROM BANK_TABLE";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		BankAccount bank = null;
		while (rs.next()) {
			bank = new BankAccount(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4));
			banks.add(bank);
		}
		return banks;
	}

	@Override
	public ArrayList<BankAccount> getBankAccountsOfUser(int userID) throws SQLException {
		ArrayList<BankAccount> banks = new ArrayList<BankAccount>();
		Connection con = cf.getConnection();
		String sql = "SELECT * FROM BANK_TABLE WHERE USER_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		BankAccount bank = null;
		while (rs.next()) {
			bank = new BankAccount(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4));
			banks.add(bank);
		}
		return banks;
	}

	@Override
	public void changeBalance(int bankAccountID, double newBalance) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "UPDATE BANK_TABLE SET BALANCE = ?"
						+ "WHERE BANK_ACCOUNT_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDouble(1, newBalance);
		ps.setInt(2, bankAccountID);
		
		ps.executeUpdate();
	}

	@Override
	public void changeAccountType(int bankAccountID, String accountType) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "UPDATE BANK_TABLE SET ACCOUNT_TYPE = ?"
						+ "WHERE BANK_ACCOUNT_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, accountType);
		ps.setInt(2, bankAccountID);
		ps.executeUpdate();
	}

	@Override
	public void removeBankAccount(int bankAccountID) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "DELETE FROM BANK_TABLE WHERE BANK_ACCOUNT_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, bankAccountID);
		ps.executeUpdate();
	}

	@Override
	public void removeAllBankAccounts(int userID) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "DELETE FROM BANK_TABLE WHERE USER_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userID);
		ps.executeUpdate();
	}

}
