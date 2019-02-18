package com.revature.question4;

import java.util.Scanner;

public class QuestionFour {

	public static void main(String[] args) {
		Scanner inPut = new Scanner(System.in);
		System.out.println("Input the integer you wish to find the factorial of:");
		
		int n = inPut.nextInt();
		int product = 1;
		for (int i = 1; i <= n;i++) {
			product = product * i;
		}
		System.out.print(n + "! = ");
		System.out.println(product);
		
	}

}
