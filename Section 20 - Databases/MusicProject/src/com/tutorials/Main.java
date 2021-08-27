package com.tutorials;

import com.tutorials.model.Datasource;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Cant open datasource");
        }
        datasource.close();
    }


}
