package com.capgemini.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@SpringBootApplication
public class BeanfactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanfactoryApplication.class, args);

		// For Bean factory either in root folder or classpath resource
		// Resource resource = new FileSystemResource("Bean.xml");
		ClassPathResource resource = new ClassPathResource("Bean.xml");

		// Create BeanFactory
		BeanFactory factory = new XmlBeanFactory(resource);

		Employee e = factory.getBean("obj", Employee.class);

		System.out.println(e.getName());
		System.out.println(e.getId());


	}

}
