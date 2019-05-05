package com.kiran.di;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware,BeanNameAware,BeanFactoryAware,Shape{
	
	ApplicationContext context;
	
	Point pointA;
	Point pointB;
	Point pointC;
	
	
	
	
	public Point getPointA() {
		return pointA;
	}


	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}


	public Point getPointB() {
		return pointB;
	}


	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}


	public Point getPointC() {
		return pointC;
	}


	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}


	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		System.out.println("context initialize "+context.getApplicationName());
		
	}


	@Override
	public void setBeanName(String name) {
		System.out.println("Bean name is "+name);
	}


	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	
	public void draw() {
		System.out.println("PointA"+"("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("PointB"+"("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("PointC"+"("+getPointC().getX()+","+getPointC().getY()+")");
		
	}


	public void myInit() throws Exception {
		System.out.println("Initializing Bean");
	}


	
	public void destroy() throws Exception {
		System.out.println("Destroy Bean");
	}
}
