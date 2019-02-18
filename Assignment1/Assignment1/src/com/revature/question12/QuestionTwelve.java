package com.revature.question12;


//Q12. Write a program to store numbers from 1 to 100 in an array. 
//Print out all the even numbers from the array. Use the enhanced 
//FOR loop for printing out the numbers.

public class QuestionTwelve {
	//MAXNUM is a constant that represents the highest number
	static int MAXNUM = 100;
	//initializing the arrays; evenArray is half the size of numArray because it only contains even values
	static int[] numArray = new int[MAXNUM];
	static int[] evenArray = new int[MAXNUM/2];
	
	
	public static void main(String[] args) {
		//populating numArray
		for (int i = 1; i <= MAXNUM; i++) {
			int j=i-1;
			numArray[j]=i;
		}
		//populating evenArray
		int j=0;
		for (int i = 0; i < MAXNUM; i++) {
			//using modulus to ensure only even values
			if (numArray[i]%2 == 0) {
				evenArray[j] = numArray [i];
				j++;
			}
		}
		//printing out results
		System.out.println("Even numbers from 1 to " + MAXNUM + ":");
		//enhanced FOR loop for printing out values
		for (int k : evenArray) {
		System.out.println(k);
		}
	}

}
