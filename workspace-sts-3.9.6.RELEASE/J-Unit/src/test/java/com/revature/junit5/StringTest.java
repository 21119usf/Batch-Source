package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest 
{
	@BeforeAll
	static void beforeAll()
	{
		System.out.println("Before All");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize data for " + info.getDisplayName());
	}
	
	@Test
	@DisplayName("Check upper case method.")
	void toUpperCaseTest() 
	{
		String string = "abcd";
		
		String result = string.toUpperCase();
		
		//assertEquals(expected, actual);
		assertEquals("ABCD", result);
	}
	
	@Test
	@DisplayName("Check the contains method.")
	void containsTest()
	{
		String string = "abcdefg";
		boolean result = string.contains("ijk");
		
		assertFalse(result);
	}
}
