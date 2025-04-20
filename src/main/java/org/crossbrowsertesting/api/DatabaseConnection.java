package org.crossbrowsertesting.api;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class DatabaseConnection {
    public static Connection databaseConnection(String dbName) {
        try {
            Properties props = new Properties();
            FileInputStream input = new FileInputStream("src/main/resources/application.properties");
            props.load(input);
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");
            String driver = props.getProperty("db.driver");
            String baseUrl = props.getProperty("db.url");
            String finalUrl = baseUrl.replace("springboot_dev", dbName);
            System.out.println(finalUrl);
            System.out.println(baseUrl);
            Class.forName(driver);
            Connection con = DriverManager.getConnection(finalUrl, username, password);
            System.out.println("✅ Connected to: " + dbName);
            return con;
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to connect: " + dbName, e);
        }
    }
}