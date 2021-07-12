package com.tutorials;

public class Moon extends HeavenlyBody{
    public Moon(String name, double orbitPeriod) {
        super(name, orbitPeriod, BodyTypes.MOON);
    }
}
