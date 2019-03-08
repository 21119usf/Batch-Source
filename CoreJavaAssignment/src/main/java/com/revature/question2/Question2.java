package com.revature.question2;

public class Question2 {

	//Write a program to display the first 25 Fibonacci numbers beginning at 0.
		static int first = 0;
		static int second = 1;
		static int currentNumber;
		
		public static void fibonacci(int a) {
			for(int i = 0; i < a; i++) {
				if(i == 0) {
					System.out.print(first + " ");
					continue;
				}
				if(i == 1) {
					System.out.print(second + " ");
					continue;
				}
				currentNumber = first + second;
				first = second;
				second = currentNumber;
				System.out.print(currentNumber + " ");
			}
		}
		
		public static void main(String[] args) {
			
			fibonacci(25);
		}

}
