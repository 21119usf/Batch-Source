package com.revature.Q18;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class InheriteeTest {

	static Inheritee i = new Inheritee();
	
	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Q18");
	}
	@BeforeEach
	void beforeEach(TestInfo info){
		System.out.println("Initilizating data for: "+info.getDisplayName());
	}
	@Test
	@DisplayName("check checkUpperCase")
	void checkUpperCase() {
		assertTrue(i.checkUpperCase("a string with an UpperCase"));
		assertFalse(i.checkUpperCase("a string with out an uppercase"));
	}
	@Test
	@DisplayName("check toUpperCase")
	void toUpperCase() {
		assertEquals("A STRING TO MAKE UPPERCASE!",i.toUpperCase("a string to make UpperCase!"));
	}
	@Test
	@DisplayName("check convertStrToIntPlusTen")
	void convertStrToIntPlusTen() {
		assert(112 == i.convertStrToIntPlusTen("102"));
	}

}
