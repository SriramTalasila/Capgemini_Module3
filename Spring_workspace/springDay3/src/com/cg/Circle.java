package com.cg;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle {
	@Autowired
	private Point center;
	@Autowired
	MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		String msg = messageSource.getMessage("greeting", null, "Default", null);
		System.out.println(msg);
		String draw = messageSource.getMessage("circle.drawing", null, "Default", null);
		System.out.println(draw);
		String points = messageSource.getMessage("circle.points", new Object[] { center.getX(), center.getY() },
				"No points", null);
		System.out.println(points);
	}

	/*
	 * @Override public void setApplicationContext(ApplicationContext arg0) throws
	 * BeansException { System.out.println("ApplicationContextAware");
	 * 
	 * }
	 * 
	 * @Override public void setBeanFactory(BeanFactory arg0) throws BeansException
	 * { // TODO Auto-generated method stub System.out.println("set bean factory");
	 * 
	 * }
	 * 
	 * @Override public void setBeanName(String arg0) { // TODO Auto-generated
	 * method stub System.out.println("set bean name");
	 * 
	 * }
	 * 
	 * @Override public void afterPropertiesSet() throws Exception {
	 * System.out.println("After properties set of initializing Bean");
	 * 
	 * }
	 * 
	 * @Override public void destroy() throws Exception { // TODO Auto-generated
	 * method stub System.out.println("Disposable bean");
	 * 
	 * }
	 */
	@PostConstruct
	public void starrtUp() {
		System.out.println("creation ");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroyed");
	}
}
