package com.revature.Q8;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindromes {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(11);		//Declare arrayList of size 11
		list.addAll(Arrays.asList(new String[] {				//Populate arrayList with predetermined strings
				"karan","madam","tom","civic","radar","jimmy",
				"kayak","john","refer","billy","did"
		}));
		ArrayList<String> palindromes = palindromeFilter(list);	//Filter out palindromes and save them into arrayList
		System.out.print("All Strings: ");						//Print results
		printList(list);
		System.out.print("Palindromes: ");
		printList(palindromes);
	}
	
	/*palindrome
	 * Input	: ArrayList<String>
	 * Output	: ArrayList<String>
	 * Algo		: Create new arrayList to store plaindromes. Then loop through input list
	 * 			  and test each string for palindromeness. This is done by looping through
	 * 			  half the string and comparing the current char to its complement. If at
	 *			  any point char's dont match break the loop of the current string and continue
	 *				, if the is Palindrome flag is not tripped then add the palindrome string
	 *			  to the arrayList 
	 */
	public static ArrayList<String> palindromeFilter(ArrayList<String> list) {
		ArrayList<String> palindromes = new ArrayList<String>();
		for(String s : list) {
			int len = s.length();
			boolean isPalindrome = true;
			for(int i =0; i < len/2; i++) {
				if(s.charAt(i) != s.charAt(len-i-1)) {
					isPalindrome = false;
					break;
				}
			}
			if(isPalindrome)palindromes.add(s);
		}
		return palindromes;
	}

	public static void printList(ArrayList<String> list) {
		for(String s : list) {
			System.out.print(" "+s);
		}
		System.out.println();
	}
}
