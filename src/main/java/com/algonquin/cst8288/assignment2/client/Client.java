package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.*;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;
import java.util.Scanner;

/**
 * File name: Client.java 
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
 * The {@code Client} class serves as the entry point for the Library Management System application.
 * It provides a console-based user interface for authenticating users and performing CRUD operations on library events.
 * Upon launching, the application prompts the user to log in. Once authenticated, it offers a menu of options for creating, retrieving, updating, and deleting library events.
 * The application supports events for both public and academic libraries, each with specific event types.
 *
 */
public class Client {
    
	private static LMSLogger logger = LMSLogger.getInstance();
        private static Scanner scan = new Scanner(System.in);
        private static boolean flag = true;
  
        /**
        * The main method starts the application, handles user authentication, and displays the main menu.
        * @param args Command-line arguments (not used).
        */
	public static void main(String[] args) {
		
            logger.log(LogLevel.INFO, "LMS application started. Please log in.");
            authenticateUser();
            do {
                menu();
            } while (flag);
	}
        
        /**
        * Prompts the user for username and password, authenticating against predefined credentials.
        * If authentication succeeds, it logs the successful login and welcomes the user; otherwise, it logs the failed attempt and displays an error message.
        */
        private static void authenticateUser() {
            System.out.print("Enter username: ");
            String userName = scan.nextLine();
            System.out.print("Enter password: ");
            String password = scan.nextLine();
            
            if ("admin".equals(userName) && "admin".equals(password)) {
                logger.log(LogLevel.INFO, userName + " logged in successfully.");
                System.out.println("Welcome. " + userName);
            } else {
                logger.log(LogLevel.ERROR, userName + " login failed.");
                System.out.println("Login failed. Please check your username and password.");
            }
        }
        
        /**
        * Displays the main menu with options for creating, retrieving, updating, deleting library events, and logging out.
        * Directs the flow based on the user's choice.
        */
        private static void menu() {
            
            System.out.println("\n1. Creating 2. Retrieving 3. Updating 4. Deleting. 5. Logout");
            System.out.print("Choose 1-5 to preoceed: ");
            int menuChoice = scan.nextInt();
            scan.nextLine();
            
            switch (menuChoice) {
                case 1:
                    createLibraryEvents();
                    break;
                case 2:
                    retrieveLibraryEvents();
                    break;
                case 3:
                    updateLibraryEvents();
                    break;
                case 4:
                    deleteLibraryEvents();
                    break;
                case 5:
                    flag = false;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.print("Invalid option. ");
                    break;
            }
                     
            
        }
        
        /**
        * Presents the user with options to create events for either Public or Academic libraries,
        * and handles the creation of these events based on user input.
        * After creating an event, it calculates the admission fee, creates the event in the database,
        * and prints the event details.
        */
        private static void createLibraryEvents() {
        
            Event event = null;
            
            System.out.println("\nTypes of library:");
            System.out.println("1. Public Library");
            System.out.println("2. Academic Library");
            System.out.print("Enter your choice: ");
            
            int libraryChoice = scan.nextInt();
            scan.nextLine();
            
            if (libraryChoice == 1) {
                EventFactory publicFactory = new PublicEventFactory();
                
                    System.out.println("\nTypes of Event:");
                    System.out.println("1. Movie Night");
                    System.out.println("2. Kids Story");
                    System.out.print("Enter your choice: ");
                    
                    int eventChoice = scan.nextInt();
                    
                    if (eventChoice == 1) {
                        event = publicFactory.createEvent(EventType.MOVIE_NIGHT);
                    } else {
                        event = publicFactory.createEvent(EventType.KIDS_STORY);
                    }
                    
            } else if (libraryChoice == 2) {
                    EventFactory academicFactory = new AcademicEventFactory();
                
                    System.out.println("\nTypes of Event:");
                    System.out.println("1. Workshop");
                    System.out.println("2. Book Launch");
                    System.out.print("Enter your choice: ");
                    
                    int eventChoice = scan.nextInt();
                    
                    if (eventChoice == 1) {
                        event = academicFactory.createEvent(EventType.WORKSHOP);

                    } else {
                        event = academicFactory.createEvent(EventType.BOOK_LAUNCH);
                    }
      
            }
            event.calculateAdmissionFee();
            DBOperations.createEvent(event);
            printEvent(event);
        }
        
        /**
        * Prompts the user to enter an event ID to retrieve, retrieves the event from the database,
        * and if found, prints the retrieved event's details.
        */
        private static void retrieveLibraryEvents() {
            System.out.print("Retrieve Event ID: ");
            int eventId = scan.nextInt();
            scan.nextLine();
            
            Event retrievedEvent = DBOperations.retrieveEvent(eventId);
            
            if(retrievedEvent != null) {
                    printEvent(retrievedEvent);
                }
        }
        
        /**
        * Allows the user to update the activities of an existing event in the database.
        * It prompts the user for an event ID, retrieves the corresponding event, updates its activities,
        * saves the updates in the database, and then prints the updated event details.
        */
        private static void updateLibraryEvents() {
            System.out.print("Update Event ID: ");
            int eventId = scan.nextInt();
            scan.nextLine();
            
            Event retrievedEvent = DBOperations.retrieveEvent(eventId);    
            
            if(retrievedEvent != null) {
                    retrievedEvent.setEventActivities("Free drink during the activity.");
                    DBOperations.updateEvent(retrievedEvent, eventId);
                    printEvent(retrievedEvent);
                }
        }
        
        /**
        * Prompts the user for an event ID and attempts to delete the corresponding event from the database.
        * If successful, it confirms the deletion to the user.
        */
        private static void deleteLibraryEvents() {
            System.out.print("Delete Event ID: ");
            int eventId = scan.nextInt();
            scan.nextLine();
            
            Event retrievedEvent = DBOperations.retrieveEvent(eventId);    
            
            if(retrievedEvent != null) {
                    DBOperations.deleteEvent(eventId);
                }
        }
        
        /**
        * Prints the details of a given event, including its name, description, activities, and admission fees.
        * @param event The event whose details are to be printed.
        */
        private static void printEvent(Event event) {
            System.out.println("\n" + event.getEventName() + ": " + event.getEventDescription() + "\n"
                                + event.getEventActivities() + "\nAdmission Fees: " + event.getAdmissionFees());
        }
        
}
