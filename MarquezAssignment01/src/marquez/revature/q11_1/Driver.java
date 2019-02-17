package marquez.revature.q11_1;

import marquez.revature.q11_2.*;

/* Write a program that would access two float-variables from a class that exists in
 * another package. Note, you will need to create two packages to demonstrate the
 * solution.
 */

public class Driver {

	public static void main(String[] args) 
	{
		Floats f = new Floats();
		System.out.println("The Floating number from package marquez.revature.q11_2: " + f.f1 + " & " + f.f2);
	}

}
