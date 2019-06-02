package com.flipkart.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.dao.LoginDao;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	
	public boolean validateUser(String user, String password) {
		
		//loginDao.validateFromDb(user, password);
		return user.equalsIgnoreCase("dummy") && password.equals("dummy");
	}

}