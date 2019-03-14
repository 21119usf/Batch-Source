package com.revature.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CheckStatusDaoImpl {
	public String checkStatus(int sID) throws ClassNotFoundException {
	String status = "";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@bankapp1.clkgfudo2lkd.us-east-1.rds.amazonaws.com:1521:ORCL","forsaken","halo0221");
			Statement stmt = conn.createStatement();
			String sql1 ="SELECT STATUS FROM REIMBURSEMENTFORMS WHERE STUDENTSTUDENTID=";
			ResultSet rs1  = stmt.executeQuery(sql1+sID);
			rs1.next();
			status=rs1.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public double getLoan(int sID) throws ClassNotFoundException {
		double loan = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@bankapp1.clkgfudo2lkd.us-east-1.rds.amazonaws.com:1521:ORCL","forsaken","halo0221");
			Statement stmt = conn.createStatement();
			String sql2="SELECT LOAN_AMOUNT FROM STUDENTAID WHERE STUDENTSTUDENTID=";
			ResultSet rs2 = stmt.executeQuery(sql2+sID);
			rs2.next();
			loan = rs2.getDouble(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loan;
	}
}
