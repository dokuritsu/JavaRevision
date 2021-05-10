package com.capgemini.firstspingproject;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean {
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

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy");    
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init");   
    }

    
}