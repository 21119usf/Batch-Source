package com.revature.project0.classes;

import java.util.ArrayList;

public class AdminManager 
{
	private static ArrayList<Administrator> adminList = new ArrayList<Administrator>();

	public static ArrayList<Administrator> getAdminList() {
		return adminList;
	}

	public static void setAdminList(ArrayList<Administrator> adminList) 
	{
		AdminManager.adminList = adminList;
	}
	
	public void addNewAdministrator(Administrator admin)
	{
		adminList.add(admin);
	}
	
	public Administrator findAdmin(String username)
	{
		Administrator foundAdmin = null;
		
		for(Administrator admin : adminList)
		{
			if(admin.getUsername().equals(username))
			{
				foundAdmin = admin;
			}
		}
		
		return foundAdmin;
	}
	
}
