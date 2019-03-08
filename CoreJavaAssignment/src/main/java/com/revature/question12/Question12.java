package com.revature.question12;

public class Question12 {

	//Write a program to store numbers from 1 to 100 in an array. 
	//Print out all the even numbers from the array. 
	//Use the enhanced FOR loop for printing out the numbers.
	
	public static final int n = 100;
	public static int[] list = new int[n];
	public static int[] test = new int[n];
	static Float check;
	
	public static void even(int[] a) {
		for(int i: list) {
			check = (float) test[i-1];
			check = check/2;
			test[i-1] = test[i-1]/2;
			if(check.equals((float) test[i-1])) {
				System.out.print(list[i-1] + " ");
			}
		}	
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < n; i++) {
			list[i] = i+1;
			test[i] = i+1;
		}
		
		even(list);
	}
}
