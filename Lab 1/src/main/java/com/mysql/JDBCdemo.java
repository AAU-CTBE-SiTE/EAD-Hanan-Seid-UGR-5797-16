package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCdemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_project";
        String username = "root";
        String password = "Password";

        try {
            Connection connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Connected successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}