package marquez.revature.q5;

import java.util.Scanner;

/* Write a substring method that accepts a string str and an integer idx and returns the
 * substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing
 * substring methods in the String, StringBuilder, or StringBuffer APIs.
 */

public class StringCutOff 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//str will be used to get a string from the user
		System.out.println("Give me a word:");
		String str = scan.nextLine();
		//idx will be used to get a number from the user
		System.out.println("Give me a number:");
		int idx = scan.nextInt();
		//substr will be blank until it adds the char from str
		String substr ="";
		/*loops until index i is greater than the idx value
		 *substr will have char added until the loop is finished
		 */
		for(int i = 0; i<idx; i++)
			substr = substr + str.charAt(i);
		System.out.println("The substring is " + substr);
		scan.close();
	}
}
