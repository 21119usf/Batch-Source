package com.revature.Q5;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class TestSubString {

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 5...");
	}
	
	@BeforeEach
	void BeforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}

	@Test
	@DisplayName("check mySubString")
	void mySubString() {
		assertEquals("sub",SubString.mySubString("substring", 3));
	}

}
