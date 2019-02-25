package com.revature.service;

import com.reavture.beans.User;

public interface CanEnter {
	public void login(String username, String password);
	public void register(User u, String password);
}

