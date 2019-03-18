package imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import util.ConnFactory;

import dao.LoadDAO;

public class LoadIMP implements LoadDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();


	public void makeReimbursement(int id, double cost, String location, int gradingFormat, int eventType,
			String justification, int inCharge) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call INSERTREIMBURS(?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1,id);
		call.setDouble(2,cost);
		call.setString(3,location);
		call.setInt(4, gradingFormat);
		call.setInt(5, eventType);
		call.setString(6, justification);
		call.setInt(7, inCharge);
		call.executeQuery();
	}

}
