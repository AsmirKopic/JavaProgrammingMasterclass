package com.tutorials;

public class Main {

    public static int multiplier = 7;

    public static void main(String[] args) {
//	StaticTest firstInstance = new StaticTest("1st Instance");
//    System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstance());
//
//    StaticTest secondInstance = new StaticTest("2nd Instance");
//    System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstance());
//
//    StaticTest thirdInstance = new StaticTest("3rd Instance");
//    System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstance());

        int answer = multiply(6);
        System.out.println("The answer is " + answer);
        System.out.println("The multiplier is " + multiplier);

    }
    // method and multiplier must be declared as static in order to be called in main
    public static int multiply(int number){
        return number * multiplier;
    }

}
