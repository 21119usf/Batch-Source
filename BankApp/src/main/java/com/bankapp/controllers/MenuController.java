package com.bankapp.controllers;

import java.util.ArrayList;

import com.bankapp.menu.Menu;

public class MenuController {
	// Display landing page and get desired option
	public static int displayLanding() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Exit");
		al.add("Customer");
		al.add("Employee");
		Menu m = new Menu(al);
		int option = m.display();
		
		return option;
	}
}
