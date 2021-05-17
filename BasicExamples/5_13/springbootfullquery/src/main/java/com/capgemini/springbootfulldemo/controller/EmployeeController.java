package com.capgemini.springbootfulldemo.controller;

import java.util.List;
import java.util.Optional;

import com.capgemini.springbootfulldemo.entity.Employee;
import com.capgemini.springbootfulldemo.exceptions.EmployeeNotFoundException;
import com.capgemini.springbootfulldemo.exceptions.ExistingEmployeeException;
import com.capgemini.springbootfulldemo.service.EmployeeService;
import com.capgemini.springbootfulldemo.service.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
        try {
            return employeeService.getEmployeeById(empId);
        } catch (EmployeeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    // @GetMapping("employee/{empId}")
    // public ResponseEntity<Employee> getEmployeeById(@PathVariable String empId){
    //     return employeeService.getEmployeeById(empId);

    // }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee emp){
        try {
            return employeeService.addEmployee(emp);
        } catch (ExistingEmployeeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    } 

    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestBody Employee emp){
        employeeService.deleteEmployee(emp);
    }

    @PutMapping("/employee/{empId}")
    public Employee updateEmployee(@PathVariable String empId, @RequestBody Employee e){
        try {
            return employeeService.updateEmployee(empId, e);
        } catch (EmployeeNotFoundException e1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e1.getMessage());
        }
    }

    @GetMapping("/employees/searchname/{eName}")
    public List<Employee> getEmployeeInfoByName(@PathVariable String eName){
        return employeeService.getEmployeeInfoByName(eName);
    }

    @GetMapping("/employees-by-salrange/{low}/{high}")
    public List<Employee> getEmployeeInfoBySalRange(@PathVariable double low, @PathVariable double high){
        return employeeService.getEmployeesBySalRange(low, high);
    }
}
