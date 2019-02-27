package bank.menu;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import bank.dao.impl.AdminDaoImpl;

public class Admin implements Display
{
	Scanner scan = new Scanner(System.in);
	final static Logger logger = Logger.getLogger(Admin.class);
	@Override
	public void display() 
	{
		System.out.println("Welcome Admin\nWhat do you want to do today?");
		int choice = 0;
		boolean finished = false;
		while(!finished)
		{
			System.out.println("1. View Users"
							  +"\n2. Create User"
							  +"\n3. Update User Info"
							  +"\n4. Delete User"
							  +"\n5. Logout");
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				//View Users
				AdminDaoImpl adi1 = new AdminDaoImpl();
				System.out.print("Enter Customer ID: ");
				int id = scan.nextInt();
				try 
				{
					System.out.println(adi1.getUser(id));
				}
				catch(SQLException e) {e.printStackTrace();}
				break;
			case 2:
				//Create Users
				AdminDaoImpl adi2 = new AdminDaoImpl();
				System.out.print("First Name:");
				String fn=scan.next();
				System.out.print("Last Name:");
				String ln=scan.next();
				System.out.print("Username:");
				String un=scan.next();
				System.out.print("Password:");
				String pw=scan.next();
				System.out.println("Address: (Please use \"-\" to indicate any spacing)");
				String address=scan.next();
				System.out.println("SSN:");
				String ssn=scan.next();
				System.out.println("Phone Number:");
				String pn=scan.next();
				try 
				{
					adi2.addUser(fn, ln, un, pw, address, ssn, pn);
				}
				catch(SQLException e) {e.printStackTrace();}
				logger.info("Admin created User:" + un);
				break;
			case 3:
				//Update Users
				AdminDaoImpl adi3 = new AdminDaoImpl();
				break;
			case 4:
				//Delete Users
				AdminDaoImpl adi4 = new AdminDaoImpl();
				System.out.print("Enter CustomerID of user:");
				int idNum = scan.nextInt();
				try 
				{
					adi4.deleteUser(idNum);;
				}
				catch(SQLException e) {e.printStackTrace();}
				break;
			case 5:
				//Logout
				finished=true;
				System.out.println("Goodbye");
				logger.info("Admin logged out");
				break;
			default:
				System.out.println("Enter numbers 1-5 please");
			}
		}
	}

}
