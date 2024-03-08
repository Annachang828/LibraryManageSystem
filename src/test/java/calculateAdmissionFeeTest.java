import static com.algonquin.cst8288.assignment2.constants.Constants.*;
import com.algonquin.cst8288.assignment2.event.*;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 * File name: calculateAdmissionFeeTest.java 
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
 * This class contains JUnit tests for testing the calculation of admission fees for different event types.
 * It tests the {@link Event#calculateAdmissionFee()} method across various event types to ensure correct calculation
 * based on predefined duration and rate constants.
 */
public class calculateAdmissionFeeTest {
    
    /**
     * Test the admission fee calculation for a KidsStoryEvent.
     * Asserts that the calculated admission fee matches the expected value
     * based on the constants {@link Constants#KIDS_STORYTIME_DURATION} and {@link Constants#KIDS_STORYTIME_RATE}.
     */
    @Test
    public void testKidsStoryEventAdmissionFee() {
        Event kidsStoryEvent = new KidsStoryEvent();
        kidsStoryEvent.calculateAdmissionFee();
        assertEquals(KIDS_STORYTIME_DURATION * KIDS_STORYTIME_RATE, kidsStoryEvent.getAdmissionFees());
    }
    
    /**
     * Test the admission fee calculation for a MovieNightEvent.
     * Asserts that the calculated admission fee matches the expected value
     * based on the constants {@link Constants#MOVIE_NIGHT_DURATION} and {@link Constants#MOVIE_NIGHT_RATE}.
     */
    @Test
    public void testMovieNightEventAdmissionFee() {
        Event movieNightEvent = new MovieNightEvent();
        movieNightEvent.calculateAdmissionFee();
        assertEquals(MOVIE_NIGHT_DURATION * MOVIE_NIGHT_RATE, movieNightEvent.getAdmissionFees());
    }

    /**
     * Test the admission fee calculation for a WorkshopEvent.
     * Asserts that the calculated admission fee matches the expected value
     * based on the constants {@link Constants#WORKSHOP_DURATION} and {@link Constants#WORKSHOP_RATE}.
     */
    @Test
    public void testWorkshopEventAdmissionFee() {
        Event workshopEvent = new WorkshopEvent();
        workshopEvent.calculateAdmissionFee();
        assertEquals(WORKSHOP_DURATION * WORKSHOP_RATE, workshopEvent.getAdmissionFees());
    }

    /**
     * Test the admission fee calculation for a BookLaunchEvent.
     * Asserts that the calculated admission fee matches the expected value
     * based on the constants {@link Constants#BOOK_LAUNCH_DURATION} and {@link Constants#BOOK_LAUNCH_RATE}.
     */
    @Test
    public void testBookLaunchEventAdmissionFee() {
        Event bookLaunchEvent = new BookLaunchEvent();
        bookLaunchEvent.calculateAdmissionFee();
        assertEquals(BOOK_LAUNCH_DURATION * BOOK_LAUNCH_RATE, bookLaunchEvent.getAdmissionFees());
    }
    
}
