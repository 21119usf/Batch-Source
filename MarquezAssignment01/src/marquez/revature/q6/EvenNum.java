package marquez.revature.q6;

import java.util.Scanner;

//Write a program to determine if an integer is even without using the modulus operator (%)

public class EvenNum 
{
	//isEven method to check if a number is even or odd
		static boolean isEven(int x)
		{
			boolean isEven = true;
			for(int i = 1; i <= x; i++)
			{
				isEven = !isEven;
			}
			return isEven;
		}
		public static void main(String[] args) 
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a number:");
			int number = scan.nextInt();
			if(isEven(number))
			{
				System.out.println(number + " is Even");
			}
			else 
			{
				System.out.println(number + " is Odd");
			}
			scan.close();
		}
}
