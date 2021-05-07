package com.capgemini.repository;

import java.util.ArrayList;

import com.capgemini.beans.Account;

public class AccountRepositoryImpl implements AccountRepository{

    // Initialize in contructor
    ArrayList<Account> accounts;

    public AccountRepositoryImpl(ArrayList<Account> accounts) {
        super();
        this.accounts = accounts;
    }

    @Override
    public boolean verifyAccount(int accountNumber) {
        // Verify if account already exists thru account number
        for(Account acc:accounts){
            if(acc.getAccountNumber() == accountNumber){
                return true;
            }
        }
        return false;
    }

    @Override
    public Account addNewAccount(Account a) {
        // Adds the verified account to the list
        accounts.add(a);
        return a;
    }

    @Override
    public Account retriveAccount(int accountNum) {
        for(Account acc: accounts){
            if(acc.getAccountNumber() == accountNum){
                return acc;
            }
        }
        return null;
    }

    @Override
    public Account incrementBalance(Account a, double amount) {
        // Calculate new balance
        double newBalance = a.getBalance() + amount;

        // Update account balance
        a.setBalance(newBalance);
        return a;
    }

    @Override
    public Account decrementBalance(Account a, double newBal) {
        // Update with new balance
        a.setBalance(newBal);
        return a;
    } 
    
}
