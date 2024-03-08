package com.algonquin.cst8288.assignment2.event;

/**
 * File name: PublicEventFactory.java 
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
 * A factory class for creating public library events.
 * This class is a concrete implementation of the {@link EventFactory} abstract class.
 * It provides the functionality to create events specifically designed for public libraries,
 * such as Movie Night and Kids Story events.
 */
public class PublicEventFactory extends EventFactory {
    
    /**
     * Creates an event based on the specified type.
     * This method overrides the abstract {@code createEvent} method in the parent {@link EventFactory} class.
     * It supports creating events of types {@link EventType#MOVIE_NIGHT} and {@link EventType#KIDS_STORY}.
     * 
     * @param type The type of the event to create, as defined in {@link EventType}.
     * @return An instance of {@link Event} corresponding to the given type.
     * @throws IllegalArgumentException If the given event type is not supported by this factory.
     */
    @Override
    public Event createEvent(EventType type){
        
        switch(type) {
            case MOVIE_NIGHT:
                return new MovieNightEvent();
            case KIDS_STORY:
                return new KidsStoryEvent();
            default:
                throw new IllegalArgumentException("Event type is not supported.");
        }
        
    }
    
}
