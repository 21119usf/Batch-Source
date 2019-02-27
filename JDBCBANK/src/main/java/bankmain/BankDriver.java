package bankmain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bankdata.Balance;
import bankdata.BankAccInfo;
import bankdata.PasswordCheck;
import bankdata.Readers;
import bankfunctions.Admin;
import bankfunctions.BankMenu;
import bankfunctions.Customer;

public class BankDriver {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Admin.getAdmins();
		
		
		try {
			BankMenu.menuStart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
