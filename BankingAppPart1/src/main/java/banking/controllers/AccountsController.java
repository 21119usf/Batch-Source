package banking.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import banking.Driver;
import banking.IO;
import banking.beans.Account;
import banking.beans.Customer;
import banking.beans.Session;

public class AccountsController extends BaseController<Account> {
	
	private static AccountsController instance;
	private AccountsController() {
	}
	
	public static AccountsController getInstance(){
		if(instance == null)
			instance = new AccountsController();
		return instance;	
	}

	@Override
	public Account NEW(String... args) {
		
		//error message
		if(args != null && args.length > 0) {
			System.out.println(args[0]);
		}
		
		String accountName = "";
		String balanceStr = "";
		String isJoint = "";
		String jointOwner = "";
		int balance = -1;
		Scanner input = Driver.input;
		while(!Customer.validUsername(accountName)) { //using the same method for requirements as customers for now
			System.out.println("Please enter a valid account name. Must be 6-20 alphabetical characters long with no spaces.");
			if(input.hasNextLine()) {
				accountName= input.nextLine();
				if(accountName.equals("exit")) {
					System.exit(0);
				}
			}
		}
		
		while(!isJoint.equals("yes") && !isJoint.equals("no")) { //using the same method for requirements as customers for now
			System.out.println("Is this a joint account? Enter yes or no.");
			if(input.hasNextLine()) {
				isJoint= input.nextLine();
				if(isJoint.equals("exit")) {
					System.exit(0);
				}
			}
		}
		
		if(isJoint.equals("yes")) {
			
			ArrayList<Customer> jointown = new ArrayList<Customer>();
			jointown = IO.ReadFile(Customer.fileName, jointown);
			boolean userExists = false;
			while(!Customer.validUsername(jointOwner) || !userExists) {
				System.out.println("Please enter a valid joint owner name.");
				if(input.hasNextLine()) {
					jointOwner= input.nextLine();
					if(jointOwner.equals("exit")) {
						return null;
					}
					for(Customer own : jointown) {
						if(jointOwner.equals(own.getUserName())) {
							userExists = true;
							break;
						}
					}
				}
			}
		}
		
		while(balance < 0) {
			System.out.println("Please enter a starting amount.");
			
			if(input.hasNextLine()) {
				balanceStr = input.nextLine();
				if(balanceStr.equals("exit")) {
					return null;
				}
				  try {
					    balance = Integer.parseInt(balanceStr);
					    if(balance < 0) {
						    balance = -1;
						    System.out.println("Invalid amount");	
					    }
					  } catch (NumberFormatException nfe) {
					    balance = -1;
					    System.out.println("Invalid amount");
					  }
			}
		}
		
		return CREATE(accountName, balanceStr, isJoint, jointOwner);
	}

	@Override
	public Account CREATE(String... args) {
		double balance = Integer.parseInt(args[1]);
		Account newacc = new Account(args[0], Session.currentSession().getOwner().getUserName(), balance, args[2].equals("yes"), args[3], false);
		
		ArrayList<Account> ob = new ArrayList<Account>();
		ob = IO.ReadFile(Account.fileName, ob);
		
		for(Account cus : ob) {
			if(cus.getAccountName().equals(args[0])) {
				System.out.println("Account already exists");
				return null;
			}
		}
		
		ob.add(newacc);
		
		IO.writeFile(Account.fileName, ob);
		System.out.println("Thank you. Your Account has been created.");
		AccountsController.getInstance().INDEX();
		return newacc;
	}
		

	@Override
	public Account SHOW(String... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void INDEX(String... args) {
		
		ArrayList<Account> accs = new ArrayList<Account>();
		ArrayList<Account> useraccs = new ArrayList<Account>();
		accs = IO.ReadFile(Account.fileName, accs);
		
		if(Session.currentSession().customerIsLoggedIn()) {
			System.out.println("Your Accounts: ");
			int allcustomeraccounts = 0;
			for(Account acc : accs) {
				if(acc.getOwnerName().equals(Session.currentSession().getOwner().getUserName()) || acc.getJointOwnerName() != null && acc.getJointOwnerName().equals(Session.currentSession().getOwner().getUserName())) {
					System.out.println(acc.toString());
					if(acc.isApproved())
						useraccs.add(acc);
					allcustomeraccounts++;
				}
			}
			if(allcustomeraccounts == 0) {
				System.out.println("No accounts.");
			}
			
			System.out.println("You can make a new account by entering \"new account\".\nOtherwise enter the name of the account you wish to access.");
			Scanner input = Driver.input;
			boolean validOption = false;
			
			
			while(validOption == false) {
				if(input.hasNextLine()) {
					String option = input.nextLine();
					
					if(option.equals("new account")) { //here you should also choose account name, account.show should handle withdraw,etc
						validOption = true;
						AccountsController.getInstance().NEW();
					} else if(option.equals("exit")) {
						return;
					} else {
						for(Account ac : useraccs) {
							if(ac.getAccountName().equals(option)) {
								AccountsController.getInstance().EDIT(option);
								return;
							}
						}
						System.out.println("Invalid Option.");
					}
				}
			}
		}
		
		if(args.length > 0 && args[0].equals("pending accounts") && (Session.currentSession().employeeIsLoggedIn() || Session.currentSession().adminIsLoggedIn())) {
			System.out.println("Pending Accounts: ");
			for(Account acc : accs) {
				if(!acc.isApproved()) {
					System.out.println(acc.toString());
					useraccs.add(acc);
				}
			}
			if(useraccs.isEmpty()) {
				System.out.println("No pending accounts.");
			}
			
			System.out.println("Enter the name of the account you wish to access.");
			Scanner input = Driver.input;
			boolean validOption = false;
			
			
			while(validOption == false) {
				if(input.hasNextLine()) {
					String option = input.nextLine();
					
					if(option.equals("exit")) {
						return;
					} else {
						for(Account ac : useraccs) {
							if(ac.getAccountName().equals(option)) {
								AccountsController.getInstance().EDIT(option);
								return;
							}
						}
						System.out.println("Invalid Option.");
					}
				}
			}
		}
		
		if(Session.currentSession().employeeIsLoggedIn() || Session.currentSession().adminIsLoggedIn()) {
			System.out.println(args[0] + "'s Accounts: ");
			int allcustomeraccounts = 0;
			for(Account acc : accs) {
				if(acc.getOwnerName().equals(args[0]) || acc.getJointOwnerName() != null && acc.getJointOwnerName().equals(args[0])) {
					System.out.println(acc.toString());
					useraccs.add(acc);
					allcustomeraccounts++;
				}
			}
			if(allcustomeraccounts == 0) {
				System.out.println("No accounts.");
			}
			
			System.out.println("Enter the name of the account you wish to access.");
			Scanner input = Driver.input;
			boolean validOption = false;
			
			
			while(validOption == false) {
				if(input.hasNextLine()) {
					String option = input.nextLine();
					
					if(option.equals("exit")) {
						return;
					} else {
						for(Account ac : useraccs) {
							if(ac.getAccountName().equals(option)) {
								AccountsController.getInstance().EDIT(option);
								return;
							}
						}
						System.out.println("Invalid Option.");
					}
				}
			}
		}
		
		
	}

	@Override
	public Account EDIT(String... args) {
		System.out.println("Currently in account: " + args[0]);
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts = IO.ReadFile(Account.fileName, accounts);
		Account curracc = null; //current edited account
		Account other = null; //other account (used in transfers)
		
		for(Account ac : accounts) {
			if(ac.getAccountName().equals(args[0])) {
				curracc = ac;
			}
		}
		Scanner input = Driver.input;
		
		if(Session.currentSession().customerIsLoggedIn()) {
			
			System.out.println("Balance: " + curracc.getBalance()); 
			System.out.println("Enter \"withdraw\", \"deposit\", or \"transfer\" followed by the amount.");
			
			
			boolean validOption = false;
			
			
			while(validOption == false) {
				if(input.hasNextLine()) {
					String line = input.nextLine();
					String[] options = line.split(" ");
					int amount;
					
					if(options[0].equals("withdraw")) { 
						try {
							amount = Integer.parseInt(options[1]);
						    if(amount < 0) {
						    	amount = -1;
							    System.out.println("Invalid amount");	
						    }
						  } catch (NumberFormatException nfe) {
							  amount = -1;
						    System.out.println("Invalid amount");
						  } catch (ArrayIndexOutOfBoundsException aioe) {
							  amount = -1;
							  System.out.println("Invalid amount");
						  }
						
						if(amount > 0 && amount <= curracc.getBalance()) {
							curracc.setBalance(curracc.getBalance() - amount);
							System.out.println("Withdrew " + amount + " from " + curracc.getAccountName());
							UPDATE(curracc);
							EDIT(args[0]);
							return null;
						}
						System.out.println("Not enough funds.");
					} else if(options[0].equals("deposit")) { 
						try {
							amount = Integer.parseInt(options[1]);
						    if(amount < 0) {
						    	amount = -1;
							    System.out.println("Invalid amount");	
						    }
						  } catch (NumberFormatException nfe) {
							  amount = -1;
						    System.out.println("Invalid amount");
						  } catch (ArrayIndexOutOfBoundsException aioe) {
							  amount = -1;
							  System.out.println("Invalid amount");
						  }
						
						if(amount > 0) {
							curracc.setBalance(curracc.getBalance() + amount);
							System.out.println("Deposited " + amount + " into " + curracc.getAccountName());
							UPDATE(curracc);
							EDIT(args[0]);
							return null;
						}
					} else if(options[0].equals("transfer")) { 
						try {
							amount = Integer.parseInt(options[1]);
						    if(amount < 0) {
						    	amount = -1;
							    System.out.println("Invalid amount");	
						    }
						  } catch (NumberFormatException nfe) {
							  amount = -1;
						    System.out.println("Invalid amount");
						  } catch (ArrayIndexOutOfBoundsException aioe) {
							  amount = -1;
							  System.out.println("Invalid amount");
						  }
						
						if(amount > 0 && amount <= curracc.getBalance()) {
							
							boolean accountExists = false;
							String otherInput = "";
							while(!accountExists) {
								System.out.println("Please enter a valid account to transfer to.");
								if(input.hasNextLine()) {
									otherInput= input.nextLine();
									if(otherInput.equals("exit")) {
										return null;
									}
									for(Account acc : accounts) {
										if(otherInput.equals(acc.getAccountName())) {
											accountExists = true;
											other = acc;
											break;
										}
									}
								}
							}
							
							
							curracc.setBalance(curracc.getBalance() - amount);
							other.setBalance(other.getBalance() + amount);
							System.out.println("Transfered " + amount + " from " + curracc.getAccountName() + " to " + other.getAccountName()); 
							UPDATE(curracc);
							UPDATE(other);
							EDIT(args[0]);
							return null;
						}
						System.out.println("Not enough funds.");
					} else if(options[0].equals("exit")) {
						return null;
					} else {
						System.out.println("Invalid Option.");
					}
				}
			}
		}
		
		//ADMIN & Employee approval
		if(!curracc.isApproved() && (Session.currentSession().adminIsLoggedIn() || Session.currentSession().employeeIsLoggedIn())) {
			
			System.out.println("Balance: " + curracc.getBalance());
			System.out.println("Primary Owner: " + curracc.getOwnerName());
			if(curracc.isJoint()) {
				System.out.println("joint Owner: " + curracc.getJointOwnerName());
			}
			System.out.println("Enter \"approve\" to approve the account, or \"deny\" to deny it.");
			boolean validOption = false;
			
			while(validOption == false) {
				if(input.hasNextLine()) {
					String line = input.nextLine();
					String[] options = line.split(" ");
					
					if(options[0].equals("approve")) { 
						System.out.println("Account approved.");
						curracc.setApproved(true);
						UPDATE(curracc);
						return null;
					} else if(options[0].equals("exit")) {
						return null;
					} else if(options[0].equals("deny")) {
						AccountsController.getInstance().DELETE(curracc.getAccountName());
						System.out.println("Account denied.");
						return null;
					} else {
						System.out.println("Invalid Option.");
					}
				}
			}
		
		}
		
		//EMPLOYEE
		if(Session.currentSession().employeeIsLoggedIn() && curracc.isApproved()) {
			System.out.println("Balance: " + curracc.getBalance());
			System.out.println("Primary Owner: " + curracc.getOwnerName());
			if(curracc.isJoint()) {
				System.out.println("joint Owner: " + curracc.getJointOwnerName());
			}
		}
		
		
		//ADMIN
		if(Session.currentSession().adminIsLoggedIn() && curracc.isApproved()) {
			
			System.out.println("Balance: " + curracc.getBalance());
			System.out.println("Primary Owner: " + curracc.getOwnerName());
			if(curracc.isJoint()) {
				System.out.println("joint Owner: " + curracc.getJointOwnerName());
			}
			
			System.out.println("Enter \"withdraw\", \"deposit\", or \"transfer\" followed by the amount.");
			System.out.println("Enter \"cancel\" to cancel the account.");
			
			
			boolean validOption = false;
			
			
			while(validOption == false) {
				if(input.hasNextLine()) {
					String line = input.nextLine();
					String[] options = line.split(" ");
					int amount;
					
					if(options[0].equals("withdraw")) { 
						try {
							amount = Integer.parseInt(options[1]);
						    if(amount < 0) {
						    	amount = -1;
							    System.out.println("Invalid amount");	
						    }
						  } catch (NumberFormatException nfe) {
							  amount = -1;
						    System.out.println("Invalid amount");
						  } catch (ArrayIndexOutOfBoundsException aioe) {
							  amount = -1;
							  System.out.println("Invalid amount");
						  }
						
						if(amount > 0 && amount <= curracc.getBalance()) {
							curracc.setBalance(curracc.getBalance() - amount);
							System.out.println("Withdrew " + amount + " from " + curracc.getAccountName());
							UPDATE(curracc);
							EDIT(args[0]);
							return null;
						}
						System.out.println("Not enough funds.");
					} else if(options[0].equals("deposit")) { 
						try {
							amount = Integer.parseInt(options[1]);
						    if(amount < 0) {
						    	amount = -1;
							    System.out.println("Invalid amount");	
						    }
						  } catch (NumberFormatException nfe) {
							  amount = -1;
						    System.out.println("Invalid amount");
						  } catch (ArrayIndexOutOfBoundsException aioe) {
							  amount = -1;
							  System.out.println("Invalid amount");
						  }
						
						if(amount > 0) {
							curracc.setBalance(curracc.getBalance() + amount);
							System.out.println("Deposited " + amount + " into " + curracc.getAccountName());
							UPDATE(curracc);
							EDIT(args[0]);
							return null;
						}
					} else if(options[0].equals("transfer")) { 
						try {
							amount = Integer.parseInt(options[1]);
						    if(amount < 0) {
						    	amount = -1;
							    System.out.println("Invalid amount");	
						    }
						  } catch (NumberFormatException nfe) {
							  amount = -1;
						    System.out.println("Invalid amount");
						  } catch (ArrayIndexOutOfBoundsException aioe) {
							  amount = -1;
							  System.out.println("Invalid amount");
						  }
						
						if(amount > 0 && amount <= curracc.getBalance()) {
							
							boolean accountExists = false;
							String otherInput = "";
							while(!accountExists) {
								System.out.println("Please enter a valid account to transfer to.");
								if(input.hasNextLine()) {
									otherInput= input.nextLine();
									if(otherInput.equals("exit")) {
										return null;
									}
									for(Account acc : accounts) {
										if(otherInput.equals(acc.getAccountName())) {
											accountExists = true;
											other = acc;
											break;
										}
									}
								}
							}
							
							
							curracc.setBalance(curracc.getBalance() - amount);
							other.setBalance(other.getBalance() + amount);
							System.out.println("Transfered " + amount + " from " + curracc.getAccountName() + " to " + other.getAccountName()); 
							UPDATE(curracc);
							UPDATE(other);
							EDIT(args[0]);
							return null;
						}
						System.out.println("Not enough funds.");
					} else if(options[0].equals("exit")) {
						return null;
					} else if(options[0].equals("cancel")) {
						AccountsController.getInstance().DELETE(curracc.getAccountName());
						System.out.println("Account canceled.");
						return null;
					} else {
						System.out.println("Invalid Option.");
					}
				}
			}
		}
		
		
		return null;
	}

	@Override
	public Account UPDATE(Account arg) {
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts = IO.ReadFile(Account.fileName, accounts);
		Account oldacc = null;
		
		for(Account ac : accounts) {
			if(ac.getAccountName().equals(arg.getAccountName())) {
				oldacc = ac;
			}
		}
		
		accounts.remove(oldacc);
		accounts.add(arg);
		
		IO.writeFile(Account.fileName, accounts);
		return null;
	}

	@Override
	public void DELETE(String... args) {
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts = IO.ReadFile(Account.fileName, accounts);
		Account oldacc = null;
		
		for(Account ac : accounts) {
			if(ac.getAccountName().equals(args[0])) {
				oldacc = ac;
			}
		}
		
		accounts.remove(oldacc);
		
		IO.writeFile(Account.fileName, accounts);
		return;
		
	}

}
