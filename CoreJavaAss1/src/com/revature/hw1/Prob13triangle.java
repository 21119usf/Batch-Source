package com.revature.hw1;

public class Prob13triangle {

	public static void main(String[] args) {
		//2 outside variables
		//z is y's limiter 
		int z=2;
		int a=1;
		//4 lines
		for (int x = 0; x < 4; x++) 
		{
			int y=1;	
			//4 digits
			//want it to loop through once, then twice, then thrice, etc.
			while (y < z) 
			{
				y++;
				a++;
				if (a%2 == 0){System.out.print(0);}
				else{System.out.print(1);}
			}
			System.out.println();
			z++;	
		}
	}
}
