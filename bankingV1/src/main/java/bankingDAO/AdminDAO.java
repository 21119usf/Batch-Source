package bankingDAO;

import java.sql.SQLException;
import java.util.List;

import banking.Account;
import banking.User;

public interface AdminDAO {
	boolean login(String username, String password) throws SQLException;
	void register(String username, String password) throws SQLException;
	void delete(String username, String password) throws SQLException;
	void approve(String username) throws SQLException;
	void update(String username, String newPW, String newname, int SSN, boolean approved) throws SQLException;
	List<Account> getAccounts() throws SQLException;
	List<User> getUsers() throws SQLException;
}
