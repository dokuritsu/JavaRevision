package com.capgemini.firstspingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FirstspingprojectApplication {

	public static void main(String[] args) {
		// SpringApplication.run(FirstspingprojectApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		JavaCollection jc=(JavaCollection)context.getBean("javaCollection");

		jc.getAddressList();
		jc.getAddressSet();
		jc.getAddressMap();
		jc.getAddressProp();
	}

}
