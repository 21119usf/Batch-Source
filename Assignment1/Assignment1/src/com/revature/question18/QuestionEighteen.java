package com.revature.question18;

import java.util.Scanner;

/*
Q18. Write a program having a concrete ;subclass that inherits three 
abstract methods from a superclass. Provide the following three implementations 
in the subclass corresponding to the abstract methods in the superclass:

1.          	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
2.          	Convert all of the lower case characters to uppercase in the input string, and return the result.
3.          	Convert the input string to integer and add 10, output the result to the console.
Create an appropriate class having a main method to test the above setup.
*/
public class QuestionEighteen extends AbstractSuperclass{

	public static void main(String[] args) {
		//initialize the Abstract class as one called string
		AbstractSuperclass string = new QuestionEighteen();
		//printing out the return boolean value
		System.out.println(string.uppercaseBoolean());
		//printing out the return uppercase String
		System.out.println(string.lowerToUpper());
		//running the String-to-int subclass
		string.strToInt();

	}
	//implementing the subclasses
public boolean uppercaseBoolean() {
	//ability to input a string
		System.out.println("Input a String: ");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		//if/then statement to determine if there are uppercase in the String
		//returns boolean answer
		if (str == str.toLowerCase()) {
			return true;
		}
		else {
			return false;
		}
	}

	public String lowerToUpper() {
		//input String
		System.out.println("Input a String: ");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		//converting the string to uppercase
		String upperstr = str.toUpperCase();
		//returning the uppercase
		return upperstr;
	}

	@Override
	public void strToInt() {
		//input a number as a String
		System.out.println("Input a number: ");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		//using the parseInt method to convert the String to an int
		int num = Integer.parseInt(str);
		//print out the int
		System.out.println(num);
	}

}
