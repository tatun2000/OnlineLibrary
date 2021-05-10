package bookworld.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
    private static final String NAME_USER = "root";
    private static final String PASSWORD = "Dima10910000";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static Connection connection;
    public static Statement statement;

    static {
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            connection = DriverManager.getConnection(URL, NAME_USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    static {
        try{
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
