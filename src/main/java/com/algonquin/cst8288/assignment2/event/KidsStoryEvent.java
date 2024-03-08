package com.algonquin.cst8288.assignment2.event;

import static com.algonquin.cst8288.assignment2.constants.Constants.KIDS_STORYTIME_DURATION;
import static com.algonquin.cst8288.assignment2.constants.Constants.KIDS_STORYTIME_RATE;

/**
 * File name: KidsStoryEvent.java 
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
 * Represents a Kid Story Time event within the Library Management System.
 * This class extends {@link Event} to provide specific implementations for kids' storytelling sessions,
 * including setting up the event's name, description, and activities. The admission fee is calculated
 * based on predefined constants for duration and rate specific to Kid Story Time events.
 */
public class KidsStoryEvent extends Event{
    
    /**
     * Constructs a new Kid Story Time event with predefined name, description, and activities.
     * The admission fee is not set in the constructor but calculated later based on the event's duration and rate.
     */
    public KidsStoryEvent() {
        this.eventName = "Kid Story Time";
        this.eventDescription = "An engaging storytelling session for children.";
        this.eventActivities = "Interactive storytelling, character play, and fun quizzes.";
    }
    
    /**
     * Calculates and sets the admission fee for the Kid Story Time event.
     * The fee is determined by multiplying the predefined duration and rate constants specific to Kid Story Time events.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = KIDS_STORYTIME_DURATION * KIDS_STORYTIME_RATE;
    }
    
}
