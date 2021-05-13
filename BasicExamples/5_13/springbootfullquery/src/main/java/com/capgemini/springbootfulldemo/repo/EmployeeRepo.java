package com.capgemini.springbootfulldemo.repo;

import java.util.List;

import com.capgemini.springbootfulldemo.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepo extends JpaRepository<Employee, String>{
    
    @Query("from Employee where name=:eName")
    List<Employee> getEmployeeInfoByName(@Param("eName") String name);

    @Query("from Employee where salary>=:lower and salary<=:higher")
    List<Employee> getEmployeeInfoBySalRange(@Param("lower") double low, @Param("higher") double high);

}
