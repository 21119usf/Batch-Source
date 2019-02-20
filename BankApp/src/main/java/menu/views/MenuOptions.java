package menu.views;


import java.util.ArrayList;
import menu.CreateMenuDisplay;

public class MenuOptions 
{
	// Display landing page and get desired option
		public static int displayMenu()
		{
			ArrayList<String> menuItems = new ArrayList<String>();
			menuItems.add("Are you a Customer?");
			menuItems.add("Are you an Employee?");
			menuItems.add("Are you an Admin?");
			menuItems.add("Or NOT any of these?");
			CreateMenuDisplay m = new CreateMenuDisplay(menuItems);
			int option = m.display();
			return option;
		}
		
		// Display customer entry page
		public static void displayCustomerPage()
		{
			ArrayList<String> menuItems = new ArrayList<String>();
			menuItems.add("Customer Login");
			menuItems.add("Register");
			menuItems.add("Go Back?");
			CreateMenuDisplay m = new CreateMenuDisplay(menuItems);
			int choice = m.display();
			
			switch (choice)
			{
				case 1:
					CustomerOptions.displayLogin();
					break;
				case 2:
					CustomerOptions.displayRegistration();
					break;
				case 3:
					displayMenu();
					break;
			}
		}
		
		// Display employee entry page
		public static void displayEmployeePage()
		{
			ArrayList<String> menuItems = new ArrayList<String>();
			menuItems.add("Employee Login");
			menuItems.add("Register");
			menuItems.add("Go Back?");
			CreateMenuDisplay m = new CreateMenuDisplay(menuItems);
			int choice = m.display();
			
			switch (choice)
			{
				case 1:
					EmployeeOptions.displayLogin();
					break;
				case 2:
					EmployeeOptions.displayRegistration();
					break;
				case 3:
					displayMenu();
					break;
			}	
		}
		
		public static void displayAdminPage()
		{
			ArrayList<String> menuItems =  new ArrayList<String>();
			menuItems.add("Admin Login");
			menuItems.add("Register");
			menuItems.add("Go Back?");
			CreateMenuDisplay m = new CreateMenuDisplay(menuItems);
			int choice =  m.display();
			
			switch(choice)
			{
			case 1:
				AdminOptions.displayLogin();
				break;
			case 2:
				AdminOptions.displayRegistration();
				break;
			case 3:
				displayMenu();
				break;
			}
		}
}
