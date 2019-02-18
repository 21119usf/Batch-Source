package com.revature.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IO 
{
	public void writeOutputStreamContents(String contents)
	{
		OutputStream os = null;
		
		File file = new File("output.txt");
		
		try 
		{
			//False would override, true would append.
			os = new FileOutputStream(file, true);
			os.write(contents.getBytes());
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(os != null)
		{
			try 
			{
				os.close();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
