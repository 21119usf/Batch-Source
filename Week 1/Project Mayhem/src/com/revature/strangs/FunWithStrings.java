package com.revature.strangs;

public class FunWithStrings {
	/*
	 * Strings!
	 * not char or Character
	 * Fully qualified class name:java.lang.String
	 * String literal is 0+ characters ex "" or String a = "Go UCF";
	 * concatenated strings w/ + or .concat()
	 * "goodbye" + " Earth"
	 * Strings are immutable
	 * String pool- collection of unique String literals
	 * in the heap memory
	 * some Strings are common and used within multiple places within our app
	 * String s = "dog"; Compiler searches "dog" in String pool
	 * if it exists, it will create a reference to it
	 * if it does not exist, it will create a new String literal in the String pool
	 * String a = "dog"; same reference as s
	 * a = a + " house";
	 * String API has utility methods!
	 * ######## Important! ########
	 * String- String Pool, Immutable, thread safe, fast
	 * Stringbuilder- No String Pool, Mutable,not thread safe, fast
	 * StringBuffer- No String Pool, Mutable, thread safe, slow
	 * ############################
	 */
	public static void main(String[] args) {
		String a = "blah";
		System.out.println(a.hashCode());
		a = "woo";
		
		System.out.println(a.hashCode());
		System.out.println(a);
		String b = "blah";
		System.out.println(b.hashCode());
		System.out.println(b);
	}

}
