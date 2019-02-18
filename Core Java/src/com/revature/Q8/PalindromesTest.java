package com.revature.Q8;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class PalindromesTest {

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 8...");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}

	@Test
	@DisplayName("check palindromeFilter")
	void palindromeFilter() {
		ArrayList<String> actual = new ArrayList<String>(11);
		actual.addAll(Arrays.asList(new String[] {
				"karan","madam","tom","civic","radar","jimmy",
				"kayak","john","refer","billy","did"
		}));
		actual = Palindromes.palindromeFilter(actual);
		ArrayList<String> expected = new ArrayList<String>(11);
		expected.addAll(Arrays.asList(new String[] {
			"madam","civic","radar","kayak","refer","did"
		}));
		assertEquals(expected,actual);
	}

}
