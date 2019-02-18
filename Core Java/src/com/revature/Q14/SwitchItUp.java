package com.revature.Q14;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SwitchItUp {

	public static final double NUMBER_TO_SQRT = 49;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);							//Create a scanner on console input stream
		int n = 1;
		while(n != 0) {													////Accept user input until user quits
			System.out.println("Enter number to switch on (1-3 0 to quit): ");
			n = sc.nextInt();
			switchFunc(n);
		}																//Call switch on n
		sc.close();														//Close scanner input stream
		}

	/*switchFunc
	 * Input	: int
	 * Output	: void
	 * Algo		: Simple switch parameterized on n
	 */
	public static void switchFunc(int n) {
		switch(n) {
			case 1:
				System.out.println("	The sqaure root of 25 is"+Math.sqrt(25));
				break;
			case 2:
				System.out.println("	"+LocalDateTime.now().toString());
				break;
			case 3:
				String[] splitify = "I am learning Core Java".split(" ");
				for(int i=0;i<splitify.length;i++) {
					System.out.println("	splitify["+i+"] = "+splitify[i]);
				}
				break;
			default : 
				System.out.println("Incorrect input try again");
		}
		
	}
}