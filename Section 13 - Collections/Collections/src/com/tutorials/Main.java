package com.tutorials;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8, 12);
        theatre.getSeats();
        if (theatre.reserveSeat("A08")){
            System.out.println("Please pay");
        } else{
            System.out.println("Seat is already taken.");
        }
        if (theatre.reserveSeat("B04")){
            System.out.println("Please pay");
        } else{
            System.out.println("Seat is already taken.");
        }


    }
}
