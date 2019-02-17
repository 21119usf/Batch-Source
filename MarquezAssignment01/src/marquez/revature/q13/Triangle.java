package marquez.revature.q13;

/* Display the triangle on the console as follows using any type of loop. Do NOT use a
 * simple group of print statements to accomplish this.
 * 0
 * 1 0
 * 1 0 1
 * 0 1 0 1
 */
public class Triangle 
{
	public static void main(String[] args)
	{
		boolean previous = false;
		// for loop to print out the triangle
		for(int i=1; i<=4; i++)
		{
			// for loop to check if the previous number is 1 or 0
			for(int j=0; j<i; j++)
			{
				// if previous is 0 then prints 1 else prints 0
				if(previous)
				{
					System.out.print("1 ");
					previous=false;
				}
				else
				{
					System.out.print("0 ");
					previous=true;
				}		
			}
			System.out.println();
		}
	}

}
