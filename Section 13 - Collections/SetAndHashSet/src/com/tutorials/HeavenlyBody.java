package com.tutorials;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitPeriod) {
        this.name = name;
        this.orbitPeriod = orbitPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitPeriod() {
        return orbitPeriod;
    }
    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

}
