package com.capgemini.firstspingproject;

import javax.annotation.*;
// import org.springframework.beans.factory.DisposableBean;
// import org.springframework.beans.factory.InitializingBean;

public class Employee {
    private String name;
    private String id;

    public String getName() {
        return name;
    }
    @Resource (name = "name")
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    @Resource (name = "id")
    public void setId(String id) {
        this.id = id;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");    
    }

    @PostConstruct
    public void init() {
        System.out.println("Init");   
    }

    
}