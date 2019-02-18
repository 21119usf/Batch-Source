package com.revature.Q4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class FactorialTest {

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 2...");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}

	@Test
	@DisplayName("check Factorial")
	void fibonacciTest() {
		assertEquals(362880,Factorial.factorial(9));
	}

}
