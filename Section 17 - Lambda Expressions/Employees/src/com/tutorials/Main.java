package com.tutorials;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

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

        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30 );
        printEmployeesByAge(employees, "Employees 30 and under", employee -> employee.getAge() <= 30);

    }

    public static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        System.out.println(ageText);
        employees.forEach(employee -> {
            if (ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        });



        IntPredicate intp = i -> i> 4 && i<8;
        System.out.println(intp.test(6));
       

    }
}

