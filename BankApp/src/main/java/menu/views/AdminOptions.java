package menu.views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import account.Account;
import bankactors.Admin;
import menu.CreateMenuDisplay;
import validation.Validations;

public class AdminOptions
{
	final static Logger logger = Logger.getLogger(AdminOptions.class);
	private static Scanner scan = new Scanner(System.in);
	private static String adminsFile = "Admins.ser";
	private static ArrayList<Admin> admins = new ArrayList<Admin>();
	private static Admin currentAdmin;
	
	// Load employees from file
	@SuppressWarnings("unchecked")
	public static void loadAdmins()
	{
		try 
		{
			FileInputStream fis = new FileInputStream(adminsFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			admins = (ArrayList<Admin>)ois.readObject();
			ois.close();
			fis.close();
		} 
		catch (FileNotFoundException e){System.out.println("File \"Admins.ser\" was not found");}
		catch (IOException e) {}
		catch (ClassNotFoundException e) {}
	}
	
	// Save employees to file
	public static void saveAdmins() 
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(adminsFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(admins);
			oos.close();
			fos.close();
		} 
		catch (FileNotFoundException e) {e.printStackTrace();}	 
		catch (IOException e) {e.printStackTrace();}
	}
	
	// Display login
	public static void displayLogin()
	{
		boolean notValidLogin = true;
		String username;
		String password;
		while(notValidLogin)
		{
			System.out.println("Enter Username: ");
			username = scan.nextLine();
			System.out.println("Password: ");
			password = scan.nextLine();
			
			currentAdmin = validLogin(username, password);
			if (currentAdmin != null) 
			{
				notValidLogin = false;
				System.out.println("Login accepted. Logging in.");
				logger.info("Admin " + currentAdmin.getAdminID() + " logged in");
				displayAdminMenu();
			}
		} 
	}

	// Validate login
	private static Admin validLogin(String username, String password) 
	{
		// Admin login
		for (Admin a : admins) 
		{
			if (a.getUsername().equals(username)) 
			{
				if (a.getPassword().equals(password)) 
				{
					System.out.println("You are logged in!");
					return a;
				}
				else
				{
					System.out.println("Invalid login. Try again.");
					return null;
				}				
			}
		}
		System.out.println("Admin \"" + username + "\" does not exist.");
		return null;
	}
	
	// Register employee
	public static void displayRegistration() 
	{
		String username = "";
		String password = "";
		String firstName = "";
		String lastName = "";
			
		System.out.println("Enter your personal account information:");
			
		boolean notValidUsername = true;
		while(notValidUsername)
		{
			System.out.println("Enter a username");
			username = scan.nextLine();
			if (Validations.validUsername(username)) 
			{
				notValidUsername = false;
			} 
			else
			{
				System.out.println("Username is either invalid or taken.");
			}
		}
			
		// Password
		boolean notValidPassword = true;
		String pass1, pass2;
		while(notValidPassword) 
		{
			System.out.println("Enter a password");
			pass1 = scan.nextLine();
			if (Validations.validPassword(pass1)) 
			{
				System.out.println("Re-type password: ");
				pass2 = scan.nextLine();
				if (pass1.equals(pass2)) 
				{
					password = pass1;
					notValidPassword = false;
				} 
				else
				{
					System.out.println("Mismatched passwords.");
				}
			}
		} 
			
		// First and last names
		System.out.println("Enter your first name: ");
		firstName = scan.nextLine();
		System.out.println("Enter your last name: ");
		lastName = scan.nextLine();
			
		// Create Admin object and store data
		Admin a = new Admin(username, password, firstName, lastName);
		admins.add(a);
		saveAdmins();
		logger.info("Admin " + a.getAdminID() + " was created");
		displayLogin();
	}
		
	public static void displayAdminMenu() 
	{	
		ArrayList<String> menuItems = new ArrayList<String>();
		menuItems.add("Withdraw from an account");
		menuItems.add("Deposit from an account");
		menuItems.add("Transfer from an account");
		menuItems.add("Cancel Account");
		menuItems.add("Logout");
		CreateMenuDisplay m = new CreateMenuDisplay(menuItems);
		int choice = m.display();
		
		switch (choice) 
		{
			case 1:
				withdraw();
				break;
			case 2:
				deposit();
				break;
			case 3:
				transfer();
				break;
			case 4:
				closeAccount();
				break;
			case 5:
				System.out.println("Logging out.");
				logger.info("Admin " + currentAdmin.getAdminID() + " logged out");
				System.exit(0);
				break;
		}		
	}
	public static void withdraw()
	{
		int accID = 0;
		System.out.println("Enter useraccount ID: ");
		if(scan.hasNextInt())
		{
			accID = scan.nextInt();
			scan.nextLine();
		}
		else
		{
			System.out.println("Account ID is incorrect. Try again.");
			scan.nextLine();
		}
		Account a = AccountOptions.getAccount(accID);
		if(a!=null)
		{
			AccountOptions.withdraw(a);
		}
		else
		{
			System.out.println("User account was not found.");	
		}
	}
	public static void deposit()
	{
		int accID = 0;
		System.out.println("Enter useraccount ID: ");
		if(scan.hasNextInt())
		{
			accID = scan.nextInt();
			scan.nextLine();
		}
		else
		{
			System.out.println("Account ID is incorrect. Try again.");
			scan.nextLine();
		}
		Account a = AccountOptions.getAccount(accID);
		if(a!=null)
		{
			AccountOptions.deposit(a);
		}
		else
		{
			System.out.println("User account was not found.");	
		}
	}
	public static void transfer()
	{
		int accID = 0;
		System.out.println("Enter useraccount ID: ");
		if(scan.hasNextInt())
		{
			accID = scan.nextInt();
			scan.nextLine();
		}
		else
		{
			System.out.println("Account ID is incorrect. Try again.");
			scan.nextLine();
		}
		Account a = AccountOptions.getAccount(accID);
		if(a!=null)
		{
			AccountOptions.transfer(a);
		}
		else
		{
			System.out.println("User account was not found.");	
		}
	}
	public static void closeAccount() 
	{
		int accID = 0;
		System.out.println();
		System.out.println("Enter useraccount ID: ");
		if(scan.hasNextInt())
		{
			accID = scan.nextInt();
			scan.nextLine();
		}
		else
		{
			System.out.println("Account ID is incorrect. Try again.");
			scan.nextLine();
		}
		Account a = AccountOptions.getAccount(accID);
		if(a!=null)
		{
			AccountOptions.closeAccount(a);
		}
		else
		{
			System.out.println("User account was not found.");
		}
	}
}
