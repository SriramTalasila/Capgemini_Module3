package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		/*
		 * AbstractApplicationContext context = new
		 * ClassPathXmlApplicationContext("spring.xml"); context.registerShutdownHook();
		 * 
		 * Triangle triangle = context.getBean("triangle", Triangle.class);
		 * triangle.draw();
		 * 
		 * 
		 * 
		 * Circle circle = context.getBean("circle", Circle.class); circle.draw();
		 * 
		 * 
		 * 
		 * Employee emp = context.getBean("employee",Employee.class);
		 * System.out.println(emp.getDob());
		 */

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Configuartion.class);
		Customer cust1 = context.getBean("customer", Customer.class);
		Customer cust2 = context.getBean("cust", Customer.class);
		Circle circle = context.getBean("circle", Circle.class);
		circle.draw();
		System.out.println(cust1);
		System.out.println(cust2);
	}
}
