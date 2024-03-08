package com.algonquin.cst8288.assignment2.event;

import static com.algonquin.cst8288.assignment2.constants.Constants.BOOK_LAUNCH_DURATION;
import static com.algonquin.cst8288.assignment2.constants.Constants.BOOK_LAUNCH_RATE;

/**
 * File name: BookLaunchEvent.java 
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
 * The {@code BookLaunchEvent} class represents a book launch event within the Library Management System.
 * It extends the {@link Event} class and specifies the details and admission fee calculation for a book launch event.
 */
public class BookLaunchEvent extends Event {
    
    /**
     * Constructs a new {@code BookLaunchEvent} with predefined details specific to a book launch event.
     * Initializes the event name, description, and activities with information relevant to a book launch.
     */
    public BookLaunchEvent() {
        this.eventName = "Book Launch";
        this.eventDescription = "A celebratory event marking the release of a new book, featuring the author and their work.";
        this.eventActivities = "Reading excerpts, author Q&A session, book signing, mingling with guests, and light refreshments.";
    }
    
    /**
     * Calculates and sets the admission fee for the book launch event based on predefined rates and duration.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = BOOK_LAUNCH_DURATION * BOOK_LAUNCH_RATE;
    }
    
}
