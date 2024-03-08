package com.algonquin.cst8288.assignment2.constants;

/**
 * File name: Constants.java 
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
 * The {@code Constants} class defines the duration and cost rates for various event types
 * within the Library Management System. These constants are utilized to calculate
 * the admission fees for different types of library events.
 */
public final class Constants {
	
        /** The duration of a workshop event in hours. */
	public static final double WORKSHOP_DURATION = 1.5;
        
        /** The duration of a kids' storytime event in hours. */    
	public static final double KIDS_STORYTIME_DURATION = 1.0;
        
        /** The duration of a movie night event in hours. */
	public static final double MOVIE_NIGHT_DURATION = 2.5;
        
        /** The duration of a book launch event in hours. */
	public static final double BOOK_LAUNCH_DURATION = 2;
	
        /** The cost rate per hour for a workshop event. */
	public static final double WORKSHOP_RATE = 10.0;
        
        /** The cost rate per hour for a kids' storytime event. */
	public static final double KIDS_STORYTIME_RATE = 3.0;
        
        /** The cost rate per hour for a movie night event. */
	public static final double MOVIE_NIGHT_RATE = 3.0;
        
        /** The cost rate per hour for a book launch event. */
        public static final double BOOK_LAUNCH_RATE = 5.0;
	
}
