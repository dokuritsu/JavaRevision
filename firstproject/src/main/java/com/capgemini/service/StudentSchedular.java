package com.capgemini.service;

import com.capgemini.beans.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Hashtable;

public class StudentSchedular {
    // Adding data
    private ArrayList<Student> students = new ArrayList<Student>();
    private Hashtable<String, Integer> storage = new Hashtable<>();

    /*
        Adds new student objects to students Arraylist
    */
    public String addStudent(int rollNumber, String name, String[] courseNames){
        if(students.size() != 0){
            // Before creating object, check if student exists thru rollNum
            for(int i = 0; i < students.size(); i++){
                Student st = students.get(i);
                if(st.getRollNumber() == rollNumber){
                    return "Student already exists within roster. Please use choice 2 to view student info.\n";
                }
            }
            students.add(new Student(rollNumber, name, courseNames));
            updateHash(courseNames);
        } else {
            students.add(new Student(rollNumber, name, courseNames));
            updateHash(courseNames);
        }
        return "Student was successfully added to Student List\n";
    }

    /*
        Displays all the information of students
    */
    public void showAllStudentData(){
        if(students.size() != 0){
                // Create scanner
            Scanner sc = new Scanner(System.in);

            // Ask if user would liek to view specific student info or all
            System.out.println("Please choose from one of the choices below:");
            System.out.println("1. View specific student info");
            System.out.println("2. View all student info");
            System.out.println("3. View students details by course name");
            int choice = sc.nextInt();

            System.out.println("\nChoice was: " + choice);

            switch(choice){
                case 1:
                    // Ask for rollNum of student
                    System.out.println("Please insert roll number for student");
                    int rollNum = sc.nextInt();

                    // Find student
                    for(Student stu: students){
                        if(stu.getRollNumber() == rollNum){
                            System.out.println("\nStudent Name: " + stu.getName());
                            System.out.println("Student Roll Number: " + stu.getRollNumber());
                            System.out.println("Student Courses: " + Arrays.toString(stu.getCourseNames()) + "\n");
                        }
                    }
                    break;
                case 2:
                    // Swich case for the above
                    for(Student stu: students){
                        System.out.println("\nStudent Name: " + stu.getName());
                        System.out.println("Student Roll Number: " + stu.getRollNumber());
                        System.out.println("Student Courses: " + Arrays.toString(stu.getCourseNames()) + "\n");
                    }
                    break;
                case 3:
                    System.out.println(storage + "\n");
                    break;
                default:
                    System.out.println("Please select one of the choices above.");
            }
        } else {
            System.out.println("Please enter a student first.\n");
        }
    }

    /*
        Method to update information on how many students per course
        The only method I could think of without a massive headache forming
    */
    public void updateHash(String[] courseNames){
        // When creating student object, update info on courses-to-student
        for(String course:courseNames){
            // Check if course exists in hashtable
            if(storage.containsKey(course)){
                // increment val
                storage.put(course, storage.get(course) + 1);
                // System.out.println("Course: " + course + ", Val: " + storage.get(course));
            } else {
                storage.put(course, 1);
                // System.out.println("Course: " + course + ", Val: " + storage.get(course));
            }
        }
    }
}