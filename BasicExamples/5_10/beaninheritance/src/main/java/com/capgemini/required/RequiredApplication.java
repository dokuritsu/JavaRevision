package com.capgemini.required;

import java.util.ResourceBundle.Control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class RequiredApplication {

	public static void main(String[] args) {
		// SpringApplication.run(RequiredApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

		HelloWorld a = (HelloWorld) context.getBean("helloWorld");
		System.out.println(a.getMessage1());
		System.out.println(a.getMessage2());

		// Note how even thought we did not define a message 2 in bean.xml, because of the parent-child relationship between
		// the beans message 2 was able to be printed
		HelloChicago c = (HelloChicago) context.getBean("helloChicago");
		System.out.println(c.getMessage1());
		System.out.println(c.getMessage2());
		System.out.println(c.getMessage3());


		
	}

}
