package testmain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import daos.EmployeeDao;
import employeestuff.EmpInfo;
import util.ConnFactory;

public class TestDriver {
	
	static int custid = 3;
	 static String name = "joejoe";
	  static String username = "joeJoe";
	 static  String password = "password ";
	  static String email = "joejoe@joe.com";
	  static String approval = "blahblah";
	  
	public static ConnFactory cf=ConnFactory.getInstance();
	public static void insertEmpl() throws SQLException {
		String sql= "INSERT INTO TMRS_EMPLOYEE VALUES(?,?,?,?,?,?)";
		Connection conn=cf.getConnection();
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, custid);
		ps.setString(2, name);
		ps.setString(3, username);
		ps.setString(4, password);
		ps.setString(5, email);
		ps.setString(6, approval);
		ps.executeUpdate();
	}
	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		

		insertEmpl();
	
	}

}
