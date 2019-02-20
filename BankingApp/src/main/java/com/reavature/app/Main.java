package com.reavature.app;

import com.reavature.location.Home;
import com.reavature.service.UserService;
import com.revature.io.FileIO;

public class Main {

	public static void main(String[] args) {
		if (FileIO.isAdmin() == false) {
			UserService.createAdmin();
		}
		new Home().display();
	}

}
