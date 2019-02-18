package com.revature.homework1;
import java.util.ArrayList;

public class Q8_Palindrome {
	// initial ArrayList 
	ArrayList<String> str = new ArrayList<String>();

	// find Palindromes Method
	public ArrayList<String> Palindrome() {
		// new ArrayList to hold Palindromes
		ArrayList<String> pal = new ArrayList<String>();
		// search for Palindromes
		for (int n=0; n<str.size();n++) {
			// need mutable string to test by reveral
			StringBuilder sb = new StringBuilder(str.get(n));
			// check if inital word = reverse word
			if(str.get(n).equals(sb.reverse().toString())) {
				pal.add(str.get(n)); // add if so
			}
		}
		return pal;	// return palindrome array
	}
	public static void main(String[] args) {
		// access Palindrome method
		Q8_Palindrome list = new Q8_Palindrome();
		// define initial string to add to ArrayList
		String[] s = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "bill", "did"};
		//fill ArrayList
		for(int i = 0; i<s.length; i++) {
			list.str.add(s[i]);
		}
		
		// print results
		System.out.println("Unfiltered Array: " + list.str);
		System.out.println("Palindrome Filtered Array: " + list.Palindrome());
	}
//	l1.add("karan");
//	l1.add("madam");
//	l1.add("tom");
//	l1.add("civic");
//	l1.add("radar");
//	l1.add("jimmy");
//	l1.add("kayak");
//	l1.add("john");
//	l1.add("refer");
//	l1.add("billy");
//	l1.add("did");
}
