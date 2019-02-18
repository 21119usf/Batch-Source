package com.revature.assignment1;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);//used scanner class for input from console
		System.out.println("Enter an integer to find the factorial of: ");
		int n = in.nextInt();//take in put store as n
		findFactorial(n);//calll find factorial method passing n
		in.close();//close
		
	}
	//method used to find factorial
	public static void findFactorial(int b) {
		
		int a=b;//save parameter to int a
		
		for(int i=b;i>1;i--) {//for loop setting counter at integer value and decrementing
			a=a*(i-1);//finding product of next smaller value and current value
		}
		System.out.println(a);//display of the result
	}

}
