package com.revature.question10;

import java.util.Scanner;

public class QuestionTen {
//Q10. Find the minimum of two numbers using ternary operators.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer");
		int n1 = input.nextInt();
		System.out.println("Enter a second integer");
		int n2 = input.nextInt();
		
		//ternary operator; checks if n1 is less than n2. If yes, minvalue becomes n1, if no, minvalue becomes n2
		int minvalue = (n1 < n2) ? n1 : n2;
		
		//output the minimum value
		System.out.println("The minimum of the two numbers is " + minvalue);
		
	}

}
