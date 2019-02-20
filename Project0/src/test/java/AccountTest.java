import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.project0.classes.Account;

class AccountTest 
{
	private Account account;
	
	@BeforeAll
	void setUp() throws Exception 
	{
		account = new Account(1000, 12345);
	}

	@Test
	void withdrawTest(double amount) 
	{
		assertEquals(account.getBalance() - amount, account.withdraw(amount));
	}

}
