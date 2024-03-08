package com.algonquin.cst8288.assignment2.event;

import static com.algonquin.cst8288.assignment2.constants.Constants.WORKSHOP_DURATION;
import static com.algonquin.cst8288.assignment2.constants.Constants.WORKSHOP_RATE;

/**
 * File name: WorkshopEvent.java 
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
 * Represents a workshop event in an academic library context.
 * This class extends the {@link Event} abstract class and specifies details for a workshop,
 * including its name, description, activities, and admission fee calculation based on predefined rates and duration.
 */
public class WorkshopEvent extends Event {
    
    /**
     * Constructs a new WorkshopEvent with predefined details.
     * Sets the event's name to "Workshop" and defines its description and activities.
     * The admission fee is calculated based on constants {@code WORKSHOP_DURATION} and {@code WORKSHOP_RATE}.
     */
    public WorkshopEvent() {
        this.eventName = "Workshop";
        this.eventDescription = "A specialized session designed to enhance skills and knowledge in a particular academic field.";
        this.eventActivities = "Expert lectures, hands-on exercises, group discussions, and networking opportunities.";
    }
    
    /**
     * Calculates and sets the admission fee for the workshop event.
     * The fee is determined by multiplying the {@code WORKSHOP_DURATION} by the {@code WORKSHOP_RATE},
     * both of which are defined in {@link com.algonquin.cst8288.assignment2.constants.Constants}.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = WORKSHOP_DURATION * WORKSHOP_RATE;
    }
    
}
