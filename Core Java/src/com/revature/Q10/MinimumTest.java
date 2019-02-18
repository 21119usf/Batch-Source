package com.revature.Q10;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class MinimumTest {

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 10...");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}

	@Test
	@DisplayName("check min")
	void min() {
		assertEquals(3,Minimum.min(3, 6));
		assertEquals(3,Minimum.min(6, 3));
	}

}
