package com.revature.assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Q20IO  {
	
	private static final String inFile="Data.txt";//file to be read to be referenced by inFile
	
	public String readInputStreamContents() {
		InputStream is = null;//initialize input stream
		File file = new File(inFile);//file saved
		
		StringBuilder s = new StringBuilder();
		try {
			is= new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int b=0;
		
		
		try {
			while((b=is.read()) !=-1){//reading each character
				char c=(char)b;
				s.append(c);
			}
		} 
		
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(is != null) {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	public static void displayStream() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(personFile));
			personList=(ArrayList<Q20Person>)objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static final String inFile="Data.txt";
	
	public String displayStream() {
		InputStream is = null;
		File file = new File(inFile);
		
		StringBuilder s = new StringBuilder();
		try {
			is= new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int b=0;
		try {
			while((b=is.read()) !=-1){
				char c=(char)b;
				s.append(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(is != null) {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s.toString();
	}*/
}
