package com.tutorials;

public class Main {

    public static void main(String[] args) {

        String string = "Im a string. Yes I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99zz";
        System.out.println(newAlphanumeric.replaceAll(".", "X"));       //replace all with X
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));   //replace all digits 0-9
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));   //replace all digits 0-9 shortcut \\d
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));   //replace all NON digits




    }
}
