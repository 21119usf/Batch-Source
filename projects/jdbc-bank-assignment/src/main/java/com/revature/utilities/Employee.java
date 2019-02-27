package com.revature.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Employee {
	private String username;
	private String password;
	
	public Employee() throws FileNotFoundException {
		super();
		getInfo();
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	private void getInfo() throws FileNotFoundException {
		File file = new File("employee.properties");		
		Scanner sc = new Scanner(file);		
		String line;
		String[] split;		
		
		line = sc.nextLine();
		split = line.split("=");
		username = split[1];
		
		line = sc.nextLine();
		split = line.split("=");
		password = split[1];
		
		sc.close();
	}
}
