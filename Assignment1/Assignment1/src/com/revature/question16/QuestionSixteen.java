package com.revature.question16;
//Q16. Write a program to display the number of characters for a 
//string input. The string should be entered as a command line 
//argument using (String [ ] args).
public class QuestionSixteen {

	public static void main(String[] args) {
		//making the command-line arguments into a string
		String input = args[0];
		//finding the length of the argument
		int length = input.length();
		//outputting the length of the string
		System.out.println("The length of the input String is " + length + " characters.");
	}

}
