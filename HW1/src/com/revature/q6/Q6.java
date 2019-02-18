package com.revature.q6;

import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		
		//Prompt for number from user
		Scanner userIntInput = new Scanner(System.in);
		System.out.println("What number do you want to check? ");
		int userNum = userIntInput.nextInt();
		
		
		//prints if its even or not depending which comparing the userNum to itself
		if(isItEven(userNum) == userNum) {
			System.out.println("The number " + userNum + " is even! :)");
		}else {
			System.out.println("The number " + userNum + " is odd :(");
		}
		
		userIntInput.close();

	}
	
	/*
	 * determines if it is evening by dividing by 2 and dropping the decimals because of strictly integers are being used
	 * then multiplying by 2
	 * 
	 * check 4  even usecase
	 * 4 / 2 = 2
	 * 2 * 2 = 4  this is even returned the same number
	 * 
	 * check 5  odd usecase
	 * 5 / 2 = 2.5
	 * 2 * 2 = 4  this is not 5 there for it is odd
	 */
	public static int isItEven(int userNum) {
		
		return (userNum/2)*2;	
	}

}
