package bankingDAO;

import java.sql.SQLException;
import java.util.List;

import banking.Account;

public interface UserDAO {
	boolean login(String username, String password) throws SQLException;
	void register(String username, String password, String name, int SSD) throws SQLException;
	List<Account> getAccounts(String username) throws SQLException;
	void openacc(String username) throws SQLException;
	void closeacc(String username) throws SQLException;
}
