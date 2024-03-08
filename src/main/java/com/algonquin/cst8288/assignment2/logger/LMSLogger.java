package com.algonquin.cst8288.assignment2.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * File name: LMSLogger.java 
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
 * The {@code LMSLogger} class provides a logging utility for the Library Management System.
 * It utilizes the Singleton design pattern to ensure that only one instance of the logger is used throughout the application.
 * It supports logging messages and exceptions with different log levels.
 */
public class LMSLogger {
	
    private static LMSLogger instance;
    private final String logFile = "LMSLog.txt";
    
    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private LMSLogger() {};
    
    /**
     * Returns the single instance of {@code LMSLogger}, creating it if it doesn't already exist.
     * 
     * @return The single instance of {@code LMSLogger}.
     */
    public static LMSLogger getInstance() {
        if (instance == null) {
            instance = new LMSLogger();
        }
        return instance;
    }
    
    /**
     * Logs a message with a specified log level.
     * 
     * @param level   The log level of the message.
     * @param message The message to log.
     */
    public void log(LogLevel level, String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(logFile, true))) {
            out.println(LocalDateTime.now() + "[" + level + "]" + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Logs an exception with a message and a specified log level.
     * 
     * @param level   The log level of the message.
     * @param message The message to log.
     * @param ex      The exception to log.
     */
    public void logException(LogLevel level, String message, Exception ex) {
        try (PrintWriter out = new PrintWriter(new FileWriter(logFile, true))) {
            out.println(LocalDateTime.now() + "[" + level + "]" + message + " - Exception:" + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
