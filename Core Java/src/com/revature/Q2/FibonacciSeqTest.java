package com.revature.Q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class FibonacciSeqTest {
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Testing Question 2...");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}
	@Test
	@DisplayName("check fibonacci")
	void fibonacci() {
		FibonacciSeq.fibonacci();
		int[] testFib = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368};
		assertArrayEquals(testFib,FibonacciSeq.fib25);
	}

}
