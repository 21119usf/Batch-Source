package com.revature.question8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”


public class QuestionEight {

	public static void main(String[] args) {
		//creating an ArrayList and adding test letters to it
		ArrayList<String> palindromeTest = new ArrayList<>();
		ArrayList<String> palindromes = new ArrayList<>();
		palindromeTest.add("karan");
		palindromeTest.add("madam");
		palindromeTest.add("tom");
		palindromeTest.add("civic");
		palindromeTest.add("radar");
		palindromeTest.add("jimmy");
		palindromeTest.add("kayak");
		palindromeTest.add("john");
		palindromeTest.add("refer");
		palindromeTest.add("billy");
		palindromeTest.add("did");
		
		System.out.println("ArrayList of Words:");
		System.out.println(palindromeTest);
		
		palinTest(palindromeTest, palindromes);
		
		System.out.println("ArrayList of Palindromes:");
		System.out.println(palindromes);
	}
	
	//method for testing an ArrayList for palindromes
	public static void palinTest(ArrayList<String> palindromeTest, ArrayList<String> palindromes) {
		int x = palindromeTest.size();
		for (int i = 0; i < x; i++) {
			String testword;
			testword = palindromeTest.get(i);
			int testlength = testword.length();
			int j=0;
				//while j is the counting number, testlength/2 is the middle letter
				while (j <= testlength/2) {
				//left represents letters from the left, right from the right
				char left = testword.charAt(j);
				char right = testword.charAt(testlength-j-1);
				//if the letters from the left are not the same as letters from the right, it can't be a palindrome
				if (left != right) {
//					System.out.println(testword + " is NOT a palindrome");
					//we use the break command because we no longer need to check this word, so the while loop is stopped
					break;
				}
				//if all left-right pairs of letters made it through the above if statement, the middle one or two letters must be a palindrome
				else if (j==testlength/2){
					palindromes.add(testword);		//so we add to the palindrome ArrayList
					break;							//then end the while loop
				}
				else {
				//if we haven't reached the middle of the word, but so far it's a palindrome, we keep looking through the while loop
					j++;
				}	}	}
	}
	
}
