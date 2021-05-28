package com.tutorials;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Test
        Hamburger hamburger = new Hamburger("Basic", "Sausane", 3.56, "White");
        double price = hamburger.itemizeHamburger();
        hamburger.addHamburgerAddition1("Cheese", 3.55);
        hamburger.addHamburgerAddition2("Tomato", 2.35);
        hamburger.addHamburgerAddition3(" Random", 4.67);
        // hamburger.itemizeHamburger();

        HealthyBurger healthyBurger = new HealthyBurger("Chicken",10.12);
        healthyBurger.addHealthAddition1("Cheese 4", 4.56);
        healthyBurger.addHealthAddition2("Tomato special", 4.16);
        System.out.println("Total healthy burger price is " + healthyBurger.itemizeHamburger());

        DeluxeBurger db = new DeluxeBurger();
        db.itemizeHamburger();

        db.addHamburgerAddition1("nest", 4.5);



    }


}
