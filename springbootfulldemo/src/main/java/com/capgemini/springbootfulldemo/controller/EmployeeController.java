package com.capgemini.springbootfulldemo.controller;

import java.util.List;
import java.util.Optional;

import com.capgemini.springbootfulldemo.entity.Employee;
import com.capgemini.springbootfulldemo.service.EmployeeService;
import com.capgemini.springbootfulldemo.service.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployeeDetails(){
        return employeeService.getAllEmployeeDetails();
    }

    @GetMapping("employee/{empId}")
    public Optional<Employee> getEmployeeById(@PathVariable String empId){
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee emp){
        return employeeService.addEmployee(emp);
    } 

    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestBody Employee emp){
        employeeService.deleteEmployee(emp);
    }

    @PutMapping("/employee/{empId}")
    public Employee updateEmployee(@PathVariable String empId, @RequestBody Employee e){
        return employeeService.updateEmployee(empId, e);
    }
}
