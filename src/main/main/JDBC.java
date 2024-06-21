package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private static final String URL = "jdbc:mariadb://localhost:3306/JeuxOlympiques";
    private static final String USER = "o22307737"; 
    private static final String PASSWORD = "91KPG6"; 

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        getConnection();
    }
}