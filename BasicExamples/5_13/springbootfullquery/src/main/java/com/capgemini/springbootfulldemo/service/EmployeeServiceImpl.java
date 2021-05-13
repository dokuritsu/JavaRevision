package com.capgemini.springbootfulldemo.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.springbootfulldemo.entity.Employee;
import com.capgemini.springbootfulldemo.exceptions.EmployeeNotFoundException;
import com.capgemini.springbootfulldemo.exceptions.ExistingEmployeeException;
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
    public Optional<Employee> getEmployeeById(String empId) throws EmployeeNotFoundException{
        Optional<Employee> e = employeeRepo.findById(empId);
        if(!e.isPresent()){
            throw new EmployeeNotFoundException("Employee was not found...");
        }
        return e;
    }

    @Override
    public Employee addEmployee(Employee emp) throws ExistingEmployeeException {
        // Check if employee already exists
        Optional<Employee> e = employeeRepo.findById(emp.getEmpId());
        if(e.isPresent()){
            throw new ExistingEmployeeException("Employee already exists..");
        }
        return employeeRepo.save(emp);
    }

    @Override
    public void deleteEmployee(Employee e) {
        employeeRepo.delete(e);
    }

    @Override
    public Employee updateEmployee(String empId, Employee emp) throws EmployeeNotFoundException{
        Optional<Employee> e = employeeRepo.findById(empId);
        if(!e.isPresent()){
            throw new EmployeeNotFoundException("Employee record is not valid, please provide an existing emp id");
        }
        return employeeRepo.save(emp);
    }

    @Override
    public List<Employee> getEmployeeInfoByName(String name) {
        return employeeRepo.getEmployeeInfoByName(name);
    }

    @Override
    public List<Employee> getEmployeesBySalRange(double low, double high) {
        return employeeRepo.getEmployeeInfoBySalRange(low, high);
    }
}
