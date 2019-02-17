package com.revature.cja;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindromes {
	
	private ArrayList<String> al = new ArrayList<>();
	private ArrayList<String> palindromesList = new ArrayList<>();
	
	public Palindromes() {
		createStrings();
	}
	
	private void createStrings() {
		al.addAll(Arrays.asList(
			new String[] {
					new String("karan"),
					new String("madam"),
					new String("tom"),
					new String("civic"),
					new String("radar"),
					new String("jimmy"),
					new String("kayak"),
					new String("john"),
					new String("refer"),
					new String("billy"),
					new String("did"),
		}));
	}
	
	public void addPalindromees() {
		for (String s : al) {
			isPalindromees(s);
		}
	}
	
	public void displayPalindromees() {
		for (String s : palindromesList) {
			System.out.print(s + " ");
		}
	}	
	
	private void isPalindromees(String str) {
		int i = 0;
		int j = str.length() - 1;
		
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return;
			}
			i++;
			j--;
		}
		
		palindromesList.add(str);
	}
}
