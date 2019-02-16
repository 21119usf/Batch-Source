package homework1;
//DONE
import java.util.ArrayList;

public class Q08 {
	//Write a program that stores the following strings in an ArrayList
	//and saves all the palindromes in another ArrayList.
	//�karan�, �madam�, �tom�, �civic�, �radar�, �jimmy�, �kayak�, �john�,  �refer�, �billy�, �did�
	public static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		boolean isPalindrome = true;
		while (start < end) {
			if (str.charAt(start++) != str.charAt(end--)) {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}
	
	public static void main(String[] args) {
		String[] array = {"karan", "madam", "tom", "civic", "radar", "jimmy",
							"kayak", "john", "refer", "billy", "did"};
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for (String s: array) {
			strings.add(s);
			if (isPalindrome(s))
				palindromes.add(s);
		}
		
		for (String s: strings)
			System.out.print(s + " ");
		System.out.println();
		for (String s: palindromes)
			System.out.print(s + " ");
	}
}
