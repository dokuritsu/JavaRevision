package com.capgemini.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

public class Tests {
    /* Creating a dummy object
        @Mock
        AccountRepo accountRepo;

        setup()
            MockitoAnnotations.initMock(this). // dummy object created

    */
    
    Client c;

    // Create a setup method
    @Before
    public void setUp(){
        c = new Client();
        c.accounts = new ArrayList<>();
        c.accountRepository = new AccountRepositoryImpl(c.accounts);
        c.accountService = new AccountServiceImpl(c.accountRepository);
    }

    @Test (expected = InsufficientOpeningBalanceException.class)
    // WHen an account without the sufficient balance is created
    public void testInsufficientOpeningBalanceCreate() throws InsufficientOpeningBalanceException, InvalidAccountNumberException{
        System.out.println(c.accountService.createAccount(100, 499));
    }

    @Test (expected = InvalidAccountNumberException.class)
    // When user tries to create an account with a specific num that is already in use
    public void testInvalidAccountNumberCreate() throws InsufficientOpeningBalanceException, InvalidAccountNumberException{
        System.out.println(c.accountService.createAccount(100, 500));    // One valid account
        System.out.println(c.accountService.createAccount(100, 1000));  // Account already exists
    }

    @Test (expected = InvalidAccountNumberException.class)
    // When depositing some amount, the account num given does not exist
    public void testInvalidAccountNumberDeposit() throws InvalidAccountNumberException{
        System.out.println(c.accountService.depositAmount(101, 500));   // Account num 101 does not exist
    }

    @Test (expected = InsufficientBalanceException.class)
    // When withdrawing, negative balance remains
    public void testInsufficientBalanceNegative() throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalanceException{
        System.out.println(c.accountService.createAccount(100, 500));    // One valid account
        System.out.println(c.accountService.withdrawAmount(100, 2000)); // Will cause a negative balance
    }
    
    @Test (expected = InvalidAccountNumberException.class)
    // When withdrawing, account num given does not exist
    public void testInvalidAccountNumberWithdraw() throws InvalidAccountNumberException, InsufficientBalanceException{
        System.out.println(c.accountService.withdrawAmount(101, 2000)); // Account num 101 does not exist
    }

    @Test (expected = InsufficientBalanceException.class)
    // When transferring, ensure account does not have negative balance
    public void testFundTransferNegative() throws InsufficientOpeningBalanceException, InvalidAccountNumberException, InsufficientBalanceException{
        System.out.println(c.accountService.createAccount(100, 1000));   // First account
        System.out.println(c.accountService.createAccount(101, 2000));   // Another account created
        System.out.println(c.accountService.fundTransfer(100, 101, 2000));  // Withdrawing too much from first accoutn
    }

    @Test (expected = InvalidAccountNumberException.class)
    // When transferring, ensure accounts exist
    public void testFundTransferExist() throws InvalidAccountNumberException, InsufficientBalanceException{
        System.out.println(c.accountService.fundTransfer(200, 201, 100));   // Both accounts do not exist
    }


    /*
        Notes to improve test cases:
            - Validation vs exception:
                e.g Depositing a negative amount => this can be checked in logic code
        Create account:
            1. Amount less than 500 => throw exception
            2. when the valid info (101, 5000) is passed account should be created successfully

        Deposit
            1. Succesful
            2. Invalidaccount number

        Withdraw:
            1. Invalid account number
            2. Insufficient balance exception
            3. Successful
    */
}
