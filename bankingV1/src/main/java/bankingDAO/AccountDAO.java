package bankingDAO;

import java.sql.SQLException;

public interface AccountDAO {
	void withdraw(int accountID, double amount) throws SQLException;
	void deposit(int accountID, double amount) throws SQLException;
	void transfer(int fromID, int toID, double amount) throws SQLException;
}
