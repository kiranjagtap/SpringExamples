package com.kiran.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware{

	private Point center;
	@Autowired
	private MessageSource messageSource;
	
	private ApplicationEventPublisher publisher;
	
	

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}

	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}


	@PostConstruct
	public void initCircle() {
		System.out.println("Initialize Circle");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroying Circle");
	}
	public void draw() {
		System.out.println("Drawing Circle");
		//System.out.println("Circle point is:("+center.getX()+", "+ center.getY()+")");
		
		DrawEvent drawEvent = new DrawEvent(this);
		
		System.out.println(this.messageSource.getMessage("text", null, "Default message", null));
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(),center.getY()}, "Default point message", null));
		publisher.publishEvent(drawEvent);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
}
