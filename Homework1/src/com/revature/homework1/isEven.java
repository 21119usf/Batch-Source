package com.revature.homework1;

public class isEven {
	/*
	 * 5 - 0101                                 4 - 0100
	 * 1 - 0001  five is odd because 1 and 1    1 - 0001 four is even because 0 and 1 is 0
	 * this method uses a bitwise function to compare test if a number is even or odd 
	 * by testing the binary representation of the number supplied. 
	 */
	
	
	public static void youEven(int n) {
		 if((n & 1) == 0) {
			 System.out.println(n+ " is even");
		 }else{
			 System.out.println(n+  " is odd");
		 };
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			youEven(5);
			youEven(4);
	}

}
