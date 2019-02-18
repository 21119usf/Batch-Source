package com.revature.banking;

import java.util.Scanner;

import com.revature.banking.user.Applicants;

public class newCustomer {
	static IO io = new IO();
	static String custString = io.readInputStreamContents("Applicants.txt");
	static String[] custList = custString.split(System.getProperty("line.separator"));
	static int custNum = custList.length;
//	public static void main(String[] args) {
//		usernameChoose();
//	}
	static void usernameChoose(){
		boolean validName = false;
		while (!validName) {
		System.out.println("Please choose a Username");
		Scanner input = new Scanner(System.in);
		String custAttempt = input.nextLine();
		for (int i = 0; i < custNum; i++) {

			String[] custSplit = custList[i].split(":");
			if (custAttempt.equals(custSplit[1])) {
				System.out.println("Username already taken.\nPlease choose a different Username");
				custAttempt = input.nextLine();
			}
		}
		
		
		validName = true;
		boolean joint = jointApply();
		boolean passLengthOkay = false;
		while (!passLengthOkay) {
		
		System.out.println("Please choose a Password with 6 to 10 characters:");
		String password = input.nextLine();
			if (password.length()>10) {
				System.out.println("This password is too long; try again.");
			}
			else if (password.length()<6) {
				System.out.println("This password is too short; try again");
			}
			else {
				int passint = password.hashCode();
				int encryption = (passint*500003477)%1009747;
				boolean approved = false;
				Applicants a = new Applicants(custNum,custAttempt,joint, encryption,approved);
				a.toString();
				io.writeOutputStreamContents(System.getProperty("line.separator") + 
						custNum + ":" + custAttempt + ":" + joint + ":" + encryption+ ":" + approved, "Applicants.txt");
				passLengthOkay=true;
			}
		}
		
		}
	}
	public static boolean jointApply() {
		boolean joint = false;
		System.out.println("Would you like to apply for a joint bank account? (Y or N)");
		Scanner input = new Scanner(System.in);
		String response = input.nextLine();
		if (response.equals("Y")) {
			joint = true;
		}
		return joint;
	}
}
