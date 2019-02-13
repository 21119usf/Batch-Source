package com.revature.wrappers;

public class wrapperz {
	static int myInt = 3;
	static Integer myInteger = 5;
	static double myDouble = 45.93;
	static Boolean myBoo = true;
	
	public static int addEmUp(int a, int b) {
		return a+b;
	}
	public static void main (String [] args) {
		
		System.out.println(addEmUp(myInt, (int) myDouble));
	}
}
