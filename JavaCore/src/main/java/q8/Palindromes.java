// David Lavoie Revature Assignment 1 Q7
package q8;

import java.util.ArrayList;

public class Palindromes {

	/**
	 * palindromes adds any number of Strings to an ArrayList<String> called target,
	 * it then compares each word to see if it is a palindrome, i.e. charAt(i) = charAt(len-i-1)
	 * all words which match this criteria are returned as another ArrayList<String>.
	 * @param Target
	 * @param words
	 * @return
	 */
	static ArrayList<String> palindromes (ArrayList<String> Target, String ... words) {
		ArrayList<String> bar = new ArrayList<String>();
		for (String word : words) {
			Target.add(word);
			int len = word.length();
			for (int i = 0; i<len; i++) {
				if(word.charAt(i) != word.charAt(len-i-1)) {
					continue;
				}
				if( i == word.length() - 1) {
					bar.add(word);
				}
			}
		}
		return bar;
	}

	public static void main(String[] args) {
		String [] test = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> fu = new ArrayList<String>();
		ArrayList<String> bar = palindromes(fu, test); 
		System.out.println("All Words:\n" + fu);
		System.out.println("Palindromes:\n" + bar);
		
	}
	
}
