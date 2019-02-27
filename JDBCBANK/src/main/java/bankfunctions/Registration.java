package bankfunctions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import bankdata.ConnFactory;
import bankdata.CustomerDao;
import bankdata.UserInfo;
import bankdata.Writers;

public class Registration {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	static UserInfo z = new UserInfo();
	
	static void personalInfo(String x) {
		
	//CustomerDao data = new CustomerDao();
	
	Scanner s = new Scanner(System.in);	
	Scanner s2 = new Scanner(System.in);	
	Scanner s3 = new Scanner(System.in);	
	Scanner s4 = new Scanner(System.in);
	
	
	
	
	System.out.println("Enter a username");
	String userInput = s.nextLine();
	
	z.setUsername(userInput);
	System.out.println("Enter a password");
	String userInput2 = s2.nextLine();
	
	z.setPassword(userInput2);
	System.out.println("Enter full name");
	String userInput3= s3.nextLine();
	
	z.setName(userInput3);
	System.out.println("Enter social security number");
	String userInput4 = s4.nextLine();
	
	z.setSocial(userInput4);
	
	
	System.out.println(" Account Creation Is Successful");
	personalSave();
	try {
		if(x.equals(Admin.adminid))
		{
			Admin.adminPortal(x);
		}
		else {
			BankMenu.menuStart();
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	s.close();
	s2.close();
	s3.close();
	s4.close();
	
	
	}
	
	
	static void personalSave ()
	{
		//maybe save this to database?
		CustomerDao data = new CustomerDao();
		
		try {
			data.createCustomers(z.indentify(), z.getUsername(), z.getPassword(), z.getName(), z.getSocial());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*ArrayList<String> saver = new ArrayList<String>();
		saver.add(z.indentify());
		saver.add(z.getUsername());
		saver.add(z.getPassword());
		saver.add(z.getName());
		saver.add(z.getSocial());
		Writers.fileWrites(saver);
		System.out.println(saver.toString());*/
	}
	
	
	
	
	
	
}
