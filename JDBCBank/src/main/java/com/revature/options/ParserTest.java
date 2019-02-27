package com.revature.options;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class ParserTest {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("Starting parser test");
	}
	@BeforeEach
	public void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}
	
	@Test
	@DisplayName("parser Test")
	public void parserTest() {
		String s = "4";
		int expected = 4;
		int actual = CustomerOptions.parser(s);
		assertEquals(expected,actual);
	}

}
