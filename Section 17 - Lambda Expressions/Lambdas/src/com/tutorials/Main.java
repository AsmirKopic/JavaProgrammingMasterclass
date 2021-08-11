package com.tutorials;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        new Thread(() -> {
//            System.out.println("Printing from the runnable!");
//            System.out.println("Print line 2");
//        }).start();

        Employee john = new Employee("John", 41);
        Employee tim = new Employee("Tim", 21);
        Employee snow = new Employee("Snow", 22);
        Employee jack = new Employee("Jack", 30);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(snow);
        employees.add(jack);

//        for (Employee employee : employees){
//            System.out.println(employee.getName() + " " + employee.getAge());
//            new Thread(() ->System.out.println(employee.getAge())).start();
//        }
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

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
