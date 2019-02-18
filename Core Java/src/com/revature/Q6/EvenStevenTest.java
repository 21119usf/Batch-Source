package com.revature.Q6;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class EvenStevenTest {

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing question 6...");
	}

	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}
	@Test
	@DisplayName("check checkEven")
	void checkEven() {
		assertTrue(EvenSteven.checkEven(26));
		assertFalse(EvenSteven.checkEven(83));
	}

}
