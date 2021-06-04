package com.tutorials;

import java.util.ArrayList;
import java.util.Arrays;

public class MobilePhone {
    public ArrayList<Contacts> mobilePhone = new ArrayList<>();

   //Quit list, print contacts, add, remove, search

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
        int position = searchContact(name);
        if (position >= 0){
            mobilePhone.remove(position);
        }
    }

    public int searchContact(String name){
        for (int i = 0; i < mobilePhone.size(); i++) {
            if (name.equals(mobilePhone.get(i).getName()))
                return i;
        }
        return -1;
    }


}
