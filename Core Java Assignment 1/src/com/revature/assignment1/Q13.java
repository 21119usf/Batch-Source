package com.revature.assignment1;

public class Q13 {

	public static void main(String[] args) {
			displayTriangle();//display triangle
		}
	
	public static void displayTriangle() {
		String binary = Integer.toBinaryString(682);//decided to use decimal value 682 which corolates to the 0's and 1's in assignment
		int length = binary.length();//record length and save
		int k=0;//a counter
		
		//for loop up to size 4 sinc there will be four lines
		for(int i=0;i<4;i++) {
			int j=0;
			while(j <= i) {//while j is less than or equal to i we print the values
				System.out.print(binary.charAt(length - (k) - 1));
				j++;//increment
				k++;//increment
			}
			System.out.println();
		}
	}
}
