package com.revature.JUnit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {
	
	@BeforeAll
	static void  beforeAll() {
		System.out.println("Before All");
	}
	@BeforeEach
	 void beforeEach(TestInfo info) {
		System.out.println("Initialize data for" + info.getDisplayName());
	}
	
	@Test
	@DisplayName("Check Uppercase")
	void toUpperCase() {
		String str = "abcd";
		String result = str.toUpperCase();
		//asserEquals(Expected, Actual)
		assertEquals("ABCD", result);
	}
	@Test
	@DisplayName("Doz it have it")
	void contains_basic() {
		String str = "abcdefg";
		boolean result = str.contains("ijk");
		//assertEquals(false, result);
		assertFalse(result);
	}

}
