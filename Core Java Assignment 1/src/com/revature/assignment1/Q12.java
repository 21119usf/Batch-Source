package com.revature.assignment1;

public class Q12 {

	public static void main(String[] args) {
		
		int[] numbers = new int[100];//array of size 100
		
		for(int i=0;i<100;i++) {//for loop iterating through array starting with 1 inputting into array
			numbers[i]=i+1;
		}
		
		for(int x : numbers) {//using enhanced for loop,
			if(x%2==0) {		//with this simple if and modulo we are able to print all even numbers if there is no remainder
				System.out.println(x);//display
			}
		}
	}
}
