package com.tutorials;

import javax.swing.*;

public class Outlander extends Car{

    private int roadServicesMonths;

    public Outlander(int roadServicesMonths) {
        super("Outlander", "4WD", 5, 5, 6, false);
        this.roadServicesMonths = roadServicesMonths;
    }

    public void accelerate(int rate){
        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity == 0){
            stop();
            changeGear(1);
        } else if (newVelocity > 0 && newVelocity <= 10){
            changeGear(1);
        } else if (newVelocity > 10 && newVelocity <= 20) {
            changeGear(2);
        } else if (newVelocity > 20 && newVelocity <= 30) {
            changeGear(3);
        }  else {
            changeGear(4);
        }
        if (newVelocity > 0){
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }





}
