package com.tutorials;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John", 41);
        Employee tim = new Employee("Tim", 21);
        Employee snow = new Employee("Snow", 22);
        Employee jack = new Employee("Jack", 30);
        Employee red = new Employee("Red Ridinghood", 35);
        Employee prince = new Employee("Prince", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(snow);
        employees.add(jack);
        employees.add(red);
        employees.add(prince);

        employees.forEach(employee -> {
            if (employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        });

    }
}

