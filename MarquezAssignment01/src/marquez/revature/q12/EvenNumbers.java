package marquez.revature.q12;

/* Write a program to store numbers from 1 to 100 in an array. Print out all the even
 * numbers from the array. Use the enhanced FOR loop for printing out the numbers.
 */

public class EvenNumbers 
{
	public static void main(String[] args) 
	{
		int[] numArray = new int[101];
		//for loop to insert int variables in an array
		for(int i = 1; i<=100; i++)
		{
			numArray[i] = i;
		}
		//for loop that checks every index in the array and prints out all the even numbers
		for(int i : numArray)
		{
			if(numArray[i] % 2 == 0)
			{
				System.out.println(i);
			}
		}		
	}
}
