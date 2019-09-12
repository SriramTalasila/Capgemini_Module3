package com.cg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cg")
public class Configuartion {

	@Bean
	public Customer customer() {
		Customer cus = new Customer();
		cus.setId(1001);
		cus.setName("sriramm");
		return cus;
	}

	@Bean
	public Customer cust() {
		Customer cus = new Customer();
		cus.setId(1002);
		cus.setName("prasad");
		return cus;
	}

	@Bean
	public Point center() {
		Point p = new Point();
		p.setX(10);
		p.setY(20);
		return p;
	}

}
