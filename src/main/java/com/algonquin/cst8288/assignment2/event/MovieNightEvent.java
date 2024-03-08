package com.algonquin.cst8288.assignment2.event;

import static com.algonquin.cst8288.assignment2.constants.Constants.MOVIE_NIGHT_DURATION;
import static com.algonquin.cst8288.assignment2.constants.Constants.MOVIE_NIGHT_RATE;

/**
 * File name: MovieNightEvent.java 
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
 * Represents a Movie Night event within the Library Management System.
 * This class is a specific implementation of an {@link Event}, tailored for hosting movie screenings.
 * It defines the event's name, description, and activities suitable for a community gathering to enjoy films together.
 * The admission fee for the event is calculated based on predefined constants for duration and rate specific to Movie Night events.
 */
public class MovieNightEvent extends Event {
    
    /**
     * Constructs a new Movie Night event with a predefined name, description, and activities.
     * The specifics of this event cater to a communal film-watching experience, including interactions and refreshments.
     */
    public MovieNightEvent() {
        this.eventName = "MovieNight";
        this.eventDescription = "A community gathering to watch and enjoy a featured film.";
        this.eventActivities = "Screening of a popular or classic movie, discussion and interaction, popcorn and refreshments.";
    }
    
    /**
     * Calculates and sets the admission fee for the Movie Night event.
     * The fee is determined by multiplying the predefined duration and rate constants specific to Movie Night events.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = MOVIE_NIGHT_DURATION * MOVIE_NIGHT_RATE;
    }
    
}
