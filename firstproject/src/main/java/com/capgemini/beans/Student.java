package com.capgemini.beans;

public class Student {

    // Creating data values
    private int rollNumber;
    private String name;
    private String[] courseNames;

    // Constructors
    public Student(){
        
    }
    public Student(int rollNumber, String name, String[] courseNames) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.courseNames = courseNames;
    }

    // Getters and setters
    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getCourseNames() {
        return courseNames;
    }
    public void setCourseNames(String[] courseNames) {
        this.courseNames = courseNames;
    }
}