package com.revature.assignment1;

import java.util.ArrayList;

public class Q8 {
	public static void main(String[] args) {
		
		String[] arr = {"karan", "madam", "tom", "civic", "radar", 
				"jimmy", "kayak", "john", "refer", "billy", "did"};//hard code the strings as instructed but into string array first
		splitArray(arr);//call to method passing array
	}
	//method used to split the strings into array lists, one of which are for all words, the other are for palindrome
	public static void splitArray(String[] words) {
		ArrayList<String> allWords = new ArrayList<>();//all words array list
		ArrayList<String> palindromeWords = new ArrayList<>();//palindrome arraylist
		
		for(String x : words) {//enhanced for loop to add each fo the words to the arraylist
			allWords.add(x);
		}
		int a = allWords.size();//var to find size of arraylist
		//for loop from 0 to size of array list to chck for palindrome
		for(int i=0;i<a;i++) {
			if(checkForPalindrome(allWords.get(i))) {//iterate through all words arralist  to call method for each word
				palindromeWords.add(allWords.get(i));//if it comes back as true, it is added to the palindrome words arraylist
			}
		}
		System.out.println(palindromeWords);//diplay the palindrom arraylist

	}
	
	//method to check for palindrome returning only true or false
	public static boolean checkForPalindrome(String a) {
		
		int b = a.length();//length
		int c = 0;//initialize counter
		
		while(c<b/2) {//while counter is less than half the string length
			if(a.charAt(c) != a.charAt(b-1-c)) {//comparing the first and last letter of word using charAt
				return false;//if they don't match return false
			}
			c++;//go to the next char
		}
		if(c==b/2)
			return true;//return true if we make it to the middle of the word
		return false;//false if we don't
	}
}
