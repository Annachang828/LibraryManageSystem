package com.algonquin.cst8288.assignment2.event;

/**
 * File name: EventFactory.java 
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
 * Abstract factory class for creating events in the Library Management System.
 * This class declares a method for creating {@link Event} objects based on specified event types.
 * Subclasses of {@code EventFactory} must implement the {@code createEvent} method to return specific {@code Event} instances.
 */
public abstract class EventFactory {
    
    /**
     * Creates an {@link Event} object based on the specified {@code EventType}.
     * Subclasses must implement this method to provide specific implementations of {@code Event} based on the event type.
     *
     * @param type The type of the event to create, as defined by {@link EventType}.
     * @return An instance of {@link Event} corresponding to the specified type.
     */
    public abstract Event createEvent(EventType type);
    
    
}
