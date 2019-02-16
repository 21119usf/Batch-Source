package com.revature.core.homework;

import java.util.ArrayList;
// #8
public class Palindromes {
	public static ArrayList<String> getPalindromesFromList(String[] cases) {
		// ArrayList populated from users input
		ArrayList<String> inputs = new ArrayList<String>();
		// ArrayList of Palindromes from users input
		ArrayList<String> outputs = new ArrayList<String>();
		// populate inputs
		for (String x : cases) {
			inputs.add(x);
		}
		// check if input is palindrome if it is store in outputs
		for (int i =0; i < inputs.size(); i++) {
			String element = inputs.get(i);
			if (element.equals(new StringBuilder(element).reverse().toString())) {
				outputs.add(element);
			}
		}
		return outputs;
	}

	public static void main(String[] args) {
		String[] cases = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		System.out.println(Palindromes.getPalindromesFromList(cases));
	}
}
