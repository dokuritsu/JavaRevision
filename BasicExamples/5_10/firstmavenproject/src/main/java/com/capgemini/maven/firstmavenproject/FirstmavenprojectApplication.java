package com.capgemini.maven.firstmavenproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FirstmavenprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstmavenprojectApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		Employee e = (Employee) context.getBean("obj");
		System.out.println(e.getName());
		System.out.println(e.getId());
	}

}
