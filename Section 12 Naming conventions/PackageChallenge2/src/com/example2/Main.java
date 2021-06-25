package com.example2;

import com.example.mylibrary.Series;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Series.nSum(i));
        }

        System.out.println("***********************");
        for (int i = 0; i < 10; i++) {
            System.out.println(Series.fibonacci(i));
        }

    }

}
