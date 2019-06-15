package com.jdbc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.dao.JdbcDaoImpl;
import com.jdbc.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		JdbcDaoImpl jdbcDaoImpl = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);

		Circle circle = jdbcDaoImpl.getCircle(1);
		System.out.println("ID=> " + circle.getId());
		System.out.println("NAME=> " + circle.getName());

		Circle circle2 = new Circle(3, "Third Circle");
		jdbcDaoImpl.insert(circle2);

		System.out.println("Count=> " + jdbcDaoImpl.getCircleCount());

		List<Circle> c = jdbcDaoImpl.getCircleObj();
		System.out.println("  ID        NAME");
		
		c.forEach(
				name -> System.out.println("  " + name.getId() + "        " + name.getName()));
	}

}
