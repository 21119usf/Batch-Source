//Our current package
package core.java.core_questions;
//Import Scanner class
import java.util.Scanner;
//our class
public class question3 {
	//constructor
	question3(){
		super();
	}
	//our static method to reverse strings
	public static String reverseString(String str, int len) {
		if(len == 0)
				return "";
		return "" + str.charAt(len-1) + reverseString(str, len-1); 
	}
	//our main method 
	public static void main(String[] args) {
		//input a word 
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter word to be reversed: ");
		String word = in.nextLine(); 
		//print the word implemented and its reversed version
		System.out.println("Reversed of " + word + " ==> " + reverseString(word, word.length()));
		in.close(); 
	}
}
