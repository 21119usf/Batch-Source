package bankdata;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class BankAccountDao {

	static ConnFactory cf = ConnFactory.getInstance();
	
	public void createBank (String accID, String bal, String custID) throws SQLException 
	{
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		//conn.setAutoCommit(false);
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		String sql = "{ call BANKINSERT (?,?, ?)";
		CallableStatement q = conn.prepareCall(sql);
		//PreparedStatement ps = conn.prepareStatement(sql);
		
		q.setString(1, accID);
		q.setString(2, bal);
		q.setString(3, custID);
		q.execute();
	}
	
	public static void updateBank (String bals, String custid) throws SQLException 
	{
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		//conn.setAutoCommit(false);
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		String sql = "{ call BANKUPDATE (?,?)";
		CallableStatement q = conn.prepareCall(sql);
		//PreparedStatement ps = conn.prepareStatement(sql);
		
		q.setString(1, bals);
		q.setString(2, custid);
		
		q.execute();
	}
	

}
