package bankdata;

import java.sql.SQLException;
import java.util.ArrayList;

public class BankAccount {
	static UserInfo r = new UserInfo();
	static BankAccountDao b = new BankAccountDao();
	
	public static void bankInfo (String x)
	{
		//admin checks to open account or not if yes else
	try {
		b.createBank(r.indentify(), "0.00", x);
		System.out.println("Your account is successfully created");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}
	
}
