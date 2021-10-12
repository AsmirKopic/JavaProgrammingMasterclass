package com.tutorials;

public class Main {

    public static void main(String[] args) {

        //Testing app

        Bank bank = new Bank("OneBank");
        bank.addBranch("Branch1");

        bank.addCustomer("Branch1", "Asmir", 754.54);
        bank.addCustomer("Branch1", "Name1", 67.54);
        bank.addCustomer("Branch1", "Name2", 54.87);

        bank.addBranch("Branch2");
        bank.addCustomer("Branch2", "TestName1", 13.42);

        bank.addCustomerTransactions("Branch1", "Asmir", 567.44);
        bank.addCustomerTransactions("Branch1", "Name2", 444);

        bank.listCustomers("Branch2",false);
    }
}
