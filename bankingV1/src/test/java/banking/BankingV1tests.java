package banking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import bankingDaoImp.AccountDaoImp;
import bankingDaoImp.AdminDaoImp;
import bankingDaoImp.UserDaoImp;

class BankingV1tests {

	@Test
	void AdminFunctionTest() {
		AdminDaoImp adi = new AdminDaoImp();
		try {
			adi.register("David", "Lavoie");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			boolean login = adi.login("David", "Lavoie");
			assertTrue(login);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			adi.delete("David", "Lavoie");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean login;
		try {
			login = adi.login("David", "Lavoie");
			assertFalse(login);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//TDD AT WORK BABY
	}

	@Test
	void UsrFunctionTest() throws SQLException {
		String fu = "James";
		String bar ="Bond";
		String name ="Mark Wahlberg";
		int social = 010201;
		
		AdminDaoImp adi = new AdminDaoImp();
		UserDaoImp udi = new UserDaoImp();
		assertFalse(udi.login(fu, bar));
		udi.register(fu, bar, name, social);
		adi.approve(fu);
		assertTrue(udi.login(fu, bar));
	}
		//And verifying manually in SQL: YES, it works.
	
	@Test
	void AccountFunctionTest() throws SQLException {
		String fu = "hello";
		UserDaoImp udi = new UserDaoImp();
		udi.openacc(fu);
		udi.closeacc(fu);
		// One thing to note, this deletes all of your empty accounts. Maybe that's not desired. Or maybe it is. Who knows, eh?
	}
	
	@Test
	void TransactionTest() throws SQLException {
		String fu = "hello";
		AccountDaoImp accdi = new AccountDaoImp();
		UserDaoImp udi = new UserDaoImp();
		List<Account> myAccounts = udi.getAccounts(fu);
		accdi.withdraw(myAccounts.get(0).getID(),myAccounts.get(0).getBalance());
		accdi.transfer(myAccounts.get(1).getID(), myAccounts.get(0).getID(), 1666.66);
		myAccounts = udi.getAccounts(fu);
		for (Account a: myAccounts) {
			a.display();
		}
		// Okay I'm happy with how this has worked out
	}
	
	@Test
	void UserListTest() throws SQLException {
		AdminDaoImp adi = new AdminDaoImp();
		List<User> myUsers = adi.getUsers();
		for (User u:myUsers) {
			u.display();
		}
	}
}
