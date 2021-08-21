package com.tutorials;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount account;
    private double amount;
    private double expected;
    private boolean branch;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.expected = expected;
        this.branch = branch;
    }

    @org.junit.Before
    public void setup(){
        account = new BankAccount("Asmir", "Kopic", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {324.25, true, 1324.25},
                {1000.00, true, 2000.00}
        });
    }

    @org.junit.Test
    public void deposit() throws Exception{
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0);
    }

}
