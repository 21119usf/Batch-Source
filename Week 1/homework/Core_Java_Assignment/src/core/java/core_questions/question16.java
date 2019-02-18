package core.java.core_questions;

import java.util.Scanner;

public class question16 {
	public static void main(String[] args) {
		int counter = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter String input: ");
		//input the string in the command line argument. Spaces will be removed
		args = in.nextLine().split(" ");  
		in.close();
		// then get the length of each string and sum them all
		for(String str : args) {
			counter = counter + str.length(); 
		}
		//print number of chars!
		System.out.println("The number of characters in this string is: \n" + counter);
			
	}
}
