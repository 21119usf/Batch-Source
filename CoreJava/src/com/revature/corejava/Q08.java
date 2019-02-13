package com.revature.corejava;

import java.util.ArrayList;

// Find palindromes in an ArrayList of Strings
public class Q08 {
	// Return ArrayList of palindromes
	static ArrayList<String> getPalindromes(ArrayList<String> al) {
		ArrayList<String> result = new ArrayList<String>();
		
		for (String str : al) {
			int i=0;
			int j=str.length() - 1;
			boolean isPalindrome = true;
			while (i != j) {
				if (str.charAt(i) != str.charAt(j)) {
					isPalindrome = false;
					break;
				}
				i++;
				j--;
			}
			if (isPalindrome) {
				result.add(str);
			}
		}
		
		return result;
	}
	
	// Main
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("karan");
		al.add("madam");
		al.add("tom");
		al.add("civic");
		al.add("radar");
		al.add("jimmy");
		al.add("kayak");
		al.add("john");
		al.add("refer");
		al.add("billy");
		al.add("did");
		
		ArrayList<String> pals = getPalindromes(al);
		System.out.println(pals);
	}
}
