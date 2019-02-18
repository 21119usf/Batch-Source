package com.revature.Q3;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class ReverseStringTest {

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 2");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}
	@Test
	@DisplayName("check reverseString")
	void reverseString() {
		assertEquals("eM esreveR",ReverseString.reverseString("Reverse Me"));
	}

}
