package com.revature.fileIO;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;

import com.revature.beans.User;
/*Do not run test if the files in users.txt are important
 * it will over write them
 * 
 */
public class FileIOTest {

	@BeforeClass
	public static void beforeAll(){
		System.out.println("Starting file IO test:");
	}
	
	@BeforeEach
	public void beforeEach(TestInfo info) {
		System.out.println("Initializing data for : "+info.getDisplayName());
	}

	@Test
	@DisplayName("read/write user file")
	public void userFile() {
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User("random","strings","for test"));
		FileIO.writeUserFile(users);
		ArrayList<User> usersRead =  FileIO.readUserFile();
		assertEquals(users.get(0).getName(),usersRead.get(0).getName());
		assertEquals(users.get(0).getUsername(),usersRead.get(0).getUsername());
		assertEquals(users.get(0).getPassword(),usersRead.get(0).getPassword());
	}

}
