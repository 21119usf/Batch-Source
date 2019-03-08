package com.revature.question6;

import java.util.Scanner;

public class Question6 {

	//Write a program to determine if an integer is even 
	//without using the modulus operator (%)
	
	static Scanner input = new Scanner(System.in);
	static Float number;
	static int store;
	
	
	public static void even(int a) {
		number = (float) store;
		number = number/2;
		store = store/2;
		if(number.equals((float) store)) {
			System.out.println("The integer is even.");
		}else {
			System.out.println("The integer is odd.");
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter number: ");
		store = input.nextInt();
		even(store);
		
	}
}
