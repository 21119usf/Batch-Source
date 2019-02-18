package com.revature.Q15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class CalculatorTest {
	static Calculator c = new Calculator();
	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 15...");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}

	@Test
	@DisplayName("check add")
	void add() {
		assert(55 == c.add(33, 22));
	}
	@Test
	@DisplayName("check sub")
	void sub() {
		assert(99 == c.sub(100, 1));
	}
	@Test
	@DisplayName("check div")
	void div() {
		assert(33 == c.div(99, 3));
	}
	@Test
	@DisplayName("check mult")
	void mult() {
		assert(300 == c.mult(100, 3));
	}

}
