package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize data for " + info.getDisplayName());
	}

	@Test
	@DisplayName("Check uppercase")
	void toUpperCase() {
		String str = "abcd";
		String result = str.toUpperCase();
		//assertEquals(<Expected>, <Actual>)
		assertEquals("ABCD", result);
	}

	
	@Test
	@DisplayName("Does it have it")
	void contains_basic() {
		String str = "abcdefg";
		boolean result = str.contains("ijk");
		//assertEquals(false, result);
		assertFalse(result);
	}
	
	@Test
	@DisplayName("Check for Exceptions")
	void length_exception() {
		String str = null;
		assertThrows(NullPointerException.class,
				()->{
					str.length();
					});
	}
}













