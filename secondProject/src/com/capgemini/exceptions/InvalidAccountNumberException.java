package com.capgemini.exceptions;
/*
    When depositing or withdrawing, account must exist.
*/
public class InvalidAccountNumberException extends Exception{

    public InvalidAccountNumberException() {
    }

    public InvalidAccountNumberException(String message) {
        super(message);
    }
    
}
