package com.revature.bankingapp;

import java.util.Scanner;


public class BankAppMain {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
	/*	IOFile.readAccountFile();
		for(int i = 0;i<IOFile.individualList.size();i++) {
			System.out.println(IOFile.individualList.get(i).toString());}
	*/
		IOFile.readApplicationFile();
		for(int i = 0;i<IOFile.jointApplication.size();i++) {
			System.out.println(IOFile.jointApplication.get(i).toString());
			}
		WelcomeScreen w = new WelcomeScreen();
		w.introduction();
	}

}
