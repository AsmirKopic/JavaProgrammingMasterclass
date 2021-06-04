package com.tutorials;

public class Main {
    public static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

    mobilePhone.addContact("Asmir", 99882332);
    mobilePhone.addContact("Aida1", 732423747);
    mobilePhone.addContact("Aida2", 732423747);
    mobilePhone.addContact("Aida3", 732423747);
    mobilePhone.printContacts();

        System.out.println(mobilePhone.searchContact("Aida2"));
        mobilePhone.removeContact("Aida3");
        mobilePhone.removeContact("Asmir");

    mobilePhone.printContacts();
    }
}
