package com.revature.Q19;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class ArrayListStuffTest {
	
	static ArrayList<Integer> actual1 = new ArrayList<Integer>();
	static {actual1.addAll(Arrays.asList(new Integer[] {
		1,2,3,4,5,6,7,8,9,10	
	}));}
	static ArrayList<Integer> actual2 = new ArrayList<Integer>();
	static {actual2.addAll(Arrays.asList(new Integer[] {
		1,2,3,4,5,6,7,8,9,10	
	}));}

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 19...");
	}
	@BeforeEach
	void BeforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}

	@Test
	@DisplayName("check oddEvenSum")
	void oddEvenSum() {
		int[] expected = {25,30};
		assertArrayEquals(expected,ArrayListStuff.oddEvenSums(actual1));
	}
	@Test
	@DisplayName("check removePrimes")
	void removePrimes() {
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.addAll(Arrays.asList(new Integer[] {
			1,4,6,8,9,10	
		}));
		ArrayListStuff.removePrimes(actual2);
		assertEquals(expected,actual2);
	}

}
