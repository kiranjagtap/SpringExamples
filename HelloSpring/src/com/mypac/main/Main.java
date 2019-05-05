package com.mypac.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello Spring");
		//	drawing.setShape(triangle);
		//drawing.drawShape();
		
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle t=	(Triangle) context.getBean("triangle");
		t.draw();
	}

}
