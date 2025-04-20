package org.crossbrowsertesting.api;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseInsert {
    public static void insertUser(Connection con, String firstName, String lastName, String email) {
        try {
            System.out.println(con);
            System.out.println(firstName);
            System.out.println(lastName);
            System.out.println(email);
            String query = "INSERT INTO users (first_name, last_name, email) VALUES (?, ?, ?)";
            System.out.println("1");
            PreparedStatement stmt = con.prepareStatement(query);
            System.out.println("2");
            stmt.setString(1, firstName);
            System.out.println("3");
            stmt.setString(2, lastName);
            System.out.println("4");
            stmt.setString(3, email);
            System.out.println("5");
            int rows = stmt.executeUpdate();
            System.out.println("Rows affected: " + rows);
            System.out.println("6");
            System.out.println("✅ Inserted: " + firstName + " " + lastName + " - " + email);
            System.out.println("7");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to insert user: " + email);
        }
    }
}
