package com.revature.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.menu.CustomerMenu;

class BankAppTesting {

	@Test
	void createTest() {
		int uid= 10018;
		CustomerMenu cm = new CustomerMenu();
		cm.depositMoney(uid);
		
	}
	
	@DisplayName("Check uppercase")
	@Test
	
	void toUpperCase() {
		String str = "abcd";
		String result=str.toUpperCase();
		//assertEquals(Expected, Actual)
		assertEquals("ABCD", result);
	}

}
