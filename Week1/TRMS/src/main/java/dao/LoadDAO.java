package dao;

import java.sql.SQLException;

public interface LoadDAO {
	public abstract void makeReimbursement(int id, double cost, String location, int gradingFormat, int eventType, String justification,int inCharge) throws SQLException;
}
