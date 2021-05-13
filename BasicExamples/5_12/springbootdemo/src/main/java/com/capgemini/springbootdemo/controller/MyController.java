package com.capgemini.springbootdemo.controller;

import com.capgemini.springbootdemo.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello world!";
    }

    @GetMapping("/employee")
    public Employee employee(){
        Employee e = new Employee();
        e.setId(101);
        e.setName("Laura");
        return e;
    }
}
