package com.revature.Q17;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class SimpleInterestTest {

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 17...");
	}
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}

	@Test
	@DisplayName("check simpleInterest")
	void simpleInterest() {
		assert(117600.0 == SimpleInterest.simpleInterest(100000.0, 3.92, 30.0));
	}

}
