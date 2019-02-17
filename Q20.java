package com.revature.homework;

import java.io.FileWriter; 
import java.io.IOException; 

class Q20 { 
    public static void main(String[] args) throws IOException 
    { 
        // Accept a string  
        String str = "File Handling in Java using "+ 
                " FileWriter... Roll Tide"; 
  
        // attach a file to FileWriter  
        FileWriter fw=new FileWriter("homeworkWriting.txt"); 
  
        // read character wise from string and write  
        // into FileWriter  
        for (int i = 0; i < str.length(); i++) 
            fw.write(str.charAt(i)); 
  
        System.out.println("Writing successful"); 
        //close the file  
        fw.close(); 
    } 
}