package com.tutorials;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {



        int[] myArray = readIntegers(8);


        System.out.println(Arrays.toString(myArray));

        System.out.println(" Minimum number in array is " + findMin(myArray));

        //Call reverse method
        reverse(myArray);


    }

    private static int[] readIntegers(int size){
        System.out.println("Please enter " + size + " numbers" );
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        return array;
    }

    private static int findMin(int[] array){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private static void reverse(int[] array){
        int[] reverseArray = new int[array.length];
        for (int i = 0, j= array.length-1; i < array.length; i++,j--) {
            reverseArray[j] = array[i];
        }
        System.out.println(Arrays.toString(reverseArray));
    }
}
