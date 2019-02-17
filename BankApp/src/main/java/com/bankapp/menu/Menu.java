package com.bankapp.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
		
		int count = 0;
		do {
			// Display menu
			for (String item : items) {
				System.out.println(count + ". " + item);
				count++;
			}
			System.out.print(">>> ");
			
			// Get input
			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid option. Try again.");
				sc.nextLine();
			}
			if (option >=0 && option < items.size()) {
				notValidOption = false;
				sc.nextLine();	// Clear buffer
			} else {
				System.out.println("Invalid option. Try again.");
			}
		} while (notValidOption);
		
		return option;
	}
}
