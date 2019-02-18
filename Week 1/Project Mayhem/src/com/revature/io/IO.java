package com.revature.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {

	public void writeOutputStreamContents(String conents) {
		OutputStream os = null;
		File file = new File("output.txt"); 
		//false would overwrite, true appends to end 
		try{
			os = new FileOutputStream(file, true); 
			os.write(contents.getBytes()); 
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readInputStreamContents() {
		InputStream is = null; 
		File file = new File(inFile); 
		StringBuilder s = new StringBuilder(); 
	
	try {
		is = new FileInputStream(file); 
		
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	
	}
}
