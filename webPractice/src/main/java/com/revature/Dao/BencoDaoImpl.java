package com.revature.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BencoDaoImpl {

	String sql;
	String sql1;
	public void approveReimbursementForm(int sId, double reimbursement) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try {
			sql = "{ call APPROVERIMBURSEMENTFORM(?)";
			sql1 = "UPDATE STUDENTAID SET LOAN_AMOUNT ="+reimbursement+" WHERE STUDENTSTUDENTID ="+sId;
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@bankapp1.clkgfudo2lkd.us-east-1.rds.amazonaws.com:1521:ORCL","forsaken","halo0221");
			PreparedStatement ps = conn.prepareStatement(sql);
			Statement ps1 = conn.createStatement();
			ps1.executeQuery(sql1);
			ps.setInt(1, sId);
			ps.execute();
			ps1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adjustReimbursement(int sId, double reimbursement) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		sql = "{ call ADJUSTREIMBURSEMENT(?)";
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@bankapp1.clkgfudo2lkd.us-east-1.rds.amazonaws.com:1521:ORCL","forsaken","halo0221");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, reimbursement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
