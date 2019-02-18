package com.revature.homework1;

public class Triangle01 {
	/*
	 * class creates triangle of 0's and 1's. our first loop iterates 4 times for the amount of desired levels
	 * we then nest a for loop so we have two numbers to divide by. if there is no remainder
	 * we print a 0 if there is we print a 1
	 * 
	 * we test to see if i is greater than 2 and if it is and the numbers being divided have no remainder
	 * we print out a 1 vs the zero so our trianle would print the proper pattern
	 */

	public static void main(String[] args) {
		
		for(int i=1;i<=4;i++){
			for(int j=1;j<=i;j++){
				if(i>2) {
					if(((i + j)% 2)==0) {
						System.out.print(1);
					}else {System.out.print(0);}
				}else {
				System.out.print(((i+j)%2));}
			}
			System.out.print("\n");
		}
				}
			}
		

	

