package first.half;

import java.util.ArrayList;

public class Palindromes {

	public static ArrayList<String> getPalimdromes(ArrayList<String> strarl) {
		
		ArrayList<String> resultArray = new ArrayList<String>();
		
		for(String str : strarl) {
			if(isPalimdrome(str)) {
				resultArray.add(str);
			}
		}
		
		return resultArray;
	}
	
	public static boolean isPalimdrome(String strar) {
		if(strar.equals(ReverseString.reverseString(strar))) { //ReverseString is the answer to a previous Question
			return true;
		}
		return false;
	}
}
