package com.revature.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.core.homework.Calculator;
import com.revature.core.homework.EvenNumber;
import com.revature.core.homework.Factorial;
import com.revature.core.homework.Fibonacci;
import com.revature.core.homework.FloatTest;
import com.revature.core.homework.Intrest;
import com.revature.core.homework.MinOfNumbers;
import com.revature.core.homework.NumberArray;
import com.revature.core.homework.Palindromes;
import com.revature.core.homework.Pyramid;
import com.revature.core.homework.StringLength;
import com.revature.core.homework.SubString;
import com.revature.core.homework.floatPack.MyFloatClass;

class HomeworkTest {
	
	@Test
	@DisplayName("# 2")
	void printFib() {
		String actual = Fibonacci.run(5);
		System.out.println(actual);
		System.out.println(1);
		String expected = "0\n1\n2\n3\n4\n5\n";
		System.out.println(expected.compareTo(actual));
		assertTrue(expected.compareTo(actual) == 0);
		// assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("# 4")
	void getFacts() {
		assertEquals(Factorial.factorial(6), 720);
	}
	
	@Test
	@DisplayName("# 5")
	void subString() {
		String sub = SubString.subString("abcd", 2);
		assertEquals("ab", sub);
	}
	
	@Test
	@DisplayName("# 6")
	void isEven() {
		assertTrue(EvenNumber.isEven(2));
	}

	@Test
	@DisplayName("# 8")
	void palindromes() {
		String[] cases ={"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		ArrayList<String> actual = Palindromes.getPalindromesFromList(cases);
		String[] expected = {"madam, civic, radar, kayak, refer, did"};
		String [] actualArr = actual.toArray(new String[actual.size()]);
		assertTrue(Arrays.equals(expected, actualArr));
	}
	
	@Test
	@DisplayName("#10")
	void minofNumbers() {
		int int1 = 2;
		int int2 = 4;
		int expected = int1;
		int actual = MinOfNumbers.run(int1, int2);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("# 11")
	void floatTest() {
		assertTrue(MyFloatClass.x == FloatTest.getXFloat());
		assertTrue(MyFloatClass.y == FloatTest.getYFloat());
	}
	
	@Test
	@DisplayName("#12")
	void numArray() {
		Integer[] expected = {2, 4, 6, 8, 10};
		Integer[] actual = NumberArray.getEvens(10);
		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	@DisplayName("# 13")
	void pryimidTest() {
		String actual =  Pyramid.makePyramid(4);
		String expected = "0\n"
				+ "10\n"
				+ "101\n"
				+ "0101";
		assertTrue(actual.equals(expected));
	}
	
	@Test
	@DisplayName("#15 - add")
	void calcAdd() {
		Calculator cal = new Calculator();
		int int1 = 3;
		int int2 = 4;
		int expected = int1 + int2; 
		int actual = cal.add(int1, int2);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("#15 - subtract")
	void calcSub() {
		Calculator cal = new Calculator();
		int int1 = 3;
		int int2 = 4;
		int expected = int1 - int2; 
		int actual = cal.subtract(int1, int2);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("#15 - multiply")
	void calcMult() {
		Calculator cal = new Calculator();
		int int1 = 3;
		int int2 = 4;
		int expected = int1 * int2; 
		int actual = cal.multiply(int1, int2);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("#15 - divide")
	void calcDiv() {
		Calculator cal = new Calculator();
		int int1 = 3;
		int int2 = 4;
		int expected = int1 / int2; 
		int actual = cal.devide(int1, int2);
		assertEquals(expected, actual);
	}
	@Test
	@DisplayName("#16")
	void stringLength() {
		String [] test = {"abcdefg", "hij"};
		int actual = StringLength.getLength(test);
		assertTrue(actual == 10);
	}
	
	@Test
	@DisplayName("# 17")
	void intrest() {
		assertTrue(Intrest.calc(.17, 1000, 2) == 340);
	}
	
}
