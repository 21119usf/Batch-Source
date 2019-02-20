package bankingapp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public abstract class  BankEssentials {
//***define these methods 
	protected abstract String passWord();
	protected abstract String userName();
	protected abstract String name();
	protected abstract String socialSec();
	protected abstract int indentify();
	
	
}
// Customer class here **************************************
class Customer extends BankEssentials{
// Save Customer information to a file, make it serializable 
	//** read from stored data file 
	static  Scanner input = new Scanner(System.in);
	protected List<Customer>  accountOpen() throws IOException {
		//asks user if they want to open an account if yes go through registration variables if no tell them to have a nice day
		//Also ask if they have an account open already 
		// good place for menu-- switch case 
		System.out.println("Would you like to open an account today? "+"Yes or No?");
		;
		 String y = input.nextLine();
		 String g = y.toLowerCase();
	
		 
		if (g.equals("yes"))
		 {
			List<String> accountInfo = new ArrayList<String>();
			//adding customer info to an arrayList
		 accountInfo.add(userName());	
		 accountInfo.add(passWord());
		 accountInfo.add(name());
		 accountInfo.add(socialSec());
		 
		 FileWriter writer = new FileWriter("customer.txt",true); 
		 for(String str: accountInfo) {
	
		   writer.write(str + ":");
		   
		  
		 }
		 writer.write("\n");
		 writer.close();
		 System.out.println("Your account is set up successfully, You may now log-in");
		  BankingDriver.menu1(1);
		 return accountInfo;
		
		 }
		
		else {
			BankingDriver.menu1(1);
		}
		
		return null;
		
		
	}
	
	
	@Override
	
	public String passWord() {
		// TODO Auto-generated method stub
		//generate a password with input from user
		//creates a new password 
		System.out.println("Enter a password with 7-10 characters");
		
		 String y = input.nextLine();
		
		return y;
	}

	@Override
	public String userName() {
		// TODO Auto-generated method stub
		System.out.println("Enter a Username");
		
		 String uname = input.nextLine();
		
		 // store value uname in map
		 return uname;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		System.out.println("Enter Your  Full name");
		
		 String name = input.nextLine();
		
		 return name;
		 //store value in map
	}

	@Override
	public String socialSec() {
		// TODO Auto-generated method stub
		System.out.println("Enter a Social security Number with no dashes");
		 
		 String social = input.nextLine();
		 //check if value is correct number of characters
		
		 //store value in map
		return social;
	}

	@Override
	protected int indentify() {
		// TODO Auto-generated method stub
		//creates new random id number with 4 digits and returns the id number to be used
		Random x = new Random();
	
		int idNum = x.nextInt(10000);
		//System.out.printf("%04d", x.nextInt(10000));
		//store value in map
		int y = idNum;
		return y;
	}
	
	
	
}

//******employee class starts here*******************
//these variables will come from a text file with these values 
 class Employee extends BankEssentials{

	@Override
	protected String passWord() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String userName() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String name() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String socialSec() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int indentify() {
		// TODO Auto-generated method stub
		return 0;
	}
	 
	 
	 
 }
 
 
 //**** admin class starts here **********************************
 class Admin extends BankEssentials{

	@Override
	protected String passWord() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String userName() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String name() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String socialSec() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int indentify() {
		// TODO Auto-generated method stub
		return 0;
	}
	  
 }

 



