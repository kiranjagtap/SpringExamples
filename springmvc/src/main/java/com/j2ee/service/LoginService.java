package com.j2ee.service;


public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("dummy") && password.equals("dummy");
	}

}