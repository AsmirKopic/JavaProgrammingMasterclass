package com.tutorials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        String sql = "CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)";

        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\testjava.db");
            Statement statement = conn.createStatement();
            statement.execute(sql);
            statement.execute("INSERT INTO contacts VALUES ('Asmir', 12345678 , 'asmir@email.com') ");

            statement.close();
            conn.close();


        } catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }


    }
}
