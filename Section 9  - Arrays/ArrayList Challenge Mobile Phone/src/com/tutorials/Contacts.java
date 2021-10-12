package com.tutorials;

public class Contacts {
    private String name;
    private long phone;


    public Contacts(String name, long phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact: " +
                "name='" + this.name + '\'' +
                ", phone=" + this.phone +' ';
    }
}
