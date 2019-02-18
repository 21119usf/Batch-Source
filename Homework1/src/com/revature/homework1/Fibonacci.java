package com.revature.homework1;

public class Fibonacci {
	
	public static void showFibs(int a) {
		int first = 0, second = 1, sum, count = 1; //establish variables to keep track of our numbers
												   // and keep a count for our loop	
		
		if(a < 1) { //test if the input is less than one because then we wont print any numbers
			return;
		}
		
		while(count <= a) {   // while our count is less than or equal to the input we will print out the first number
		System.out.println(first);// we then add the numbers because the next fib number is the previous two numbers added
		sum = first + second;	//then we set the first value equal to the second, second equal to the two numbers added
		first = second;			//and then increment count 
		second = sum;
		count++;}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		showFibs(25); //call show fibs function
	}

}
