package com.revature.even;

public class Even {

	public static void main(String[] args) {
		//this is the integer is will check
		int n = 23;
		//if statement on what to display
		if(isEven(n))
			System.out.println("Even");
		else
			System.out.println("Odd");
	}
	//boolean to know whether it is true or false
	static boolean isEven(int n) {
		boolean isEven = true;
		//for loop
		for(int i=1; i <= n; i++)
			isEven = !isEven;
		//this will return the statement
		return isEven;
	}

}
