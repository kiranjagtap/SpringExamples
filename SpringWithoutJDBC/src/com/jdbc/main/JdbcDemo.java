package com.jdbc.main;

import com.jdbc.dao.JdbcDaoImpl;
import com.jdbc.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
	
		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println("ID=> "+circle.getId());
		System.out.println("NAME=> "+circle.getName());
		
	}

}
