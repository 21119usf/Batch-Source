import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.project0.classes.Account;

class AccountTest 
{
	private static Account account;
	
	@BeforeAll
	static void setUp() throws Exception 
	{
		account = new Account(1000, 12345);
	}
	
	@BeforeEach
	 void reset()
	 {
		account.setBalance(1000);
	 }

	@Test
	void withdrawTest() 
	{
		assertEquals(account.getBalance() - 500, account.withdraw(500));
		
		assertFalse(account.withdraw(10000) < 0, "Overdraw was blocked");
	}
	
	@Test 
	void depositTest()
	{
		assertEquals(account.getBalance() + 500, account.deposit(500));
	}
}
