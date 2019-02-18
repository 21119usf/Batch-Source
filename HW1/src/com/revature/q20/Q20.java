package com.revature.q20;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20 {

	public static void main(String[] args) {
		
		//My current file path
		//C:\\Users\\Frank\\Documents\\workspace-sts-3.9.4.RELEASE\\HW1\\src\\com\\revature\\q20\\Data.txt
			
		try {
			//Open up file reader
			FileInputStream fileStr = new FileInputStream("C:\\Users\\Frank\\Documents\\workspace-sts-3.9.4.RELEASE\\HW1\\src\\com\\revature\\q20\\Data.txt");

			//wrap the file reader in a buffer
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileStr));
			
			String streamLine; //gonna be catching the characters that will be read
			
			//while loop that keeps running while there is lines
			while((streamLine = fileReader.readLine()) != null) {
				//the streamLine is getting split when it encounters a :  and stores in the strmToken
				String[] strmToken = streamLine.split(":");
				
				/*
					printing in the following format per line
					Name: Mickey Mouse
					Age: 35 years
					State: Arizona State
				 */
				System.out.println("Name: " + strmToken[0] + " " + strmToken[1] + "\n" + "Age: " + strmToken[2] + " years\n" + "State: " + strmToken[3] + " state\n\n");
			}
		

			//close filestream
			fileStr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
