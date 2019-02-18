package com.revature.hw1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Prob20io {

	// Java Program to illustrate reading from Text File 
	// using Scanner Class 
	
	public static void main(String[] args) throws Exception 
	{ 
 
		try {
            //Open up file reader
            FileInputStream fileStr = new FileInputStream("C:\\Users\\Dustyn\\Desktop\\Data.txt");

            //wrap the file reader in a buffer
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileStr));

            String streamLine; //gonna be catching the characters that will be read

            //while loop that keeps running while there is lines
            while((streamLine = fileReader.readLine()) != null) {
                //the streamLine is getting split when it encounters a :  and stores in the strmToken
                String[] streamToken = streamLine.split(":");

                //prints out in format needed
                System.out.println("Name: " + streamToken[0] + " " + streamToken[1] + "\n" + "Age: " + streamToken[2] + " years\n" + "State: " + streamToken[3] + " state\n\n");
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





