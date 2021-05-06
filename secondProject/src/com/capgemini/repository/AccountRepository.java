package com.capgemini.repository;

import com.capgemini.beans.Account;

public interface AccountRepository {
    public boolean verifyAccount(int accountNumber);
    public Account addNewAccount(Account a);
    public Account retriveAccount(int accountNum);
    public Account incrementBalance(Account a, double amount);
    public Account decrementBalance(Account a, double newBal);
}
