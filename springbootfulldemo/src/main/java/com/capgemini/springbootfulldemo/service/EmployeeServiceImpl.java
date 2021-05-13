package com.capgemini.springbootfulldemo.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.springbootfulldemo.entity.Employee;
import com.capgemini.springbootfulldemo.repo.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployeeDetails() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(String empId) {
        return employeeRepo.findById(empId);
    }

    @Override
    public Employee addEmployee(Employee emp) {
        return employeeRepo.save(emp);
    }

    @Override
    public void deleteEmployee(Employee e) {
        employeeRepo.delete(e);
    }

    @Override
    public Employee updateEmployee(String empId, Employee e) {
        return employeeRepo.save(e);
    }
}
