package marquez.revature.q8;

import java.util.ArrayList;

/* Write a program that stores the following strings in an ArrayList and saves all the
 * palindromes in another ArrayList.
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did” 
 */

public class Palindrones 
{
	public static void main(String[] args) 
	{
		String str, reverse = "";
		ArrayList<String> list = new ArrayList<String>();
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
		ArrayList<String> palindromes = new ArrayList<String>();
		
		//for loop to check if a word is a palindrome
		for(int i=0; i<list.size();i++)
		{
			str = list.get(i);
			int length = str.length();
			for(int j = length-1; j >=0; j--)
			{
				reverse = reverse + str.charAt(j);
			}
			if(str.equals(reverse))
			{
				palindromes.add(str);
			}
			reverse="";
		}
		for(int i = 0; i<palindromes.size(); i++)
		{
			System.out.println(palindromes.get(i));
		}
	}
}
