package com.revature.bankingapp;

import java.util.Scanner;

public class EmpMenu {
	
	static Scanner in = new Scanner(System.in);
	public void employeeMenu(String user) {
		System.out.println("==============================================================================================");
        System.out.println("Choose from the following menu:");
        System.out.println("1. View Applicants");
        System.out.println("2. View Customer Info");
        System.out.println("9. Exit");
        System.out.println("==============================================================================================");
        System.out.println("Please enter an option:");
        System.out.println("==============================================================================================");
		
        int choice = in.nextInt();
        switch(choice) {
        	case 1:{
        		System.out.println("Press '1' for individual apps, '2' for joint");
        		int n = in.nextInt();
        		if(n==1) {
        			viewApplicants(user);
        		}else
        			viewJointApplicants(user);
        		break;
        		}
        	case 2:
        		viewCustomerInfo();
        		employeeMenu(user);
        		break;
        		
        	case 9:
        		System.out.println("You have chosen to exit. Goodbye!\n\n\n\n");
        		WelcomeScreen w = new WelcomeScreen();
        		w.introduction();
        		break;
        	default:
        		employeeMenu(user);
        		break;
        }
	}
	
	public void viewApplicants(String user) {
		IOFile.readApplicationFile();
		for(int i = 0;i<IOFile.individualApplication.size();i++) {
			String first = IOFile.individualApplication.get(i).getCustFirst();
			String last = IOFile.individualApplication.get(i).getCustLast();
			System.out.println((i+1)+" "+first+" "+last+ "'s Application");
			System.out.println("Press 'A' to approve or 'D' to deny?");
			char entry = in.next().charAt(0);
			if(entry == 'A'||entry == 'a') {
				IOFile.individualList.add(IOFile.individualApplication.get(i));
				IOFile.individualApplication.remove(IOFile.individualApplication.get(i));
				System.out.println(first+" "+last+ "'s Application has been APPROVED.\n\n");
			}else
				if(entry == 'D'|| entry =='d') {
					IOFile.individualApplication.remove(IOFile.individualApplication.get(i));
					System.out.println(first+" "+last+ "'s Application has been DENIED.\n\n");
				}else {
					System.out.println("Invalid Entry.");
					continue;
				}
		}
		IOFile.writeAccountFile();
		IOFile.writeApplicationFile();
		employeeMenu(user);
	}
	
	public void viewJointApplicants(String user) {
		IOFile.readApplicationFile();
		for(int i = 0;i<IOFile.jointApplication.size();i++) {
			String first = IOFile.jointApplication.get(i).getCustFirst();
			String last = IOFile.jointApplication.get(i).getCustLast();
			String cofirst = IOFile.jointApplication.get(i).getCoFirst();
			String colast = IOFile.jointApplication.get(i).getCoLast();
			System.out.println((i+1)+" "+first+" "+last+ " and "+cofirst+" "+colast+"'s Application");
			System.out.println("Press 'A' to approve or 'D' to deny?");
			char entry = in.next().charAt(0);
			if(entry == 'A'||entry == 'a') {
				IOFile.jointList.add(IOFile.jointApplication.get(i));
				IOFile.jointApplication.remove(IOFile.jointApplication.get(i));
				System.out.println(first+" "+last+ " and "+cofirst+" "+colast+"'s Application has been APPROVED.\n\n");
			}else
				if(entry == 'D'|| entry =='d') {
					IOFile.jointApplication.remove(IOFile.jointApplication.get(i));
					System.out.println(first+" "+last+ " and "+cofirst+" "+colast+"'s Application has been DENIED.\n\n");
				}else {
					System.out.println("Invalid Entry.");
					continue;
				}
		}
		IOFile.writeAccountFile();
		IOFile.writeApplicationFile();
		employeeMenu(user);
		
	}
	
	public static void viewCustomerInfo() {
		IOFile.readAccountFile();
		for(int i = 0;i<IOFile.jointList.size();i++) {
			System.out.println(IOFile.jointList.get(i).toString());
		}
		for(int i = 0;i<IOFile.individualList.size();i++) {
			System.out.println(IOFile.individualList.get(i).toString());
		}
		
	}
}
