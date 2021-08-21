package com.tutorials;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before tests. count is " + count++);
    }

    @org.junit.Before
    public void setup(){
        account = new BankAccount("Asmir", "Kopic", 1000, BankAccount.CHECKING);
        System.out.println("Running a test.. count " + count++);
    }

    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(200, true);
        assertEquals(1200, balance, 0);

    }

    @org.junit.Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600, true);
        assertEquals(400, balance, 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception{
        double balance = account.withdraw(600, false);
        assertEquals(400, balance, 0);
    }

    @org.junit.Test
    public void getBalance_deposit() throws Exception{
        account.deposit(200, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() {
        assertTrue(account.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("This executes after all tests, count is "+ count++);
    }

    @org.junit.After
    public void teardown(){
        System.out.println("Count "+ count++);
    }

}




















