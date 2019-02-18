package com.revature.question20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IO {
	public String readData() {
		//initialize input stream
		InputStream is = null;
		//opening Data file
		File data = new File("Data.txt");
		StringBuilder s = new StringBuilder();
		
		try {
			//assigning data file to input stream
			is = new FileInputStream(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int b = 0;
		
		try {
			while ((b = is.read()) != -1) {
				char c = (char)b;
				s.append(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (is != null) {
			try {
				//closing access
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//return the data as a string
		return s.toString();
		
		
}
}
