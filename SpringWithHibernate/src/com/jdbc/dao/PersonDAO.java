package com.jdbc.dao;

import java.util.List;

import com.jdbc.model.Person;


public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
