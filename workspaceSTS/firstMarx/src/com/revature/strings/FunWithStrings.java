package com.revature.strings;

public class FunWithStrings {
	/*Strings
	 * not char or Character
	 * Fully Qualified class name:java.lang.String
	 * String literal is 0+ characters ex) "" or String a="Roll Tide";
	 * concatenate strings w/ + .concat()
	 * "goodbye" + "earth"
	 * Strings are immutable
	 * String pool- collection of unique String literals in heap memory
	 * some strings are common and used in multiple places within app
	 * String s= "dog"; Compiler searches for "dog" in the string pool
	 * if it exists, it will create a reference to it,
	 * if it does not exist, it will create a new string literal in the string pool
	 * String a= "dog"; same reference as s
	 * a = a + "house"
	 * 
	 * String API has utility methods
	 * String-        has the string pool  Immutable  Thread-safe      fast
	 * StringBuilder- no string pool       Mutable    Not Thread-safe  fast
	 * StringBuffer-  no string pool       Mutable    Thread-safe      slow
	 */
	
	public static void main(String[] args) {
		String a = "blah";
		System.out.println(a);;
		a = "woo";
		System.out.println(a);
	}
}
