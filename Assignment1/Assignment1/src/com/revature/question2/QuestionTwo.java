package com.revature.question2;
		//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
public class QuestionTwo {
		static int FIRSTVAL = 0;	//fibonacci requires the first two to be constants to work
		static int SECVAL = 1;
	public static void main(String[] args) {
		int sum = 0;		//sum variable, initialized at 0
		int x = 0;			//alternating even and odd values for sequence
		int y = 0;
		//printing the title and n=1 and n=2
		System.out.println("Fibonacci Sequence up to n = 25:");
		System.out.print(FIRSTVAL + ", " + SECVAL);
		for (int i = 1; i <= 23; i++) {
			//n=3 uses the previous 2 constants
			if (i == 1) {
				sum = FIRSTVAL + SECVAL;
				x = sum;
				System.out.print(", " + x);
			}
			//n=4 uses one of the two constants
			else if (i == 2) {
				sum = SECVAL + x;
				y = sum;
				System.out.print(", " + y);
			}
			//all other odd n-values
			else if (i%2 != 0) {
				sum = x + y;
				x = sum;
				System.out.print(", " + x);
			}
			//all other even n-values
			else {
			sum = x + y;
			y = sum;
			System.out.print(", " + y);
			}	
		}
	}

}
