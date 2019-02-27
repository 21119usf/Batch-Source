package bank.menu;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import bank.dao.impl.CustomersDaoImpl;

public class Customer implements Display
{
	Scanner scan = new Scanner(System.in);
	final static Logger logger = Logger.getLogger(Customer.class);
	@Override
	public void display() 
	{
		System.out.println("Welcome Customer!\nWhat do you want to do today?");
		int choice = 0;
		boolean finished = false;
		while(!finished)
		{
			System.out.println("1. View Accounts & Balance"
							  +"\n2. Create an Account"
							  +"\n3. Delete an Account"
							  +"\n4. Deposit"
							  +"\n5. Withdraw"
							  +"\n6. Logout");
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				//View Accounts & Balances
				CustomersDaoImpl cdi1 = new CustomersDaoImpl();
				System.out.print("Enter your Customer ID: ");
				int custID = scan.nextInt();
				try 
				{
					System.out.println(cdi1.showAccountInfo(custID));
				}
				catch(SQLException e) {e.printStackTrace();}
				break;
			case 2:
				//Create An Account
				CustomersDaoImpl cdi2 = new CustomersDaoImpl();
				System.out.print("Enter your Customer ID: ");
				int custID1 = scan.nextInt();
				System.out.println("Do you want this account to be a Checking or a Savings Account?");
				String type = scan.next();
				System.out.println("How much do you want to put in?");
				double balance = scan.nextDouble();
				try 
				{
					cdi2.createAccount(balance, type, custID1);
				}
				catch(SQLException e) {e.printStackTrace();}
				logger.info("User: "+custID1+ " has created an account!" );
				break;
			case 3:
				//Delete an Account
				CustomersDaoImpl cdi3 = new CustomersDaoImpl();
				System.out.print("Enter Account ID:");
				int accID = scan.nextInt();
				try 
				{
					cdi3.deleteAccount(accID);
				}
				catch(SQLException e) {e.printStackTrace();}
				logger.info("Account: "+accID+ " has been deleted!" );
				break;
			case 4:
				//Deposit
				CustomersDaoImpl cdi4 = new CustomersDaoImpl();
				System.out.print("Enter Account ID: ");
				int accID1 = scan.nextInt();
				System.out.print("Enter how much you want to deposit: ");
				double damount = scan.nextDouble();
				try 
				{
					cdi4.depsoit(damount, accID1);;
				}
				catch(SQLException e) {e.printStackTrace();}
				
				
				break;
			case 5:
				//Withdraw
				CustomersDaoImpl cdi5 = new CustomersDaoImpl();
				System.out.print("Enter Account ID: ");
				int accID2 = scan.nextInt();
				System.out.print("Enter how much you want to withdraw: ");
				double wamount = scan.nextDouble();
				try 
				{
					cdi5.depsoit(wamount, accID2);;
				}
				catch(SQLException e) {e.printStackTrace();}
				break;
			case 6:
				//Logout
				finished=true;
				System.out.println("Goodbye");
				logger.info("Customer logged out");
				break;
			default:
				System.out.println("Enter numbers 1-6 please");
			}
		}
	}
	
}
