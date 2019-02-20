package com.revature.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class AccountCreator{
	
	
	
	public static void CreateAccount() throws IOException
	{
		
		
		
		//file will be named customers
				//output stream stuff
				Scanner scan = new Scanner(System.in);
				File file = new File("data.txt");
				
				
				
				
				System.out.println("=============================================");
				System.out.println("=============================================");
				System.out.println("=========   Account  Creation  ==============");
				System.out.println("=============================================");
				System.out.println("=============================================");
				System.out.println("\n");
				System.out.println("Enter Username:");
				String name = scan.nextLine();
				name = "name: " + name;
				
				System.out.println("Enter Password:");
				String password = scan.nextLine();
				password = "password: " + password;
				
				System.out.println("Enter Account Number:");
				String accountN = scan.nextLine();
				accountN = "accountNumber: " + accountN;
				
				System.out.println("Enter SSN:");
				String ssn = scan.nextLine();
				ssn = "ssn: " + ssn;
				
				//output streams using \r\n for next lines
				OutputStream outStream = new FileOutputStream(file);
				outStream.write(name.getBytes());
				outStream.write("\r\n".getBytes());
				outStream.write(password.getBytes());
				outStream.write("\r\n".getBytes());
				outStream.write(accountN.getBytes());
				outStream.write("\r\n".getBytes());
				outStream.write(ssn.getBytes());
				outStream.close();
	}
	
	
//	public static void Input() throws IOException
//	{
//		
//		
//		//input stream stuff
//				File file = new File("customers.txt");
//				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//				String firstLine = reader.readLine();
//				reader.close();
//				System.out.println("This is what is read: " + firstLine);
//		
//	}
	
	
	public static void main(String[] args) throws IOException
	{
		CreateAccount();
		//Input();
	
	}

}
