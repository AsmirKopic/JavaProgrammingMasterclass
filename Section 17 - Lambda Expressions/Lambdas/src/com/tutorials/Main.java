package com.tutorials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Printing from the runnable!");
            System.out.println("Print line 2");
        }).start();

        Employee john = new Employee("John", 41);
        Employee tim = new Employee("Tim", 21);
        Employee snow = new Employee("Snow", 22);
        Employee jack = new Employee("Jack", 30);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(snow);
        employees.add(jack);

       // sort names
        Collections.sort(employees, Comparator.comparing(Employee::getName));

//        for (Employee employee : employees){
//            System.out.println(employee.getName());
//        }
        employees.forEach(name -> System.out.println(name.getName()));

        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };


        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

    }
    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

