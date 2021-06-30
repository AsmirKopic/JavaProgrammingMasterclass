package com.tutorials;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow ; row++) {
            for (int seatNum = 1 ; seatNum <= seatsPerRow ; seatNum++){
                Seat seat = new Seat(row + String.format("%2d", seatNum));
                seats.add(seat);
            }
            
        }

    }
}
