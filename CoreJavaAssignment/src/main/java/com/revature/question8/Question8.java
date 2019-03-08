package com.revature.question8;

import java.util.ArrayList;
import java.util.Iterator;

public class Question8 {

	//Write a program that stores the following 
	//strings in an ArrayList and saves all the 
	//palindromes in another ArrayList.
	//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, 
	//“kayak”, “john”,  “refer”, “billy”, “did”

	static ArrayList<String> words = new ArrayList<>();
	static ArrayList<String> palindromeList = new ArrayList<>();
	
	public static void palindrome(String a) {
		for(int i = 0; i != a.length()/2; i++) {
			boolean check = true;
			char c1 = a.charAt(i);
			char c2 = a.charAt(a.length() - 1 - i);
			
			if(c1 != c2) {
				check = false;
			}
			if(check == false) {
				return;
			}
			
		}
		palindromeList.add(a);
		
	}
	
	
	public static void main(String[] args) {
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		
		System.out.println("Contents of original ArrayList: ");
		Iterator<String> itr = words.iterator();
		while (itr.hasNext()){
			String element = itr.next();
			palindrome(element);
			System.out.print(element + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Contents of palindrome ArrayList: ");
		Iterator<String> itr2 = palindromeList.iterator();
		while (itr2.hasNext()){
			String element = itr2.next();
			System.out.print(element + " ");
		}
	}
}
