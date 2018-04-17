package ru.suika.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

class JdbcTestPostgreSQL {
    public static void main (String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            System.err.println (e);
            System.exit (-1);
        }
        try {
            // open connection to database
            Connection connection = DriverManager.getConnection(
                    //"jdbc:postgresql://dbhost:port/dbname", "user", "dbpass");
                    "jdbc:postgresql://127.0.0.1:5432/java-lesson", "postgres", "password");

            // build query, here we get info about all databases"
            String query = "SELECT * FROM client";

            // execute query
            Statement statement = connection.createStatement ();
            ResultSet rs = statement.executeQuery (query);

            // return query result
            while ( rs.next () )
                // display table name
                System.out.println ("PostgreSQL Query result: " + rs.getString ("uid") + rs.getString("name"));

            connection.close ();
        }
        catch (java.sql.SQLException e) {
            System.err.println (e);
            System.exit (-1);
        }
    }
}