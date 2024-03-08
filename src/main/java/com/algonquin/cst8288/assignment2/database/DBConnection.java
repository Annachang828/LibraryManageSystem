package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * File name: DBConnection.java 
 * Author: Tsaichun Chang
 * Course: CST8288-022
 * Assignment: Assignment2
 * Date: 2024-02-17
 * Lab Professor: Gustavo Adami
 *
 * @author Tsaichun Chang 
 * @version 1
 * @since JDK 18.0.2.1
 * 
 * The {@code DBConnection} class manages the database connection for the Library Management System.
 * It implements the Singleton design pattern to ensure that only one instance of the database connection exists throughout the application.
 * This class provides methods to get the instance of the connection, retrieve the connection, and close the connection.
 */
public class DBConnection {
	
    /** The single instance of {@code DBConnection} for Singleton pattern implementation. */
    private static DBConnection instance;
    
    /** The database connection. */
    private static Connection connection = null;
	
    /** Database server URL. */
    private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
    
    /** Database username. */
    private String userString = "root";
    
    /** Database password. */
    private String passwordString = "Please2258@";
    
    /** JDBC Driver string. */
    private String driverString = "com.mysql.cj.jdbc.Driver";

    /**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes the database connection.
     * 
     * @throws RuntimeException if there is an error connecting to the database, including
     * class not found or SQL exceptions.
     */
    private DBConnection() {
        try {
            Class.forName(driverString);
            connection = DriverManager.getConnection(serverUrl, userString, passwordString);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    /**
     * Returns the single instance of {@code DBConnection}, creating it if it does not yet exist.
     * 
     * @return The single instance of {@code DBConnection}.
     */
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    
    /**
     * Retrieves the active database connection, establishing a new one if necessary.
     * 
     * @return A {@link Connection} object to the database.
     * @throws RuntimeException if there is an error establishing the database connection.
     */
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(serverUrl, userString, passwordString);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error reconnecting to the database", e);
        }
            return connection;
    }
    
    /**
     * Closes the current database connection if it is not null.
     * 
     * @throws RuntimeException if there is an error closing the database connection.
     */
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null; 
            } catch (SQLException e) {
                throw new RuntimeException("Error closing the database connection", e);
            }
        }
    }

}

