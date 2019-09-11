package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		// Triangle t = new Triangle();
		// t.draw();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//context.registerShutdownHook();
		Triangle triangle = context.getBean("triangle", Triangle.class);
		triangle.draw();

		/*
		 * Circle circle = context.getBean("circle", Circle.class); circle.draw();
		 */
	}
}
