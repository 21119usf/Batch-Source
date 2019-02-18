package com.revature.Q9;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class PrimesTest {

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 9...");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}

	@Test
	@DisplayName("check findPrime")
	void findPrime() {
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.addAll(Arrays.asList(new Integer[] {
				2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97
		}));
		ArrayList<Integer> actual = Primes.findPrimes();
		assertEquals(expected,actual);
	}

}
