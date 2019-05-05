package com.kiran.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Main {

/*	public static void drawShape(Shape shape){
		shape.draw();
	}*/
	public static void main(String[] args) {
		
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		AbstractApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
	/*	Triangle  triangle = (Triangle) context.getBean("child");  
 		triangle.draw();
	*/
		Circle circle =(Circle) context.getBean("circle");
		circle.draw();
	}

}
