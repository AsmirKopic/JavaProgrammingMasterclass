package com.tutorials;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
     try {
         int result = divide();
         System.out.println(result);
     } catch (ArithmeticException e){
         System.out.println(e.toString());
         System.out.println("Unable to perform division.");
     }

    }
    private static int divide(){
        int x;
        int y;
        try{
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + " y is " + y);
            return x / y;
        } catch (NoSuchElementException e){
            throw new ArithmeticException("No suitable input.");
        } catch (ArithmeticException e){
            throw new ArithmeticException("Attempt to divide by zero.");
        }
    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter and integer. ");
        while(true){
            try{
                return s.nextInt();
            } catch (InputMismatchException e){
                // go round again
                s.nextLine();
                System.out.println("Please enter number using only digits 0 to 9");
            }
        }
    }

}

