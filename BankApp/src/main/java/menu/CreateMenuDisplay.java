package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateMenuDisplay 
{
	private Scanner scan = new Scanner(System.in);
	private ArrayList<String> items;
	
	// Constructor
	public CreateMenuDisplay(ArrayList<String> al) 
	{
		items = al;
	}
	
	// Display menu
	public int display() 
	{
		int choice = 1;
		boolean notValidOption = true;
		do 
		{
			// Display menu
			int count = 1;
			for (String item : items) 
			{
				System.out.println(count + ". " + item);
				count++;
			}
			// Get input
			if (scan.hasNextInt()) 
			{
				choice = scan.nextInt();
				scan.nextLine();    // Clear buffer
				if (choice <= 0 || choice > items.size()) 
				{
					System.out.println("Invalid option");
					continue;
				}
				notValidOption = false;
			} 
			else
			{
				System.out.println("Invalid option");
				scan.nextLine();
			}
		}
		while (notValidOption);
		
		return choice;
	}
}
