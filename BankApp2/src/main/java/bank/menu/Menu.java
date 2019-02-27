package bank.menu;

import java.util.Scanner;

public class Menu implements Display
{
	Scanner scan = new Scanner(System.in);
	@Override
	public void display() 
	{
		System.out.println("Please Select An Option");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("(Press Any Number besides 1 & 2 to Leave");
		int choice = scan.nextInt();
		switch(choice)
		{
			case 1:
				new Login().display();
				break;
			case 2:
				new Register().display();
				break;
			default:
				System.out.println("Have a nice day");
				System.exit(0);
		}
	}
	
}
