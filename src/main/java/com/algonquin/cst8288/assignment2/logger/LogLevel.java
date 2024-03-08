package com.algonquin.cst8288.assignment2.logger;

/**
 * File name: LogLevel.java 
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
 * Represents the log levels used in the {@link LMSLogger} for logging messages and exceptions.
 * Each log level is associated with an integer level to indicate its priority.
 */
public enum LogLevel {
    
    /**
     * Trace level for very detailed logging. Used for information that might be helpful to
     * debug the application. It has the lowest priority.
     */
    TRACE(1),
    
    /**
     * Debug level for less detailed logging than trace. Used for information that is useful
     * for debugging during development. It has a higher priority than TRACE.
     */
    DEBUG(2),
    
    /**
     * Info level for general application operational logging. Used for runtime information
     * about the application's progress and operations. It has a higher priority than DEBUG.
     */
    INFO(3),
    
    /**
     * Warn level for logging potential issues that are not necessarily errors but might warrant
     * investigation. It has a higher priority than INFO.
     */
    WARN(4),
    
    /**
     * Error level for logging errors and exceptions that might disrupt normal operations.
     * It has the highest priority.
     */
    ERROR(5);

    final int level;
    
    /**
     * Constructs a new {@code LogLevel} with the specified level.
     * 
     * @param level The priority level of the log level.
     */
    LogLevel(int level) {
        this.level = level;
    }
}
