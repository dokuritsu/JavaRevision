package com.capgemini.service;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface AccountService {
    public String createAccount(int accountNum, double bal) throws InsufficientOpeningBalanceException, InvalidAccountNumberException;
    public String depositAmount(int accountNum, double amount) throws InvalidAccountNumberException;
    public String withdrawAmount(int accountNum, double amount) throws InvalidAccountNumberException, InsufficientBalanceException;
    public String fundTransfer(int firstAccount, int secondAccount, double amount) throws InvalidAccountNumberException, InsufficientBalanceException;
}
