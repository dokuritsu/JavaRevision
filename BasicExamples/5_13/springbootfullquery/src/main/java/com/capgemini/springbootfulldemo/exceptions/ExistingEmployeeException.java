package com.capgemini.springbootfulldemo.exceptions;

public class ExistingEmployeeException extends Exception{

    public ExistingEmployeeException(String message) {
        super(message);
    }
}
