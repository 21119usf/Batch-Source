package com.revature.classes;

import java.sql.SQLException;
import java.util.ListIterator;

public class AdministratorStuff {

	
	
	public static void getCustomerInfo() throws SQLException 
	{
		CustomerDaoImpl cdi= new CustomerDaoImpl();
		ListIterator<CustomerBean> litr = null;
		litr=cdi.getCustomerList().listIterator();
	
	System.out.println("===========================");
	System.out.println("===    CUSTOMER INFO  =====");
	System.out.println("===========================\n");
	//System.out.println(cdi.getCustomerList());
	 while(litr.hasNext()){
	       System.out.println(litr.next());
	    }
	}
	
	


}
