package marquez.revature.q9;

import java.util.ArrayList;

/* Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime
 * numbers to the console.
 */

public class PrimeNumbers
{
	public static void main(String[] args)
	{
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		for(int i = 1; i<101; i++)
		{
			num.add(i);
		}
		//for loop to check if a number from numLiist is prime
		for(int i=1; i<num.size();i++)
		{
			boolean isPrime = true;
			for(int j = 2; j<i; j++)
			{
				if(num.get(i-1) % j == 0)
				{
					isPrime = false;
					break;
				}
			}
			if(i == 1)
			{
				continue;
			}
			else if(isPrime)
			{
				System.out.print(i + ", ");
			}
		}
	}
}
