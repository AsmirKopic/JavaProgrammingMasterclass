package com.tutorials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Challenge {
    public static void main(String[] args) {
        String myString = "Lets split this out into an array";
        String[] parts = myString.split(" ");
        Arrays.stream(parts).forEach(part -> System.out.println(part));

        Supplier<String> iLoveJava = () -> "I love java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }
}
