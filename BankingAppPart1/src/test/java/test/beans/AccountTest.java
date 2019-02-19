package test.beans;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import banking.beans.Account;

class AccountTest {

	@Test
	void accountConstructorTest() {
		Account newacc = new Account("name", "owner", 5.0, true, "name2", false);
		assertTrue(newacc != null);
	}

}
