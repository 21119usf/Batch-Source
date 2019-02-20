package com.revature.project0.main;

import java.util.Scanner;

import com.revature.project0.classes.DataIO;
import com.revature.project0.views.ViewController;

public class Main 
{

	public static void main(String[] args) 
	{	
		DataIO dataIO = new DataIO();
		
		dataIO.importData();
		
		ViewController viewController = new ViewController();
		
		viewController.start();
		
		dataIO.exportData();
	}
}
