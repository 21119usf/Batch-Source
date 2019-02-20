// David Lavoie Banking App
// This is the superclass of basically anyone who uses the app
package banking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class User {
		// This is an immutable set of acceptable usertypes.
	private final static Set<String> USERTYPES = Collections.unmodifiableSet(
			new	HashSet<String>(Arrays.asList("Customer","Employee","Admin")));
	//
	
	
	// Methods for all users: CreateID, login, read account
	
	static String createID(Scanner in) {
		// save an ID to the appropriate file folder
		// yes their is a great deal of repetitive code, lo siento mucho.
		System.out.println("What type of account would you like to create?");
		String usertype;
		do {
			System.out.print("Please select from \"Customer\",\"Employee\",or \"Admin\": ");
			usertype = in.nextLine();
		} while (!USERTYPES.contains(usertype));
		char c = usertype.charAt(0);
		boolean verification = false;
		switch (c) {
		case 'A':
			while(verification) {
				System.out.println("This account type requires verification.");
				System.out.println("Admin ID: ");
				String adminID = in.nextLine();
				System.out.println("Admin PW: ");
				String adminPW = in.nextLine();
				verification = login(adminID, adminPW, "Admin");
			} {
			System.out.print("New Username: ");
			String username = in.nextLine();
			System.out.print("New Password: ");
			String password = in.nextLine();
			new Admin(username, password);
			}
			break;
			
		case 'E':
			while(verification) {
				System.out.println("This account type requires verification.");
				System.out.println("Admin ID: ");
				String adminID = in.nextLine();
				System.out.println("Admin PW: ");
				String adminPW = in.nextLine();
				verification = login(adminID, adminPW, "Admin");
			} {
			System.out.print("New Username: ");
			String username = in.nextLine();
			System.out.print("New Password: ");
			String password = in.nextLine();
			new Employee(username, password);
			}
			break;
			
		case 'C':
			System.out.print("New Username: ");
			String username = in.nextLine();
			System.out.print("New Password: ");
			String password = in.nextLine();
			new Customer(username,password);
			break;
			
		default :
			System.out.println("Sorry, that is not an acceptable account type");
		}
		return usertype;
	}

	static boolean login(String userID, String passphrase, String usertype) {
		FileReader file; 
		try {
			file = new FileReader(usertype + ".txt");
			BufferedReader br = new BufferedReader(file);
			while (br.ready() ) {
				String aline = br.readLine();
				if (aline.contains(userID) && aline.contains(passphrase)) {
					br.close();
					return true;
				}
			}
			br.close();
			System.out.println("Account not found, try again?");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
	// CheckAccountInfo(userID)
	@SuppressWarnings("finally")
	public Account readAccount(Integer ID) {
		FileReader fr;
		try {
			fr = new FileReader("Accounts.txt");
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) 
	        {
				String aline = br.readLine();
	            if (aline.contains(ID.toString())) {
	            	Account thisaccount = new Account(aline);
	    			br.close();
	    			fr.close();	
	    			return thisaccount;
	            }
	        }
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {			
			System.out.println("Account not found");
			return null;
		}
	}
}
