import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * File name: LMSLoggerTest.java 
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
 * Test class for {@link LMSLogger}. It verifies the Singleton pattern implementation,
 * and the functionality of logging messages and exceptions to a log file.
 */
public class LMSLoggerTest {

    private final String logFile = "LMSLog.txt";
    private LMSLogger logger;
    
    /**
     * Sets up the test environment before each test method.
     * Initializes the {@link LMSLogger} instance and ensures the log file does not exist.
     * @throws Exception if an error occurs during setup.
     */
    @Before
    public void setUp() throws Exception {
        logger = LMSLogger.getInstance();
        Files.deleteIfExists(Paths.get(logFile));
    }

    /**
     * Cleans up the test environment after each test method.
     * Deletes the log file to ensure a clean state for subsequent tests.
     * @throws Exception if an error occurs during teardown.
     */
    @After
    public void tearDown() throws Exception {
        Files.deleteIfExists(Paths.get(logFile));
    }
    
    /**
     * Tests that {@link LMSLogger#getInstance()} method returns the same instance of {@link LMSLogger}
     * on multiple calls, confirming the Singleton pattern.
     */
    @Test
    public void testGetInstance() {
        LMSLogger anotherLogger = LMSLogger.getInstance();
        assertNotNull(logger);
        assertSame("LMSLogger should return the same instance for multiple calls.", logger, anotherLogger);
    }
    
    /**
     * Tests the {@link LMSLogger#log(LogLevel, String)} method to ensure it correctly logs a message
     * to the log file.
     * @throws FileNotFoundException if the log file is not found.
     */
    @Test
    public void testLog() throws FileNotFoundException {
        String testMessage = "Test log message";
        logger.log(LogLevel.INFO, testMessage);
        assertTrue("Log file should contain the test log message.", checkLogFileContains(testMessage));
    }

    /**
     * Tests the {@link LMSLogger#logException(LogLevel, String, Exception)} method to ensure it correctly logs
     * an exception's message and details to the log file.
     * @throws FileNotFoundException if the log file is not found.
     */
    @Test
    public void testLogException() throws FileNotFoundException {
        String testMessage = "Test exception message";
        Exception testException = new Exception("Test exception");
        logger.logException(LogLevel.ERROR, testMessage, testException);
        assertTrue("Log file should contain the test exception message.", checkLogFileContains(testMessage));
        assertTrue("Log file should contain the test exception details.", checkLogFileContains("Test exception"));
    }

    /**
     * Helper method to check if the log file contains a specific message.
     * @param message The message to search for in the log file.
     * @return {@code true} if the message is found, {@code false} otherwise.
     * @throws FileNotFoundException if the log file is not found.
     */ 
    private boolean checkLogFileContains(String message) throws FileNotFoundException {
        File file = new File(logFile);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().contains(message)) {
                    return true;
                }
            }
        }
        return false;
    }
}