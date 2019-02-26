package com.revature.banking;

import java.util.Scanner;

import com.revature.banking.user.Customer;
import com.revature.unsused.EmployeeAccess;

public class UserDashboard{
	//I love clean Classes. userType and userID are obtained from earlier, and checked for this switch statement
	public static void dash(int userType, int userID) {
		switch(userType) {
		
		case 1:
			//if usertype is one, they're a customer and go to the customer access dashboard
			CustomerAccess custA = new CustomerAccess();
			custA.custDash(userID);
			break;
		case 2:
			//and so on with employee
			EmployeeAccess empA = new EmployeeAccess();
			empA.employeeDash(userID);
			break;
		case 3:
			//and admin
			AdminAccess admin = new AdminAccess();
			admin.adminDash(userID);
			break;
		case 4:
			//if the userType is 4, that means the account accessed has been cancelled and they go back to login screen
			System.out.println("This account has been cancelled!");
			break;
		
		
		}
	}
	
	
	
}
