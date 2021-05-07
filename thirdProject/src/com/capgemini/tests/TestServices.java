package com.capgemini.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;
import com.capgemini.repository.AccountRepositoryImpl;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

import org.junit.Before;
import org.junit.Test;

// KEEPING THIS FILE FOR REFERENCE

public class TestServices {
    ArrayList<Account> accounts;
    AccountRepository accountRepository;
    AccountServiceImpl accountService;

    @Before
    public void setUp(){
        accounts = new ArrayList<>();
        accountRepository = new AccountRepositoryImpl(accounts);
        accountService = new AccountServiceImpl(accountRepository);
    }

    @Test (expected= com.capgemini.exceptions.InsufficientOpeningBalanceException.class)
    public void testInsufficientOpeningBalExceptionCreateFail() throws InsufficientOpeningBalanceException, InvalidAccountNumberException{
        accountService.createAccount(100, 499);
    }

    @Test 
    public void testCreateAccountSuccess() throws InsufficientOpeningBalanceException, InvalidAccountNumberException{
        assertEquals("The account was successfully created.", accountService.createAccount(100, 500));
    }

    @Test (expected = com.capgemini.exceptions.InvalidAccountNumberException.class)
    public void testInvalidAccountNumExceptionDepositFail() throws InsufficientOpeningBalanceException, InvalidAccountNumberException{
        accountService.createAccount(100, 1000);
        accountService.depositAmount(101, 500);
    }

    @Test
    public void testDepositSuccess() throws InvalidAccountNumberException, InsufficientOpeningBalanceException{
        accountService.createAccount(100, 1000);
        assertEquals("Account deposit was successful!", accountService.depositAmount(100, 500));
    }

    @Test (expected = com.capgemini.exceptions.InvalidAccountNumberException.class)
    public void testInvalidAccountNumWithdrawFail() throws InsufficientOpeningBalanceException, InvalidAccountNumberException, InsufficientBalanceException{
        accountService.createAccount(100, 500);
        accountService.withdrawAmount(101, 50);
    }

    @Test (expected = com.capgemini.exceptions.InsufficientBalanceException.class)
    public void testInsufficientBalWithdrawFail() throws InsufficientOpeningBalanceException, InvalidAccountNumberException, InsufficientBalanceException{
        accountService.createAccount(100, 1000);
        accountService.withdrawAmount(100, 2000);
    }

    @Test
    public void testWithdrawSuccess() throws InsufficientOpeningBalanceException, InvalidAccountNumberException, InsufficientBalanceException{
        accountService.createAccount(100, 1000);
        assertEquals("Withdrawal was successful!", accountService.withdrawAmount(100, 500));
    }

    @Test (expected = com.capgemini.exceptions.InvalidAccountNumberException.class)
    public void testInvalidAccountNumTransferFail() throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalanceException{
        accountService.createAccount(100, 1000);
        accountService.createAccount(101, 2000);
        accountService.fundTransfer(100, 102, 100);
    }

    @Test (expected = com.capgemini.exceptions.InsufficientBalanceException.class)
    public void testInsufficientBalTransderFail() throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalanceException{
        accountService.createAccount(100, 1000);
        accountService.createAccount(101, 2000);
        accountService.fundTransfer(100, 101, 3000);
    }

    @Test
    public void testTransferSuccess() throws InsufficientOpeningBalanceException, InvalidAccountNumberException, InsufficientBalanceException{
        accountService.createAccount(100, 1000);
        accountService.createAccount(101, 2000);
        assertEquals("Fund transfer was successful!", accountService.fundTransfer(100, 101, 500));
    }
}
