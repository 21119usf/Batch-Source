package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.Employee;
import beans.Reimbursement;


public interface ReadDAO {
	public abstract ArrayList<Employee> getEmployeeList() throws SQLException;
	public abstract ArrayList<Reimbursement> getReimbursementList() throws SQLException;
	public abstract ArrayList<Reimbursement> getMyReimbursement (int id) throws SQLException;
	public abstract Employee checkLogin(String username, String pass) throws SQLException;
	
}
