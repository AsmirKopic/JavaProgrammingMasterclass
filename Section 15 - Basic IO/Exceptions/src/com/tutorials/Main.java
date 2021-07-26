package com.tutorials;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//	int x = 98;
//	int y = 0;
//        System.out.println(devideLBYL(x,y));
//        System.out.println(devideEAFP(x, y));

        int x = getInt();
        System.out.println("x is " + x);

    }
    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        try {
            return s.nextInt();
        } catch (InputMismatchException e){
            return 0;
        }
    }

    private static int devideLBYL(int x, int y){
        if (y != 0){
            return x / y;
        } else {
            return 0;
        }
    }

    private static int devideEAFP(int x, int y){
        try {
            return x / y;
        } catch (ArithmeticException e){
            // System.out.println(e.getMessage());
            return 0;
        }
    }



}
