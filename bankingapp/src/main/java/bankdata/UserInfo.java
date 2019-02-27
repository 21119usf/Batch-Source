package bankdata;

import java.util.Random;

public class UserInfo {
 private String password;
 private String username;
 private String name;
 private String social;
 
 
 
 public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getSocial() {
	return social;
}



public void setSocial(String social) {
	this.social = social;
}



public  String indentify() {
		// TODO Auto-generated method stub
		//creates new random id number with 4 digits and returns the id number to be used
		Random x = new Random();
	
		Integer idNum = x.nextInt(10000);
		//System.out.printf("%04d", x.nextInt(10000));
		//store value in map
		Integer y = idNum;
		String v = y.toString();
		return v;
	}
 
 
 
}
