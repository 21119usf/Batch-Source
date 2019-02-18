package com.revature.Q1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class BubbleSortTest {
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Testing Question 1...");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info){
		System.out.println("Initializing data for: "+info.getDisplayName());
	}

	@Test
	@DisplayName("check bubbleSort")
	void bubbleSort() {
		int[] testArr = {1,0,5,6,3,2,3,7,9,8,4};
		BubbleSort.bubbleSort(testArr);
		int[] sorted = {0,1,2,3,3,4,5,6,7,8,9};
		assertArrayEquals(sorted,testArr);
	}

}
