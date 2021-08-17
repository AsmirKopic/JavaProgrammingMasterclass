package com.tutorials;

import static org.junit.Assert.*;

public class BankAccountTest {

    @org.junit.Test
    public void deposit() {
        BankAccount account = new BankAccount("Asmir", "Kopic", 1000, BankAccount.CHECKING);
        double balance = account.deposit(200, true);
        assertEquals(1200, balance, 0);

    }

    @org.junit.Test
    public void withdraw() {
    }

    @org.junit.Test
    public void getBalance_deposit() {
        BankAccount account = new BankAccount("Asmir", "Kopic", 1000, BankAccount.CHECKING);
        account.deposit(200, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        BankAccount account = new BankAccount("Asmir", "Kopic", 1000, BankAccount.CHECKING);
        account.withdraw(200, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() {
        BankAccount account = new BankAccount("Asmir", "Kopic", 1000, BankAccount.CHECKING);
        assertTrue(account.isChecking());
    }


}




















