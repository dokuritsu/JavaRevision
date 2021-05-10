package com.capgemini.required;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class RequiredApplication {

	public static void main(String[] args) {
		// SpringApplication.run(RequiredApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

		Student student = (Student) context.getBean("student");
		System.out.println("Name: " + student.getName());
		System.out.println("Age : " + student.getAge());
	}

}
