package com.revature.bap1;

import java.util.Scanner;

public class UserInput {
	
	private int intNum;
	private double doubleNum;
	
	Scanner scanner;
	
	public void openScanner() {
		scanner = new Scanner(System.in);
	}
	
	public void closeScanner() {
		scanner.close();
	}
	
	public String scan() {
		return scanner.nextLine();
	}
	
	public int getIntNum() {
		return this.intNum;
	}
	
	public double getDoubleNum() {
		return this.doubleNum;
	}
	
	public boolean isInt() {		
		try {
			intNum = Integer.parseInt(scan());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public boolean isDouble() {
		try {
			doubleNum = Double.parseDouble(scan());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
