package imp;

import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


import dao.UpdateDAO;
import util.ConnFactory;

public class UpdateIMP implements UpdateDAO {
	public static ConnFactory cf = ConnFactory.getInstance();


	public void Approve(int rid, int eid) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = cf.getConnection();
		String sql = "UPDATE REIMBURSEMENT SET IN_CHARGE = ?, APPROVAL_STATUS = APPROVAL_STATUS + 1 WHERE REIMBUREMENT_ID = ?";
		CallableStatement stmt = conn.prepareCall(sql);
		stmt.setInt(1, eid);
		stmt.setInt(2, rid);
		stmt.executeUpdate();
	}

	public void Deny(int rid, int eid) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "UPDATE REIMBURSEMENT SET IN_CHARGE = ?, APPROVAL_STATUS = -1 WHERE REIMBUREMENT_ID = ?";
		CallableStatement stmt = conn.prepareCall(sql);
		stmt.setInt(1, eid);
		stmt.setInt(2, rid);
		stmt.executeUpdate();
	}

	public void Accept(int rid, int eid) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "UPDATE REIMBURSEMENT SET IN_CHARGE = ?, APPROVAL_STATUS = APPROVAL_STATUS + 1 WHERE REIMBUREMENT_ID = ?";
		CallableStatement stmt = conn.prepareCall(sql);
		stmt.setInt(1, eid);
		stmt.setInt(2, rid);
		stmt.executeUpdate();
	}

}
