package by.sheidak.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnections {
    private final static String URL = "jdbc:mysql://localhost:3306/calculator?serverTimezone=UTC";
    private final static String USER = "root";
    private final static String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}