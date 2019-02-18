package com.revature.overloading;

public class Overload {

	static int myInt = 3;
	static Integer myInteger = 5;
	static short myShort = 45;
	
	static int overloadSumTest(int a, int b) {
		return a+b;
	}
	static int overloadSumTest(int a, int ... b) {
		int c = a;
		for(int i:b) {
			c = c + i;
		}
		return c;
	}
	
	public static void main(String[] args) {
		System.out.println(overloadSumTest(myInt, 5));
		System.out.println(overloadSumTest(myInt, myShort));
		System.out.println(overloadSumTest(myInt, myInteger));
		System.out.println(overloadSumTest(myInt, 5,6,4,9,10));
	}

}
