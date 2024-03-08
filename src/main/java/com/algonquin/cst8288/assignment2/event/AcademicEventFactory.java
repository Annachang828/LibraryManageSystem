package com.algonquin.cst8288.assignment2.event;

/**
 * File name: AcademicEventFactory.java 
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
 * The {@code AcademicEventFactory} class is an implementation of the {@link EventFactory} abstract class,
 * specifically for creating events associated with academic libraries. It overrides the {@code createEvent} method
 * to return specific types of events based on the {@link EventType}.
 */
public class AcademicEventFactory extends EventFactory {
    
    /**
     * Creates and returns an {@link Event} object based on the specified {@link EventType}.
     * This method specifically handles event types related to academic libraries, such as workshops and book launches.
     *
     * @param type The type of the event to create. Supported types are {@link EventType#WORKSHOP} and {@link EventType#BOOK_LAUNCH}.
     * @return An {@link Event} object corresponding to the specified type.
     * @throws IllegalArgumentException if the event type is not supported by this factory.
     */
    @Override
    public Event createEvent(EventType type){
        
        switch(type) {
            case WORKSHOP:
                return new WorkshopEvent();
            case BOOK_LAUNCH:
                return new BookLaunchEvent();
            default:
                throw new IllegalArgumentException("Event type is not supported.");
        }
        
    }
    
}
