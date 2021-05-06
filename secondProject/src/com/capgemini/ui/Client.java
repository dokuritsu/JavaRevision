package com.capgemini.ui;

import java.util.ArrayList;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;
import com.capgemini.repository.AccountRepositoryImpl;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class Client {
    AccountRepository accountRepository;
    AccountService accountService;

    public static void main(String[] args){
        // try catch blocks implemented here

        // Initial set up
        Client c = new Client();
        ArrayList<Account> accounts = new ArrayList<>();
        c.accountRepository = new AccountRepositoryImpl(accounts);
        c.accountService = new AccountServiceImpl(c.accountRepository);

        // Creating an account 
        try {
            System.out.println(c.accountService.createAccount(100, 500));
        } catch (InsufficientOpeningBalanceException | InvalidAccountNumberException e) {
            e.printStackTrace();
        }
        // c.accountService.createAccount(100, 600);

        // Depositing
        try {
            System.out.println(c.accountService.depositAmount(100, 50));
        } catch (InvalidAccountNumberException e) {
            e.printStackTrace();
        }
        // c.accountService.depositAmount(101, 200);

        // Withdrawing
        try {
            System.out.println(c.accountService.withdrawAmount(100, 50));
        } catch (InvalidAccountNumberException | InsufficientBalanceException e) {
            e.printStackTrace();
        }
        // c.accountService.withdrawAmount(101, 50);
        // c.accountService.withdrawAmount(100, 600);

        // Fund Transfer
        try {
            System.out.println(c.accountService.createAccount(101, 1000));
        } catch (InsufficientOpeningBalanceException | InvalidAccountNumberException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(c.accountService.fundTransfer(100, 101, 200));
        } catch (InvalidAccountNumberException | InsufficientBalanceException e) {
            e.printStackTrace();
        }
        // try {
        //     System.out.println(c.accountService.fundTransfer(100, 101, 1000));
        // } catch (InvalidAccountNumberException | InsufficientBalanceException e) {
        //     e.printStackTrace();
        // }
    }
}
