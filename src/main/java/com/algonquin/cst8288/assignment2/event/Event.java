package com.algonquin.cst8288.assignment2.event;

/**
 * File name: Event.java 
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
 * Represents a generic event within the Library Management System.
 * This abstract class provides the foundation for specific types of events, detailing their names, descriptions,
 * activities, and admission fees. Subclasses are expected to implement the calculation of admission fees.
 */
public abstract class Event {
    	
    protected String eventName;
    protected String eventDescription;
    protected String eventActivities;
    protected double admissionFees;
    
    /**
     * Constructs an empty Event with no details initialized.
     */
    public Event() {}
    
    /**
     * Gets the name of the event.
     * 
     * @return The name of the event.
     */
    public String getEventName() {
            return eventName;
    }

    /**
     * Sets the name of the event.
     * 
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
            this.eventName = eventName;
    }

    /**
     * Gets the description of the event.
     * 
     * @return The description of the event.
     */
    public String getEventDescription() {
            return eventDescription;
    }

    /**
     * Sets the description of the event.
     * 
     * @param eventDescription The description to set for the event.
     */
    public void setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
    }

    /**
     * Gets the activities associated with the event.
     * 
     * @return The activities of the event.
     */
    public String getEventActivities() {
            return eventActivities;
    }

    /**
     * Sets the activities associated with the event.
     * 
     * @param eventActivities The activities to set for the event.
     */
    public void setEventActivities(String eventActivities) {
            this.eventActivities = eventActivities;
    }

    /**
     * Gets the admission fees for the event.
     * 
     * @return The admission fees of the event.
     */
    public double getAdmissionFees() {
            return admissionFees;
    }

    /**
     * Sets the admission fees for the event.
     * 
     * @param admissionFees The admission fees to set for the event.
     */
    public void setAdmissionFees(double admissionFees) {
            this.admissionFees = admissionFees;
    }

    /**
     * An abstract method that subclasses must implement to calculate and set the admission fees for the event.
     */
    public abstract void calculateAdmissionFee();
    
    
}
