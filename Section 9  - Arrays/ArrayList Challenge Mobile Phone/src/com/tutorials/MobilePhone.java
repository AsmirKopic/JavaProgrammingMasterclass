package com.tutorials;

import java.util.ArrayList;

public class MobilePhone {
    public ArrayList<Contacts> mobilePhone = new ArrayList<>();

    public void addContact(String name, long phone) {
        Contacts contact = new Contacts(name, phone);
        mobilePhone.add(contact);
    }
    public void printContacts(){
        System.out.println("List of contacts");
        for (int i = 0; i < mobilePhone.size(); i++) {
            System.out.println(mobilePhone.get(i).toString());
        }
    }
    public void removeContact(String name){
        int position = findContact(name);
        if (position >= 0){
            mobilePhone.remove(position);
        }
    }
    public void updateContact(String name, String newName, long newPoneNo){
        for (int i = 0; i < mobilePhone.size(); i++) {
            if (name.equals(mobilePhone.get(i).getName())) {
                Contacts newContact = new Contacts(newName, newPoneNo);
                mobilePhone.set(i, newContact);
            }
        }
    }
    public int findContact(String name){
        for (int i = 0; i < mobilePhone.size(); i++) {
            if (name.equals(mobilePhone.get(i).getName()))
                return i;
        }
        return -1;
    }
    public void searchContact(String name) {
        for (int i = 0; i < mobilePhone.size(); i++) {
            if (name.equals(mobilePhone.get(i).getName())) {
                System.out.println("Found at index " + i + "\n" + mobilePhone.get(i).toString());
            }
        }
    }

}
