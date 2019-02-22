//Q18. Write a program having a concrete ;subclass that inherits three abstract methods
//from a superclass. Provide the following three implementations in the subclass
//corresponding to the abstract methods in the superclass:
//1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending
//if any are found.
//2. Convert all of the lower case characters to uppercase in the input string, and
//return the result.
//3. Convert the input string to integer and add 10, output the result to the console.
//Create an appropriate class having a main method to test the above setup.

package com.revature.cja;

public class ConcreteSubClass extends AbstractSuperClass {

	// method to check if string is upper case
	@Override
	public boolean isUppercase(String str) {
		return !str.equals(str.toLowerCase());
	}

	// method to check if string is upper case
	@Override
	public String toUppercase(String str) {
		return str.toUpperCase();
	}

	// method to add 10 to a number
	@Override
	public int addTen(int num) {
		return num + 10;
	}

}
