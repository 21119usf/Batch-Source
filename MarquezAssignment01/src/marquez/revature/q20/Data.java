package marquez.revature.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

/*Create a notepad file called Data.txt and enter the following:
 *Mickey:Mouse:35:Arizona
 *Hulk:Hogan:50:Virginia
 *Roger:Rabbit:22:California
 *Wonder:Woman:18:Montana
 *Write a program that would read from the file and print it out to the screen in the
 *following format:
 *Name: Mickey Mouse
 *Age: 35 years
 *State: Arizona State
 */

public class Data 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		String str;
		StringTokenizer strTok = null;
		// try-catch block to read the Data.txt file. Catches whether or not a Data.txt is found.
		try
		{
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("Data.txt"));
			
			//while loop to print out the results and a nested while loop for other print outs
			while((str = br.readLine()) != null)
			{
				strTok = new StringTokenizer(str, ":");
				System.out.println("Name:" + strTok.nextToken() + " " + strTok.nextToken());
				
				while(strTok.hasMoreTokens())
				{
					System.out.println("Age:"  + strTok.nextToken() +"\nState:" + strTok.nextToken());
				}
				System.out.println("============================");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
