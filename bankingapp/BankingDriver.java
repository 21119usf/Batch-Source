package bankingapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BankingDriver {
	static List<String>readFiler = new ArrayList<String> ();
static void menu1(int x) throws IOException {
	
	switch(x) {
	//checks the customer class
	case 1: 
		System.out.println("You entered the Customer class");
		System.out.println("New Customers, Press 1. Returning Customers, Press 2.");
		Scanner userInput2 = new Scanner(System.in);
		//Scanner userInput3 = new Scanner(System.in);
		String v =userInput2.nextLine();
		// Map<Integer, String> mapA = new HashMap<Integer, String>();
		List<String> newCust = new ArrayList<String>();
		
		boolean login = true;
		//boolean f = false;
		String userd;
		String passer;
		//userInput2.close();
		if(v.equals("1"))
		{
			System.out.println("you have entered case 1");
			Customer g = new Customer();
			  g.accountOpen();
			System.out.println(newCust.toString());
			//int randomID = g.indentify();
			//mapA.put(randomID, g.passWord());
			//System.out.println(Arrays.asList(mapA));
			
		}
		
		 if(v.contentEquals("2")) {
		System.out.println("Enter your user name ");
		String t =userInput2.nextLine();
		
		System.out.println("Enter your password ");
		String k =userInput2.nextLine();	
			//check hashmap or file for values 
			userd = t;
			String userCheck = readFiler.get(0);
			passer = k;
			String passCheck = readFiler.get(1);
		
			//will be compared to the string value saved
			if((userCheck.equals(userd)) & (passCheck.equals(passer)) ) {
				boolean c = login;
				BankingFunctions.entry();
				//System.out.println("You have successfully logged in. ");
			}
			
			else {
				menu1(1);
			}
		
		}
		
		
		
		//call customer class
		break;
	case 2:
		// call employee class
		break;
	case 3:
		//call admin class
		break;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

static void fileReader(File x) throws FileNotFoundException {
		
	Scanner read = new Scanner (x);
	read.useDelimiter(":");
	String userName;
	while (read.hasNext())
	{
	   userName = read.next();
	   readFiler.add(userName);
	  // password = read.nextLine();
	  // name = read.nextLine();
	  //social = read.nextLine();
	   
	  //cus System.out.println(userName  + "\n"); // just for debugging
	}
	read.close();
	
		//System.out.println(readFiler.toString());
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File customer = new File("customer.txt");
		fileReader(customer);
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome, are you a Customer, Admin, or Employee?");
		String q =userInput.nextLine();
		//takes in
		String h = q.toLowerCase();
		if (h.equals("customer") ) {
			menu1(1);
		}
		else if (h.equals("Employee")) {
			menu1(2);
		}
		
		else if (h.equals("Admin")) {
			menu1(3);
		}
		//Write condition to check if user number is not the values above and get them to enter a new input
		
		
		
		userInput.close();
		
		
	}

}
