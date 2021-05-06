package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService{

    AccountRepository accountRepository;
    

    public AccountServiceImpl(AccountRepository accountRepository) {
        super();
        this.accountRepository = accountRepository;
    }

    /*
        There are a few scenarios that could go wrong when creating a new account:
            1. Start with an insufficientbalance
            2. Trying to create an account with an accout number that already exists
    */
    @Override
    public String createAccount(int accountNum, double bal) throws InsufficientOpeningBalanceException, InvalidAccountNumberException {
        // Check to see if the initial starting balance is less than 500
        if(bal < 500){
            throw new InsufficientOpeningBalanceException("\nThe initial balance must be greater than equal to 500.");
        }

        // Verify that the account number doesn't already exist
        if(accountRepository.verifyAccount(accountNum)){
            throw new InvalidAccountNumberException("\nThis account number already exists. Please enter a new account number or try to deposit instead.");
        }

        // Create account with verified accountNum and to the repository
        Account a = new Account(accountNum, bal);
        accountRepository.addNewAccount(a);
        // System.out.println("The account was successfully created.");

        return "The account was successfully created.";
    }

    /*
        There are a few scenarios that could go wrong when depositing:
            1. The account you are trying to deposit to does not exist 
            2. Depositing a negative amount
    */
    @Override
    public String depositAmount(int accountNum, double amount) throws InvalidAccountNumberException {
        // Check to see if accountNum exists in repository
        if(!accountRepository.verifyAccount(accountNum)){
            throw new InvalidAccountNumberException("\nThe account number you have entered does not exist within our repository.");
        }

        // If amount trying to withdraw is neg...
        if(amount < 0){
            // throw a invalid deposit amount exception
        }

        // Retrieved verified account
        Account a = accountRepository.retriveAccount(accountNum);

        // Increment account balance
        Account b = accountRepository.incrementBalance(a, amount);

        // Inform user of details
        // System.out.println("Account deposit was successful!");
        // System.out.println("Your new account balance is: " + b.getBalance());

        return "Account deposit was successful! \nYour new account balance is: " + b.getBalance();
    }

    /*
        There are a few scenarios that could go wrong when withdrawing:
            1. The account you are trying to withdraw from does not exist
            2. You are trying to withdraw an invalid amount (negative)
            3. You are trying to withraw a large sum that will leave your account at a negative balance
    */
    @Override
    public String withdrawAmount(int accountNum, double amount) throws InvalidAccountNumberException, InsufficientBalanceException {
        // Check to see if accountNum exists in repository
        if(!accountRepository.verifyAccount(accountNum)){
            throw new InvalidAccountNumberException("\nThe account number you have entered does not exist within our repository.");
        }

        // If amount trying to withdraw is neg...
        if(amount < 0){
            // throw a invalid deposit amount exception
        }

        // Retrieved verified account
        Account a = accountRepository.retriveAccount(accountNum);

        // Ensure balance will be not be invalid
        double newBalance = a.getBalance() - amount;
        if(newBalance < 0){
            throw new InsufficientBalanceException("\nThe amount you are trying to withdraw will cause a negative balance.");
        }

        // Decrement account balance
        Account b = accountRepository.decrementBalance(a, newBalance);

        // Inform user of details
        System.out.println("Withdrawal was successful!");
        System.out.println("Your new account balance is: " + b.getBalance());

        return "Withdrawal was successful! \nYour new account balance is: " + b.getBalance();
    }

    /*
        There are a few scenarios that could go wrong:
            1. Accounts do not exist
            2. Trying to transfer a negative amount
            3. Leaving an account with a negative balance
    */
    @Override
    public String fundTransfer(int firstAccount, int secondAccount, double amount) throws InvalidAccountNumberException, InsufficientBalanceException {
        // Check to see if accountNum exists in repository
        if(!accountRepository.verifyAccount(firstAccount) && !accountRepository.verifyAccount(secondAccount)){
            throw new InvalidAccountNumberException("\nThe account number you have entered does not exist within our repository.");
        }

        // If amount trying to withdraw is neg...
        if(amount < 0){
            // throw a invalid deposit amount exception
        }

        // Retrieve verified accounts
        Account a = accountRepository.retriveAccount(firstAccount);
        Account b = accountRepository.retriveAccount(secondAccount);

        // Grab balances of both accounts & calculate the math
        double aBal = a.getBalance();

        // Assuming that the fund transfer will be from first to second account...
        double newBalA = aBal - amount;

        if(newBalA < 0){
            throw new InsufficientBalanceException("\nThe amount you are trying to withdraw will cause a negative balance for acount num: " + a.getAccountNumber());
        }

        // Decrement from first account
        Account newA = accountRepository.decrementBalance(a, newBalA);
        Account newB = accountRepository.incrementBalance(b, amount);

        // Inform user of details
        String msg = "Fund transfer was successful! \nYour new balance for acount number " + newA.getAccountNumber() + " is: " + newA.getBalance() + 
            "\nYour new balance for acount number " + newB.getAccountNumber() + " is: " + newB.getBalance();
        // System.out.println("Fund transfer was successful!");
        // System.out.println("Your new balance for acount number " + newA.getAccountNumber() + " is: " + newA.getBalance());
        // System.out.println("Your new balance for acount number " + newB.getAccountNumber() + " is: " + newB.getBalance());
        
        return msg;
    }
    
}
