package daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import employeestuff.EmpInfo;
import util.ConnFactory;

public class EmployeeDao {

	
	
	public static ConnFactory cf=ConnFactory.getInstance();

    //get specific
public EmpInfo getEmpInfo(String name, String username, String password, String email) throws SQLException {
	EmpInfo x=null;
		Connection conn= cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM EMPLOYEES" );
		while(rs.next()) {
			x= new EmpInfo(null, rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), null);
		
		}
		return x;
	}
	
	
	
//	public void insertEmpl(String name, String username, String password,
//			String email, String approval) throws SQLException 
//	{
//		Connection conn= cf.getConnection();
//		String sql = "{ call TMRS_INSERT_EMPLOYEE(?,?,?,?,?)";
//		CallableStatement call = conn.prepareCall(sql);
//		call.setString(1, name);
//		call.setString(1, username);
//		call.setString(1, password);
//		call.setString(1, email);
//		call.setString(1, approval);
//		call.executeUpdate();
//	}
	
	
	
	public void insertEmpl(EmpInfo x) throws SQLException {
		String sql= "INSERT INTO EMPLOYEES VALUES(?,?,?,?)";
		Connection conn=cf.getConnection();
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1,x.getName());
		ps.setString(2,x.getUsername());
		ps.setString(3,x.getPassword());
		ps.setString(4,x.getEmail());
		ps.executeUpdate();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
