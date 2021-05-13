package com.capgemini.springbootfulldemo.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.springbootfulldemo.entity.Employee;

public interface EmployeeService {
    public List<Employee> getAllEmployeeDetails();

    public Optional<Employee> getEmployeeById(String empId);

    public Employee addEmployee(Employee emp);

    public void deleteEmployee(Employee e);

    public Employee updateEmployee(String empId, Employee e);
}
