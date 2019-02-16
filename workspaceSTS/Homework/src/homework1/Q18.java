package homework1;

import OtherPackage.StringProcessor;

public class Q18 {
	//Write a program having a concrete subclass that inherits three abstract methods
	//from a superclass. Provide the following three implementations in the subclass
	//corresponding to the abstract methods in the superclass:
	// 
	//1.Check for uppercase characters in a string, and return �true� or �false�
	//	depending if any are found.
	//2.Convert all of the lower case characters to uppercase in the input string,
	// 	and return the result.
	//3.Convert the input string to integer and add 10, output the result to the console.
	//Create an appropriate class having a main method to test the above setup.
	
	public static void main(String[] args) {
		StringProcessor process = new StringProcessor();
		String phrase1 = "Seraph";
		String phrase2 = "oblivious";
		String num = "23";
		System.out.println("The term '" + phrase1 + "' has at least one uppercase letter: "
							+ process.anyUpperCase(phrase1));
		System.out.println("The term '" + phrase2 + "' has at least one uppercase letter: "
				+ process.anyUpperCase(phrase2));
		System.out.println("Converting '" + phrase1 + "' to all uppercase: "
							+ process.convertToUpperCase(phrase1));
		System.out.println("Parsing the string '" + num + "' into a number and adding 10: "
							+ process.add10(num));
	}
}
