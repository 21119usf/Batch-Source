package com.revature.options;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Properties;
import java.util.Scanner;

import com.revature.daoImpl.AdminDaoImpl;
import com.revature.daoImpl.CustomerDaoImpl;

public class AdminOptions {
	private static Scanner sc = new Scanner(System.in);
	public static void login() {
		while(true) {
			System.out.print("Enter your username: ");
			String username = sc.nextLine();
			System.out.print("Enter your password: ");
			String password = sc.nextLine();
			Properties prop = new Properties();
			try {
				prop.load(new FileReader("database.properties"));
				if(username.equals(prop.getProperty("adminUsr")) && password.equals(prop.getProperty("adminPass"))){
					break;
				}else {
					System.out.println("Incorrect admin credentials");
				}
			} catch (FileNotFoundException e) {
				System.out.println("props file not found");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void adminMenu() {
		AdminDaoImpl adi = new AdminDaoImpl();
		while(true) {
			System.out.println("\n\t1.View users and account balances");
			System.out.println("\t2.Create User");
			System.out.println("\t3.Delete user");
			System.out.println("\t4.Update user");
			System.out.println("\t5.Logout");
			String choice=sc.nextLine();
			if(choice.equals("1")) {
				try {
					adi.viewAccounts();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(choice.equals("2")) {
				System.out.println("Enter customers first name: ");
				String firstName = sc.nextLine();
				System.out.println("Enter customers last name: ");
				String lastName = sc.nextLine();
				System.out.println("Enter a username");
				String userName = sc.nextLine();
				System.out.println("Enter a password");
				String password = sc.nextLine();
				CustomerDaoImpl cdi = new CustomerDaoImpl();
				while(true) {
					try	{
						cdi.createCustomer(firstName, lastName, userName, password);
						System.out.println("Accounts successfully created!");
						break;
					}catch(SQLIntegrityConstraintViolationException e) {
						System.out.println("This username is already taken enter another");
						userName = sc.nextLine();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}else if(choice.equals("3")) {
				try {
					System.out.println("Enter the number of the user you would like to delete    ");
					int cid = parser(sc.nextLine());
					adi.delete(cid);
					System.out.println("User "+cid+" deleted");
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(choice.equals("4")) {
				update(adi);
			}else if(choice.equals("5")) {
				System.out.println("Thank you and goodbye");
				break;
			}else {
				System.out.println("Incorrect input try again");
			}
		}
		
	}
	public static void update(AdminDaoImpl adi) {
		System.out.println("Enter the customer id number of the user you want to update: ");
		int cid = parser(sc.nextLine());
		System.out.println("Which attribute would you like to change?");
		System.out.println("\t1.First name");
		System.out.println("\t2.Last name");
		System.out.println("\t3.Username");
		System.out.println("\t4.Password");
		String choice = sc.nextLine();
		if(choice.equals("1")) {
			System.out.println("Enter new first name: ");
			String firstName=sc.nextLine();
			try {
				adi.updatefirstName(firstName, cid);
				System.out.println("Change made");
			} catch (SQLException e) {
				System.out.println("Error invalid input");
			}
		}else if(choice.equals("2")) {
			System.out.println("Enter new last name: ");
			String lastName=sc.nextLine();			
			try {
				adi.updatelastName(lastName, cid);
				System.out.println("Change made");
			} catch (SQLException e) {
				System.out.println("Error invalid input");
			}
		}else if(choice.equals("3")) {
			System.out.println("Enter new username: ");
			String username=sc.nextLine();
			try {
				adi.updateusername(username, cid);
				System.out.println("Change made");
			} catch (SQLException e) {
				System.out.println("Error invalid input");
			}
		}else if(choice.equals("4")) {
			System.out.println("Enter new password: ");
			String password=sc.nextLine();
			try {
				adi.updatepassword(password, cid);
				System.out.println("Change made");
			} catch (SQLException e) {
				System.out.println("Error invalid input");
			}
		}
		
	}
	public static int parser(String s) {
		while(true) {
			try {
				return Integer.parseInt(s);
			}catch(NumberFormatException e) {
				System.out.println("invalid format, try again");
			}
		}
	}
			
	
}
