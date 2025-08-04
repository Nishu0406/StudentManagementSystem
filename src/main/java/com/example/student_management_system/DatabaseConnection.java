package com.example.student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    static Connection con;

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String USER = "root";
            String PASSWORD = "pass_1234"; // change as per your setup
            String URL = "jdbc:mysql://localhost:3306/student?autoReconnect=true&useSSL=false&serverTimezone=UTC";

            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}


