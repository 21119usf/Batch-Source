package com.revature.assignment1;

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);//scanner class
		
		System.out.println("Please enter an integer: ");//prompt for int
		int a = in.nextInt();//store input from console
		System.out.println("Please enter another integer: ");//prompt for another int
		int b = in.nextInt();//store int input
		in.close();//close scanner
		
		System.out.println(findMin(a, b)+" is the minimum.");//display to called method used to find the minimum
	}

	public static int findMin(int c, int d) {	//method to find minimum
		
		return c > d ? d : c;//really this is a demonstration of using ternary operators
	}//if c is greater than d, then return d, otherwse reten c
}
