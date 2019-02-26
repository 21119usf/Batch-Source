package com.revature.view;

import java.util.PriorityQueue;

import com.reavture.beans.Account;
import com.reavture.beans.User;
import com.revature.input.ApplicationActionInput;
import com.revature.service.UserAccountService;
import com.revature.service.UserService;

// Initial View for Account Actions View
public class ApplicationsActionView implements IsViewable {

	public ApplicationsActionView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		String spacer = "     ";
		System.out.println("Loading Accounts");
		PriorityQueue<Account> accts = new PriorityQueue<Account>();
		accts = new UserAccountService(new User()).getPendingAccounts();
		while(accts.isEmpty() == false) {
			Account a = accts.poll();
			User primaryUser = new UserService().getUser(a.getPrimaryOwner());
			User secondaryUser = new User();
			if (a.getSecondaryOwner() != 0) {
				secondaryUser = new UserService().getUser(a.getSecondaryOwner());
			}
			System.out.println("Account Id: " + a.getAccountId());
			System.out.println(spacer + "Primary Owner: ");
			System.out.println(spacer +  spacer + "Username: " + primaryUser.getUsername());
			System.out.println(spacer +  spacer + "SSN: " + "*****" +  primaryUser.getSSN().substring(5, 9));
			if (secondaryUser.getEmail() != null) {
				System.out.println(spacer + "Secondary Owner: ");
				System.out.println(spacer +  spacer + "Username: " + secondaryUser.getUsername());
				System.out.println(spacer +  spacer + "SSN: " + "*****" +  secondaryUser.getSSN().substring(5, 9));
			}
			System.out.println(spacer + spacer + "Opening Balance: " + a.getBalance());
			System.out.println("(A) Accept, (D) Deny, (X) Do It Later");
			new ApplicationActionInput(a).getInput();
		}
	}

}
