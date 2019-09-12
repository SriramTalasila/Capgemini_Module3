package com.cg;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Circle
/*
 * implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware,
 * ApplicationContextAware
 */ {
	@Resource
	private Point center;

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		System.out.println("Circle Points (" + center.getX() + "," + center.getY() + ")");
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
