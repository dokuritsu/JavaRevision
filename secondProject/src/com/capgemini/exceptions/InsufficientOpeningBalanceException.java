package com.capgemini.exceptions;

/*
    When creating account, initial deposit must be greater than 500
*/
public class InsufficientOpeningBalanceException extends Exception{

    public InsufficientOpeningBalanceException(){

    }
    
    public InsufficientOpeningBalanceException(String message) {
        super(message);
    }
    
}
