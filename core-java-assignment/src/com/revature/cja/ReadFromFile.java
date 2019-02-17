package com.revature.cja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFromFile {
	
	private static final String inFile = "Data.txt";
	
	public String readInputStreamContents() {
		InputStream is = null;
		File file = new File(inFile);
		
		StringBuilder s = new StringBuilder();
		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int b = 0;
		
		try {
			while ((b = is.read()) != -1) {
				char c = (char) b;
				s.append(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return s.toString();
		
	}
	
	public void formatString(String str) {
		String[] formatMsg = str.split("\n");
		for (int i = 0; i < formatMsg.length; i++) {
			String[] eachLine = formatMsg[i].split(":");
			System.out.println("Name: " + eachLine[0] + " " + eachLine[1]);
			System.out.println("Age: " + eachLine[2] + " years");
			System.out.println("State: " + eachLine[3] + " State");
			System.out.println();
		}
	}

}
