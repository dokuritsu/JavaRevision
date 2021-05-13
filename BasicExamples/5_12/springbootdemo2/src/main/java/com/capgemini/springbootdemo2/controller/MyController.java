package com.capgemini.springbootdemo2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springbootdemo2.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MyController {
    @GetMapping(value="/hello")
    public String sayHello() {
        return "Hello Spring World!";
    }

    @GetMapping("/employee")
    public Employee showEmployee(){
        Employee e = new Employee();
        e.setId(101);
        e.setAge(24);
        e.setName("Laura");

        return e;
    }

    @GetMapping("/employee2")
    public String title(){
        return "This is the title of the page: Employee";
    }
    
}
