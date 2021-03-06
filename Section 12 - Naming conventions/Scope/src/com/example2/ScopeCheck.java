package com.example2;

public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar = 1;

    public ScopeCheck() {
        System.out.println("Scope check called, publicVar = " + publicVar + " , privateVar = " + privateVar);
    }

    public int getPrivateVar() {
        return privateVar;
    }
    public void timesTwo(){
        int privateVar = 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + i * privateVar);
        }
    }

    // checking scope for Inner Class
    public class InnerClass{
        public int privateVar = 3;

        public InnerClass() {
            System.out.println("InnerClass called, privateVar is " + privateVar);
        }
        // check for timesTwo method in InnerClass
        public void timesTwo(){
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times two is " + i * privateVar);
            }
        }
    }

}
