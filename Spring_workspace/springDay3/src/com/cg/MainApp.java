package com.cg;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		/* String message = context.getMessage("greeting", null, "Default", null); */
		Circle circle = context.getBean("circle", Circle.class);
		circle.draw();
		
		MessageSource messageSource = context.getBean("messageSource",MessageSource.class);
		Locale local=new Locale("in","TG");
        String str=messageSource.getMessage("welcome.message", null, "Defaulte Message", local);
        System.out.println(str);
		// System.out.println(message);
	}
}
