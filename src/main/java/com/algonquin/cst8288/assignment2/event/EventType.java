package com.algonquin.cst8288.assignment2.event;

/**
 * File name: EventType.java 
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
 * Represents the types of events that can be created in the Library Management System.
 * This enumeration defines the specific categories of events that the system can handle, including
 * both public and academic library events.
 */
public enum EventType {
    
    /**
    * Represents a storytelling event specifically designed for children.
    * These events typically involve reading stories aloud, often with interactive elements
    * to engage the young audience.
    */
    KIDS_STORY,
    
    /**
    * Represents a movie screening event open to the public.
    * Movie nights may feature films of various genres and are usually intended for entertainment
    * and community engagement.
    */
    MOVIE_NIGHT,
    
    
    /**
    * Represents an academic workshop event.
    * Workshops are designed to provide in-depth learning experiences on specific topics,
    * often involving hands-on activities and expert presentations.
    */
    WORKSHOP,
    
    /**
    * Represents a book launch event.
    * These events celebrate the release of new books, often featuring the author(s),
    * readings from the book, Q&A sessions, and book signings.
    */
    BOOK_LAUNCH
}
