package com.revature.options;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.revature.daoImpl.CustomerDaoImpl;

public class Apply {
	private static Scanner sc = new Scanner(System.in);
	public static void apply() {
		System.out.println("Enter your first name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter your last name: ");
		String lastName = sc.nextLine();
		System.out.println("Enter a username");
		String userName = sc.nextLine();
		System.out.println("Enter a password");
		String password = sc.nextLine();
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		while(true) {
			try	{
				cdi.createCustomer(firstName, lastName, userName, password);
				System.out.println("Account successfully created!");
				break;
			}catch(SQLIntegrityConstraintViolationException e) {
				System.out.println("This username is already taken enter another");
				userName = sc.nextLine();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
