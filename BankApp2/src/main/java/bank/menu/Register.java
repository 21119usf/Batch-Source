package bank.menu;

import java.sql.SQLException;
import java.util.Scanner;

import bank.dao.impl.CustomersDaoImpl;

public class Register implements Display
{
	Scanner scan = new Scanner(System.in);
	@Override
	public void display() 
	{
		System.out.println();
		CustomersDaoImpl cdi = new CustomersDaoImpl();
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
			cdi.addCustomer(fn, ln, un, pw, address, ssn, pn);
		}
		catch(SQLException e) {e.printStackTrace();}
		new Menu().display();
	}

}
