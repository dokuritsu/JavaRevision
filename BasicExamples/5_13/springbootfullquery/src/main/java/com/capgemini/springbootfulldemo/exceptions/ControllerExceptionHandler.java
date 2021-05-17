package com.capgemini.springbootfulldemo.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage employeeNotFoundException(EmployeeNotFoundException ex, WebRequest request){
        ErrorMessage msg = new ErrorMessage(
            HttpStatus.NOT_FOUND.value(), 
            new Date(), 
            ex.getMessage(), 
            request.getDescription(false));
        return msg;
    }

    @ExceptionHandler(ExistingEmployeeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage existingEmployeeException(ExistingEmployeeException ex, WebRequest request){
        ErrorMessage msg = new ErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            new Date(), 
            ex.getMessage(), 
            request.getDescription(false));
        return msg;
    }
}
