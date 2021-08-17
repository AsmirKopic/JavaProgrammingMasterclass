package com.tutorials;

public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }

    // The branch argument is true if customer perform transaction
    // at the branch, with a teller.
    //Its false if customer is performing transaction at the ATM
    public double deposit(double amount, boolean branch ){
        balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch){
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking(){
        return accountType == CHECKING;
    }

    // More methods to use ...
}
