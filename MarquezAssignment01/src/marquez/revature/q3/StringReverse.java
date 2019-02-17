package marquez.revature.q3;

import java.util.Scanner;

/* Reverse a string without using a temporary variable. Do NOT use reverse() in the
 * StringBuffer or the StringBuilder APIs.
 */

public class StringReverse
{
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Give me a word:");
		String str = scan.nextLine();
		String reverse = "";
		for(int i = str.length()-1; i>=0; i--)
			reverse = reverse + str.charAt(i);
		System.out.println("The reverse word for " + str + " is " + reverse);
	}
}
