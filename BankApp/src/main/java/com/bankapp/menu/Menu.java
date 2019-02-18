package com.bankapp.menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<String> items;
	
	// Constructor
	public Menu(ArrayList<String> al) {
		items = al;
	}
	
	// Display menu
	public int display() {
		int option = 0;
		boolean notValidOption = true;

		do {
			// Display menu
			int count = 0;
			System.out.println();
			for (String item : items) {
				System.out.println(count + ". " + item);
				count++;
			}
			System.out.print(">>> ");
			
			// Get input
			if (sc.hasNextInt()) {
				option = sc.nextInt();
				sc.nextLine();    // Clear buffer
				if (option < 0 || option > items.size()) {
					System.out.println("Invalid option");
					continue;
				}
				notValidOption = false;
			} else {
				System.out.println("Invalid option");
				sc.nextLine();
			}
		} while (notValidOption);
		
		return option;
	}
}
