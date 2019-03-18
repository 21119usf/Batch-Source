package com.revature.assignment1;

import java.util.Scanner;

public class Q18 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);//open scanner class
		System.out.println("Enter input string: ");//prompt for string
		String inputString = in.nextLine();//read and store string
		
		Q18sub driver = new Q18sub();//create new Q18 object
		
		driver.checkForUppercase(inputString);//call to check for uppercase
		driver.convertToLower(inputString);//call to convert any of the uppercase to lower
		driver.convertToInt(inputString);//call to convert any integer string into int plus 10
	}

}
