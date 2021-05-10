package com.capgemini.firstspingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FirstspingprojectApplication {

	public static void main(String[] args) {
		// SpringApplication.run(FirstspingprojectApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");

		objA.setMessage("I'm object A");
		objA.getMessage();
	}

}
