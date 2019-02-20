package banking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Admin extends Employee{

	public Admin(String username) {
		super(username);
	}
	public Admin(String username, String password) {
		String contents = username + ":" + password + "\n";
		OutputStream os = null;
		File file = new File("Admin.txt");
		try {
			os = new FileOutputStream(file, true);
			os.write(contents.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// edit account
	public void editAccount(Integer accountID) {
		// This is actually hard. I can't just access the field and edit it, like I will be able to do in SQL
			// Hmm this will remain TBD for now.
	}
	
	// close account
	public void closeAccount(Integer accountID) {
		// This is actually hard. I can't just access the field and edit it, like I will be able to do in SQL
			// Hmm this will remain TBD for now.
	}
}
