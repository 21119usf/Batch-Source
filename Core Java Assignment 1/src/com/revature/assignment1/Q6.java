package com.revature.assignment1;

import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);//created scanner class
		
		System.out.println("Enter integer to determine if its even: ");//prompt for int
		int n = in.nextInt();//store inputted int in n		
		checkEven(n);//call to method passing parameter
		
		in.close();//closed scanner
	}
	
	static void checkEven(int b) {//method to check if its even
		//can't use modulo
		if(b/2 * 2 == b) {//if the int is divided by 2, if its odd it usually leaves a remainder, it drops the decimal
			System.out.println(b+" is even");//with that if we multiply it by 2 and its the same then its even
		}else {
			System.out.println(b+" is odd");//otherwise it is odd
		}
	}
}
