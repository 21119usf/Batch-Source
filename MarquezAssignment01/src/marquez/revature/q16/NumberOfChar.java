package marquez.revature.q16;


/* Write a program to display the number of characters for a string input. The string
 * should be entered as a command line argument using (String [ ] args).
 */

public class NumberOfChar {

	public static void main(String[] args) 
	{
		System.out.println(args[0]);
		int total=0;
		for(int i =0; i<args[0].length();i++)
		{
			total++;
		}
		System.out.println("The total number of characters is " + total);
	}

}
