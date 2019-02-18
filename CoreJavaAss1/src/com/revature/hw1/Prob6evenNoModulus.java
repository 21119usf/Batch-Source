package com.revature.hw1;

public class Prob6evenNoModulus {

	//boolean used to test if number passed is even
	//isEven's parameter becomes true or false
	static boolean isEven(int n) {
		return ((n/2) *2 ==n);
	}
	
	//driver
	public static void main(String[] args) {
		//number being used
		int n = 69;
		//if true == true then its even
		if(isEven(n) ==true)
			System.out.println("Even");
		else
			System.out.println("Odd");
		

	}

}
