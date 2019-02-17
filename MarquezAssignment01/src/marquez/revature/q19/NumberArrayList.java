package marquez.revature.q19;

import java.util.ArrayList;

/* Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add
 * all the even numbers up and display the result. Add all the odd numbers up and display
 * the result. Remove the prime numbers from the ArrayList and print out the remaining
 * ArrayList.
 */

public class NumberArrayList 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> numList = new ArrayList<Integer>();
		numList.add(1);
		numList.add(2);
		numList.add(3);
		numList.add(4);
		numList.add(5);
		numList.add(6);
		numList.add(7);
		numList.add(8);
		numList.add(9);
		numList.add(10);
		
		int odd = 0;
		int even = 0;
		
		//for loop to add all the even numbers within the Array List
		for(int i = 0; i<10;i++)
		{
			if(numList.get(i) % 2 == 0)
			{
				even += numList.get(i);
			}
		}
		System.out.println(even);
		
		//for loop to add all the odd numbers within the Array List
		for(int i = 0; i<10;i++)
		{
			if(numList.get(i) % 2 != 0)
			{
				odd += numList.get(i);
			}
		}
		System.out.println(odd);
		
		//for loop to check if a number from numLiist is prime
		for(int i=1; i<numList.size();i++)
		{
			boolean isPrime=true;
			for(int j=2; j<i; j++)
			{
				if(numList.get(i-1) % j == 0)
				{
					isPrime = false;
					break;
				}
			}
			if(isPrime)
			{
				numList.remove(i-1);
			}
		}
		for(int i=0; i<numList.size();i++)
		{
			System.out.print(numList.get(i)+", ");
		}		
	}
}
