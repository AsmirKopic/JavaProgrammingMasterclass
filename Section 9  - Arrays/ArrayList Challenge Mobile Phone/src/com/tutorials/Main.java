package com.tutorials;
import java.util.Scanner;

public class Main {
    public static MobilePhone mobilePhone = new MobilePhone();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        displayMenu();
        int choice = 0;

        while (!quit) {
            System.out.println("Please enter your choice");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0:
                    displayMenu();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input, enter menu options between 0 and 6");
            }
        }
    }

    public static void displayMenu(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of the contacts.");
        System.out.println("\t 2 - To add new contact.");
        System.out.println("\t 3 - To update contact.");
        System.out.println("\t 4 - To remove contact.");
        System.out.println("\t 5 - To search for the contact.");
        System.out.println("\t 6 - To quit.");
    }
    public static void add(){
        String newContactName = "";
        System.out.println("Please enter new contact name:");
        newContactName = input.nextLine();
        System.out.println("Please enter phone number");
        long newPhoneNo = input.nextLong();
        input.nextLine();
        mobilePhone.addContact(newContactName, newPhoneNo);
        System.out.println("Contact added.");
    }
    public static void update(){
        System.out.println("Enter contact name for updated:");
        String contactName = input.nextLine();
        if (mobilePhone.findContact(contactName) >= 0) {
            System.out.println("Update contact. \n Please enter new name");
            String newContactName = input.nextLine();
            System.out.println("Please enter new phone number");
            Long newPhoneNo = input.nextLong();
            mobilePhone.updateContact(contactName, newContactName,newPhoneNo );
            System.out.println("Contact updated.");
        } else System.out.println("No match found");
    }
    public static void remove(){
        System.out.println("Enter contact name to remove");
        String contactName = input.nextLine();
        mobilePhone.removeContact(contactName);
        System.out.println("Contact removed.");
    }
    public static void search(){
        System.out.println("Please enter search name:");
        String searchName = input.nextLine();
        mobilePhone.searchContact(searchName);
    }

}
