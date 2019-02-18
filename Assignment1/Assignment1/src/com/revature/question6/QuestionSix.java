package com.revature.question6;

import java.util.Scanner;

public class QuestionSix {

	public static void main(String[] args) {
		System.out.println("Input a number:");
		Scanner num = new Scanner(System.in);		//having user input a number
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();					//number will be input as an int
		
		int test = x/2;								//an odd int divided by 2 will round down
		if (2*test == x) {
			System.out.println(x + " is even.");	//multiplying an even by 2 will return the original
		}
		else {
			System.out.println(x + " is odd");		//multiplying an odd by two will return the rounded down multiplied by 2
		}
	}

}
