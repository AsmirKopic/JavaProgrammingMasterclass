package com.tutorials;

class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
    public String startEngine(){
        return "Car --> startEngine();";
    }
    public String accelerate(){
        return "Car --> accerlerate()";
    }
    public String brake(){
        return "Car --> brake()";
    }
}
class Mitsubishi extends Car{
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return getClass().getName() + " --> startEngine();";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " --> startEngine();";
    }

    @Override
    public String brake() {
        return getClass().getName() + " --> startEngine();";
    }
}











public class Main {

    public static void main(String[] args) {
	// MAIN CLASS
    Car car = new Car(4,"base car");
    Mitsubishi mitsubishi = new Mitsubishi(6,"Mitshi");
    Ford ford = new Ford(4," Ford focus");

        System.out.println(car.accelerate());
        System.out.println(car.startEngine());
        System.out.println(car.brake());

        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.brake());

        System.out.println(ford.accelerate());
        System.out.println(ford.startEngine());
        System.out.println(ford.brake());

    }
}
