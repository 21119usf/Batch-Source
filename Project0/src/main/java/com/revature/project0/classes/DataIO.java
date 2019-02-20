package com.revature.project0.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;

public class DataIO 
{	
	private static final String DATA_FILE_NAME = "Data.ser";
	
	public void importData()
	{
		File file = new File(DATA_FILE_NAME);
		
		if(file.exists())
		{
			try 
			{
				ObjectInputStream objectInputStream = new ObjectInputStream(new 
						FileInputStream(DATA_FILE_NAME));
				CustomerManager.setAccountOwnershipMap(((Map<Customer, Account>) objectInputStream.readObject()));
				AccountManager.setAccountOwnershipMap(((Map<Account, Customer>) objectInputStream.readObject()));
				ApplicationManager.setApplicationOwnershipMap(((Map<AccountApplication, Customer>) objectInputStream.readObject()));
				EmployeeManager.setEmployeeList(((ArrayList<Employee>) objectInputStream.readObject()));
				AdminManager.setAdminList(((ArrayList<Administrator>) objectInputStream.readObject()));
				
				objectInputStream.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void exportData()
	{
		try 
		{
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new 
					FileOutputStream(DATA_FILE_NAME));
			objectOutputStream.writeObject(CustomerManager.getAccountOwnershipMap());
			objectOutputStream.writeObject(AccountManager.getAccountOwnershipMap());
			objectOutputStream.writeObject(ApplicationManager.getApplicationOwnershipMap());
			objectOutputStream.writeObject(EmployeeManager.getEmployeelist());
			objectOutputStream.writeObject(AdminManager.getAdminList());
			
			objectOutputStream.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
