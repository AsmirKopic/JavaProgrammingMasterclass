package com.tutorials;

public class Main {

    public static void main(String[] args) {
	StaticTest firstInstance = new StaticTest("1st Instance");
    System.out.println(firstInstance.getName() + " is instance number " + firstInstance.getNumInstance());

    StaticTest secondInstance = new StaticTest("2nd Instance");
    System.out.println(secondInstance.getName() + " is instance number " + secondInstance.getNumInstance());

    StaticTest thirdInstance = new StaticTest("3rd Instance");
    System.out.println(secondInstance.getName() + " is instance number " + thirdInstance.getNumInstance());


    }
}
