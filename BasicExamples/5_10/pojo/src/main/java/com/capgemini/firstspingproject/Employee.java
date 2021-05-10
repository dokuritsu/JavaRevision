package com.capgemini.firstspingproject;

// import org.springframework.beans.factory.DisposableBean;
// import org.springframework.beans.factory.InitializingBean;

public class Employee {
    private String name;
    private String id;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void destroy() {
        System.out.println("Destroy");    
    }

    public void init() {
        System.out.println("Init");   
    }

    
}