package com.revature.bankingapp;

public class IOFileReadWrite {

	public static void fileReadWrite() {
		IOFile.readUserFile();
		for(int i = 0; i<IOFile.userCust.size();i++) {
			IOFile.userCust.add(IOFile.userCust.get(0));			
		}
		IOFile.readAccountFile();
		for(int i = 0; i<IOFile.individualList.size();i++) {
			IOFile.individualList.add(IOFile.individualList.get(0));			
		}
		IOFile.readApplicationFile();
	}
}
