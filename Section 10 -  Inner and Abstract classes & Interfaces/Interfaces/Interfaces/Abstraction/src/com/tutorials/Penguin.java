package com.tutorials;

public class Penguin extends Bird{
    public Penguin(String name) {
        super(name);
    }


    @Override
    public void fly() {
        super.fly();
        System.out.println("I cant fly!");
    }
}
