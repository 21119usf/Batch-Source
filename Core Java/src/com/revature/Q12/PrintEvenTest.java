package com.revature.Q12;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class PrintEvenTest {

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 12...");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("\nInitializing data for: "+info.getDisplayName());
	}

	@Test
	@DisplayName("createArray")
	void createArray() {
		int[] actual = PrintEven.createArray();
		int[] expected = new int[100];
		for(int i=0;i<100;i++)expected[i]=i+1;
		assertArrayEquals(expected,actual);
	}
	@Test
	@DisplayName("printEven")
	void printEven() {
		int[] actual = PrintEven.printEven(PrintEven.createArray());
		int[] expected = new int[50];
		int evenNum = 2;
		for(int i=0;i<50;i++) {
			expected[i] = evenNum;
			evenNum +=2;
		}
		assertArrayEquals(expected,actual);
	}

}
