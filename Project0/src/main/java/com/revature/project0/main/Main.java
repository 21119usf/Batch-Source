package com.revature.project0.main;

import java.util.Scanner;

import com.revature.project0.classes.Customer;
import com.revature.project0.classes.DataIO;
import com.revature.project0.views.ViewController;

public class Main 
{

	public static void main(String[] args) 
	{	
		DataIO dataIO = new DataIO();
		
		ViewController viewController = new ViewController();
		
		dataIO.importData();
		
		viewController.start();
	}
}
