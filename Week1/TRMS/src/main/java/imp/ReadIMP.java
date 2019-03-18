package imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Employee;
import beans.Reimbursement;
import dao.ReadDAO;
import util.ConnFactory;

public class ReadIMP implements ReadDAO{
	public static ConnFactory cf = ConnFactory.getInstance();

	public ArrayList<Employee> getEmployeeList() throws SQLException {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM RE_EMPLOYEE");
		while (rs.next()) {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setFirstname(rs.getString(2));
			e.setLastname(rs.getString(3));
			e.setUsername(rs.getString(4));
			e.setPassword(rs.getString(5));
			e.setEmail(rs.getString(6));
			e.setLeftover(rs.getDouble(7));
			e.setSupervisor(rs.getInt(8));
			e.setClearence(rs.getInt(9));
			employeeList.add(e);
		}
		return employeeList;
	}

	public ArrayList<Reimbursement> getReimbursementList() throws SQLException {
		ArrayList<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM REIMBURSEMENT");
		while (rs.next()) {
			Reimbursement e = new Reimbursement();
			e.setId(rs.getInt(1));
			e.setEmployeeId(rs.getInt(2));
			e.setDate(rs.getDate(3));
			e.setApprovalStatus(rs.getInt(4));
			e.setCost(rs.getInt(5));
			e.setLocation(rs.getString(6));
			e.setGradingFormat(rs.getInt(7));
			e.setEventType(rs.getInt(8));
			e.setJustification(rs.getString(9));
			e.setInCharge(rs.getInt(10));
			e.setDenyReason(rs.getString(11));
			reimbursementList.add(e);
		}
		return reimbursementList;
	}

	public Employee checkLogin(String username, String pass) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM RE_EMPLOYEE WHERE USER_NAME = ? AND CUSTOMER_PASSWORD = ? " );
		stmt.setString(1, username);
		stmt.setString(2,pass);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()!= false) {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setFirstname(rs.getString(2));
			e.setLastname(rs.getString(3));
			e.setUsername(rs.getString(4));
			e.setPassword(rs.getString(5));
			e.setEmail(rs.getString(6));
			e.setLeftover(rs.getDouble(7));
			e.setSupervisor(rs.getInt(8));
			e.setClearence(rs.getInt(9));
			return e;
		}
		return null;
	}

	public ArrayList<Reimbursement> getMyReimbursement(int id) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ? OR IN_CHARGE = ?");
		stmt.setInt(1, id);
		stmt.setInt(2, id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Reimbursement e = new Reimbursement();
			e.setId(rs.getInt(1));
			e.setEmployeeId(rs.getInt(2));
			e.setDate(rs.getDate(3));
			e.setApprovalStatus(rs.getInt(4));
			e.setCost(rs.getInt(5));
			e.setLocation(rs.getString(6));
			e.setGradingFormat(rs.getInt(7));
			e.setEventType(rs.getInt(8));
			e.setJustification(rs.getString(9));
			e.setInCharge(rs.getInt(10));
			e.setDenyReason(rs.getString(11));
			reimbursementList.add(e);
		}
		return reimbursementList;
	}
	
}
