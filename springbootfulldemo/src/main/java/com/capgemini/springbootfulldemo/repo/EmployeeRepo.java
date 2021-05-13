package com.capgemini.springbootfulldemo.repo;

import com.capgemini.springbootfulldemo.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, String>{
    
}
