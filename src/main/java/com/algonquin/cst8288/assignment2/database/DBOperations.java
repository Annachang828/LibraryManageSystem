package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.BookLaunchEvent;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.KidsStoryEvent;
import com.algonquin.cst8288.assignment2.event.MovieNightEvent;
import com.algonquin.cst8288.assignment2.event.WorkshopEvent;
import java.sql.*;

/**
 * File name: DBOperations.java 
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
 * The {@code DBOperations} class provides static methods to perform database operations related to events,
 * including creating, retrieving, updating, and deleting events in the Library Management System.
 */
public class DBOperations {

    /**
     * Inserts a new event into the database.
     *
     * @param event The event to be created in the database.
     */
    public static void createEvent(Event event) {
        String sql = "INSERT INTO events (event_name, event_description, event_activities, admission_fees) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, event.getEventName());
            pstmt.setString(2, event.getEventDescription());
            pstmt.setString(3, event.getEventActivities());
            pstmt.setDouble(4, event.getAdmissionFees());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Retrieves an event from the database based on the event ID.
     *
     * @param event_id The ID of the event to retrieve.
     * @return An instance of {@link Event} representing the retrieved event, or {@code null} if the event was not found.
     */
    public static Event retrieveEvent(int event_id) {
        Event event = null;
        String sql = "SELECT * FROM events WHERE event_id = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) { 
            pstmt.setInt(1, event_id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String eventName = rs.getString("event_name");

                if (eventName.equals("MovieNight")) {
                    event = new MovieNightEvent();
                } else if (eventName.equals("Workshop")) {
                    event = new WorkshopEvent();
                } else if (eventName.equals("Kid Story Time")) {
                    event = new KidsStoryEvent();
                } else {
                    event = new BookLaunchEvent();
                } 

                event.setEventName(rs.getString("event_name"));
                event.setEventDescription(rs.getString("event_description"));
                event.setEventActivities(rs.getString("event_activities"));
                event.setAdmissionFees(rs.getDouble("admission_fees"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return event;
    }

    /**
     * Updates an existing event in the database with the details of the provided {@link Event} instance.
     *
     * @param event The event containing the updated details.
     * @param event_id The ID of the event to update.
     */
    public static void updateEvent(Event event, int event_id) {
        String sql = "UPDATE events SET event_name = ?, event_description = ?, event_activities = ?, admission_fees = ? WHERE event_id = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, event.getEventName());
            pstmt.setString(2, event.getEventDescription());
            pstmt.setString(3, event.getEventActivities());
            pstmt.setDouble(4, event.getAdmissionFees());
            pstmt.setInt(5, event_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    /**
     * Deletes an event from the database based on the event ID.
     *
     * @param event_id The ID of the event to delete.
     */
    public static void deleteEvent(int event_id) {
        String sql = "DELETE FROM events WHERE event_id = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, event_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
