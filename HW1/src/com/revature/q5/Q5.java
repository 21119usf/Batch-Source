package com.revature.q5;

import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {
		
		//Prompt for word
		Scanner userStringInput = new Scanner(System.in);
		System.out.println("Input a word: ");
		String userWord = userStringInput.nextLine();
		
		//prompt for how many letters to print from the word
		Scanner userIntInput = new Scanner(System.in);
		System.out.println("Input the number letters you want printed from the word you just typed: ");
		int numberOfLetters = userIntInput.nextInt();
		
		//sub String method
		subString(userWord, numberOfLetters);
		
		
		//closing the scanners
		userStringInput.close();
		userIntInput.close();
		

	}

	private static void subString(String userWord, int numberOfLetters) {
		
		//converts string to character array
		char[] userWordArr = userWord.toCharArray();
		
		
		//print letters of the array depending on how many the user wants
		for(int i = 0; i <= numberOfLetters-1; i++) {
			System.out.print(userWordArr[i]);
		}
		
	}

}
