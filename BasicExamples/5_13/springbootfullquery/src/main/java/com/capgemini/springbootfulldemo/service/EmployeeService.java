package com.capgemini.springbootfulldemo.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.springbootfulldemo.entity.Employee;
import com.capgemini.springbootfulldemo.exceptions.EmployeeNotFoundException;
import com.capgemini.springbootfulldemo.exceptions.ExistingEmployeeException;

public interface EmployeeService {
    public List<Employee> getAllEmployeeDetails();

    public Optional<Employee> getEmployeeById(String empId) throws EmployeeNotFoundException;

    public Employee addEmployee(Employee emp) throws ExistingEmployeeException;

    public void deleteEmployee(Employee e);

    public Employee updateEmployee(String empId, Employee e) throws EmployeeNotFoundException;

    public List<Employee> getEmployeeInfoByName(String name);

    public List<Employee> getEmployeesBySalRange(double low, double high);
}
