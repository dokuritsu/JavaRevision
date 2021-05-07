package com.capgemini.exceptions;

/*
    When withdrawing, if balance is not available...
*/

public class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException() {
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }
    
}
