package com.revature.homework1;

import java.util.Scanner;

public class Q10_MinVal {

	// find the minimum value of two numbers
	public int minimum(int x, int y) {
		int n = x<y? x:y;
		return n;
	}
	public static void main(String[] args) {
		// ternary someCondition ? ifTrue : ifFalse;
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter first integer:");
		int num1 = myScanner.nextInt();
		System.out.println("Enter Second integer:");
		int num2 =  myScanner.nextInt();
		Q10_MinVal mini = new Q10_MinVal();
		myScanner.close();
		System.out.println("Of the set [" +num1+ "," +num2 + "]" + " the min value is " +mini.minimum(num1, num2));
		
	}

}
