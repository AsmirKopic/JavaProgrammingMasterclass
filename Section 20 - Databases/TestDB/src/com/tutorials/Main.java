package com.tutorials;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\databases\\" + DB_NAME;

    public static void main(String[] args) {

        String sql = "CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)";

        try{
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            statement.execute(sql);

//            statement.execute("INSERT INTO contacts VALUES ('Asmir', 12345678 , 'asmir@email.com') ");
//            statement.execute("INSERT INTO contacts VALUES ('Joe', 67890 , 'joe@email.com') ");
//            statement.execute("INSERT INTO contacts VALUES ('Tim', 342343 , 'tim@something.com') ");

            insertContact(statement, "AsmirKopic", 5643, "randomemail@email.com");

            // statement.execute("UPDATE contacts SET phone=56778543 WHERE name='Asmir'");

            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            while (results.next()){
                System.out.println(results.getString("name") + " " +
                                    results.getInt("phone") + " " +
                                    results.getString("email"));
            }
            results.close();
            statement.close();
            conn.close();

        } catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO contacts " +
                        "VALUES ('" + name + "'," + phone + ", " + "'" + email + "')");
    }
}


