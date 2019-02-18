package com.revature.homework1;

import java.util.ArrayList;


import com.revature.homework1.Reverse;
/*
 * the isPalindrome method takes in a string input and utilizes the reverse method made in another class
 * we set our first variable equal to the input and our second variable the input string reversed
 * we then test the strings and if the first string is equal to the second string after it has been reversed
 * then we know it is a palindrome.
 */
public class Palindrome {
	static Reverse oo = new Reverse();	
		public static boolean isPalindrome(String userInput) {
			String first, second;
			first = userInput;
			second = oo.reverseString(userInput);
			if(first.equals(second)) {
				//System.out.println(userInput+ " is a palindrome");
				return true;
			}else {
				//System.out.println(userInput + " is not a palindrome");
				return false;
			}
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	
	ArrayList<String> anArrayList = new ArrayList<String>(); //add strings to the arraylist 
	anArrayList.add("karan");
	anArrayList.add("madam");
	anArrayList.add("tom");
	anArrayList.add("civic");
	anArrayList.add("radar");
	anArrayList.add("jimmy");
	anArrayList.add("kayak");
	anArrayList.add("john");
	anArrayList.add("refer");
	anArrayList.add("billy");
	anArrayList.add("did");
	//System.out.println(anArrayList.size());
	ArrayList<String> thePalindromesArray = new ArrayList<String>();
	
	for(int i = 0; i < anArrayList.size(); i++){//loop through the arraylist of strings and test each one with the palindrom method
		if(isPalindrome(anArrayList.get(i))){
			thePalindromesArray.add(anArrayList.get(i));
		}
		
	}
	for(int i = 0; i < thePalindromesArray.size();i++) { //output the arraylist
		System.out.println(thePalindromesArray.get(i));
	}
	
	
	
	}
	
	
	

}
