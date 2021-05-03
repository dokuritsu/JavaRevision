package com.sub.subclass;

import com.test.demo.Employee;

public class SubClass extends Employee{

    public static void main(String[] args){
        /*  Subclass & different package
            Default, protected, and private do not allow visibility to subclass
            Public allows visibility
        */
        SubClass sc = new SubClass();
        System.out.println(sc.firstName);   // Not visible (default)
        System.out.println(sc.age);         // Not visible (protected)
        System.out.println(sc.favoriteFood); // Visible (public)
        System.out.println(sc.employeeID);  // Not visible (private)
    }
}