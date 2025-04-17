package org.crossbrowsertesting.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConnection {
    public static void databaseConnection() {
        try{
            Properties props = new Properties();
            FileInputStream input = new FileInputStream("src/main/resources/application.properties");
            props.load(input);
//        String url = props.getProperty("db.url");
//        String username = props.getProperty("db.username");
//        String password = props.getProperty("db.password");
//        String driver = props.getProperty("db.driver");
//        System.out.println(url+" "+username+" "+password+" "+driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
