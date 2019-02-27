// David Lavoie Banking App
// This is the superclass of basically anyone who uses the app
package banking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class User {
		// This is an immutable set of acceptable usertypes.
	private final static Set<String> USERTYPES = Collections.unmodifiableSet(
			new	HashSet<String>(Arrays.asList("Customer","Admin")));
	//
	private String username;
	private String password;
	private String realname;
	private Integer SSD;
	private Boolean approved;
	
	public User(String username, String password, String name, int SSD, boolean approved) {
		this.username = username;
		this.password = password;
		this.realname = name;
		this.SSD = SSD;
		this.approved=approved;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getSSD() {
		return SSD;
	}

	public void setSSD(Integer sSD) {
		SSD = sSD;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public void display() {
		System.out.println("Username: " + this.username);
		System.out.println("Real name: " + this.realname);
		System.out.println("Social Security #: " + this.SSD.toString());
	}
}
