package bank.application.entities;
import java.util.*; 
import bank.application.accounts.Account;

public class Employee extends User {	
	
	private ArrayList<Customer> customers; 
	private String employeeID;
	private int type_of_entity; 
	
	public Employee(String firstname, String lastname, String address, String userID, String email, String pn) 
	{
		super(firstname, lastname, address, userID, email, pn);
		Random rd = new Random(); 
		customers = new ArrayList<Customer>();  
		employeeID = "" + firstname.charAt(0) +  lastname.charAt(0) + rd.nextInt(999);
		// TODO Auto-generated constructor stub
	}
	
	//Approve account
	public void approve_account(Account acc) {
		//
		acc.getCustomer().setApplyJointAccount(true);
		acc.getCustomer().setLevel_of_approval(2);
	}

	//
	public String getEmployeeID() {
		return employeeID;
	}
	
	public void viewCustomerInfo(Customer c) {
		System.out.println("---------------------");
		System.out.println("Customer Information");
		System.out.println("---------------------");
		System.out.println("First Name: " + c.getFirstname());
		System.out.println("Last Name: " + c.getLastname());
		System.out.println("First Name: " + c.getFirstname());
		System.out.println("Address: " + c.getAddress());
		System.out.println("UserID: " + c.getUserID());
		System.out.println("Phone Number: " + c.getFirstname());
	}
	//setter and getters 
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	//view customer info
	public void seeCustomerInfo(Account acc) {
		acc.getCustomer().toString(); 
	}
	
	//employee info
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", phone_number=" + phone_number + ", userID=" + userID + "]";
	}
	
	
	
	
}
