package dao;

//import beans.Reimbursement;
import java.sql.SQLException;
//import java.util.ArrayList;

public interface UpdateDAO {
	public abstract void Approve(int rid, int eid) throws SQLException;
	public abstract void Deny(int rid, int eid) throws SQLException;
	public abstract void Accept(int rid, int eid) throws SQLException;

}
