package com.capgemini.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.service.StudentSchedular;

import java.util.Scanner;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);

		// Create StudentSchedular object
		StudentSchedular ss = new StudentSchedular();

		// Creating a scanner
		Scanner scan = new Scanner(System.in);

		// Indicator for closing program
		boolean exit = false;

		// Create a while loop to keep program running
		while(!exit){
			// Creating a menu
			System.out.println("Please choose frome one of the objects below: ");
			System.out.println("1. Adding a student");
			System.out.println("2. Displaying student information");
			System.out.println("3. Exit");

			int choice = scan.nextInt();
			System.out.println("\n");

			// Inform user of choice
			System.out.println("Your choice was: " + choice + "\n");


			// Switch cases for menu
			switch(choice){
				case 1:
					// Ask for basic student info
					System.out.println("Please enter the student roll number");
					int rollNum = scan.nextInt();
					scan.nextLine();	// Consume leftover newline
					System.out.println("\nPlease enter the student name");
					String studentName = scan.nextLine();

					// Identifying courses
					System.out.println("\nPlease enter the total amount of courses for the student");
					int totalCourses = scan.nextInt();
					scan.nextLine();	//Consume leftover newline
					String[] courses = new String[totalCourses];
					
					System.out.println("\nPlease enter the name of each course");
					for(int i = 0; i < totalCourses; i++){
						courses[i] = scan.nextLine();
					}

					// Add student
					System.out.println(ss.addStudent(rollNum, studentName, courses));
					break;
				case 2:
					ss.showAllStudentData();
					break;
				case 3:
					exit = true;
					System.out.println("Exiting..." + "\n");
					break;
				default:
					System.out.println("Please select one of the choices above.");
			}
		}
	scan.close();
	System.exit(0);
	}

}
