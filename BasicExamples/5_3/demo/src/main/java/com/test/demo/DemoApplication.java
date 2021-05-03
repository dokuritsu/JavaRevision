package com.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication extends Book{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		/* Same class & same package scenario
		*/
		Employee one = new Employee();
		one.setFirstName("John");
		one.setLastName("Stevens");
		one.setAge(25);
		one.setEmployeeID(1);

		// Direct access
		System.out.println(one.firstName);	//No modifier allows access (default)
		System.out.println(one.lastName);
		System.out.println(one.age);		// Protected modifer allows access
		//System.out.println(one.id);			// Private will not allow access without getter
		System.out.println(one.getEmployeeID()); // Allowed

		/*	Subclass & same package
		*/
		DemoApplication da = new DemoApplication();
		System.out.println(da.series);	// series visible to subclass
		System.out.println(da.title);	// title visible to subclass
		//System.out.println(da.author);	// author not visible to subclass
	
		Book a = new Book();
		//System.out.println(a.author);	// still not visible
	}

}
