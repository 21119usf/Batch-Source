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
import bankactors.Customer;
import bankactors.Employee;
import menu.CreateMenuDisplay;
import validation.Validations;

public class EmployeeOptions
{
	final static Logger logger = Logger.getLogger(EmployeeOptions.class);
	private static Scanner scan = new Scanner(System.in);
	private static String employeesFile = "Employees.ser";
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static Employee currentEmp;
	
	
	// Load employees from file
	@SuppressWarnings("unchecked")
	public static void loadEmployees()
	{
		try 
		{
			FileInputStream fis = new FileInputStream(employeesFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			employees = (ArrayList<Employee>)ois.readObject();
			ois.close();
			fis.close();
		} 
		catch (FileNotFoundException e){System.out.println("File \"Employee.ser\" was not found");}
		catch (IOException e) {}
		catch (ClassNotFoundException e) {}
	}
	
	// Save employees to file
	public static void saveEmployees() 
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(employeesFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(employees);
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
			
			currentEmp = validLogin(username, password);
			if (currentEmp != null) 
			{
				notValidLogin = false;
				System.out.println("Login accepted. Logging in.");
				logger.info("Employee " + currentEmp.getEmpID() + " logged in");
				displayEmployeeMenu();
			}
		} 
	}
	
	// Validate login
	private static Employee validLogin(String username, String password) 
	{
		// Employee login
		for (Employee e : employees) 
		{
			if (e.getUsername().equals(username)) 
			{
				if (e.getPassword().equals(password)) 
				{
					System.out.println("You are logged in");
					return e;
				}
				else
				{
					System.out.println("Invalid login. Try again.");
					return null;
				}
			}
		}
		System.out.println("Employee \"" + username + "\" does not exist.");
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
					System.out.println("Please match passwords.");
				}
			}
		} 
		
		// First and last names
		System.out.println("Enter your first name: ");
		firstName = scan.nextLine();
		System.out.println("Enter your last name: ");
		lastName = scan.nextLine();
		
		// Create Customer object and store data
		Employee e = new Employee(username, password, firstName, lastName);
		employees.add(e);
		saveEmployees();
		logger.info("Employee " + e.getEmpID() + " was created");
		displayLogin();
	}
	
	public static void displayEmployeeMenu() 
	{
		ArrayList<String> menuItems = new ArrayList<String>();
		menuItems.add("View Customer Account and Balance");
		menuItems.add("View Customer Information");
		menuItems.add("Logout");
		CreateMenuDisplay m = new CreateMenuDisplay(menuItems);
		int choice = m.display();
		
		switch (choice) 
		{
			case 1:
				displayUserAccount();
				break;
			case 2:
				viewUserInfo();
				break;
			case 3:
				System.out.println("Logging out.");
				logger.info("Employee " + currentEmp.getEmpID() + " logged out");
				System.exit(0);
				break;
		}
	}
	public static void displayUserAccount() 
	{
		int accID = 0;
		System.out.println("Enter the user's account ID:");
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
		if(a != null)
		{
			System.out.println("User's Account ID: " + a.getAccountID());
			System.out.println("User's Balance: " + a.getBalance());
			ArrayList<Customer> owner = a.getUsers();
			System.out.print("Account Owner(s): " );
			for(Customer c : owner)
			{
				System.out.println(c.getUsername() + " ");
			}
		}
		else
		{
			System.out.println("The Account was not found");
		}
		return;
	}
	public static void viewUserInfo()
	{
		int accID = 0;
		System.out.println("Enter the user's account ID:");
		if(scan.hasNextInt())
		{
			accID = scan.nextInt();
			scan.nextLine();
		}
		else
		{
			System.out.println("Accout ID is incorrect. Try again");
			scan.nextLine();
		}
		
		Customer c = CustomerOptions.getCustomer(accID);
		if(c!=null)
		{
			System.out.println("User ID: " + c.getCustID());
			System.out.println(("User username: " + c.getUsername()));
			System.out.println("User full name: " + c.getFirstName() + " " + c.getLastName());
			System.out.println("User phone number: " + c.getPhoneNum());
			System.out.println("User email: " + c.getEmail());
			System.out.println("User address:" + c.getAddress());
		}
		else
		{
			System.out.println("Account was not found");
		}
		return;
	}
}
