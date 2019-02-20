import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.bap1.Account;

class TestCase {
	
	private static Account a;
	
	@BeforeAll
	static void beforeAll() {
		a = new Account(0);
	}
	
	@AfterAll
	static void after() {
		a = null;
	}

	@Test
	void getBalanceTest() {
		assertEquals(0, a.getBalance());
	}

	
	@Test
	void withdrawTest() {
		a.setBalance(100);
		assertTrue(a.withdraw(50));
	}
	
	@Test
	void withdrawTest2() {
		assertFalse(a.withdraw(150));
	}
}
