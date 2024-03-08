import com.algonquin.cst8288.assignment2.database.DBConnection;
import java.sql.Connection;
import org.junit.Assert;
import org.junit.Test;

/**
 * File name: DBConnectionTest.java 
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
 * This class contains JUnit tests for the {@link DBConnection} class.
 * It verifies the implementation of the Singleton pattern and the ability
 * to obtain a non-null database connection.
 */
public class DBConnectionTest {
    
    /**
     * Tests that {@link DBConnection} correctly implements the Singleton design pattern.
     * It checks if multiple calls to {@link DBConnection#getInstance()} return the same instance.
     * Ensures that the instance is not null and that both instances obtained are exactly the same.
     */
    @Test
    public void testSingletonInstance() {
        DBConnection instance1 = DBConnection.getInstance();
        DBConnection instance2 = DBConnection.getInstance();

        Assert.assertNotNull("Instance should not be null", instance1);
        Assert.assertSame("Instances should be the same", instance1, instance2);
    }

    /**
     * Tests that the connection obtained from {@link DBConnection#getInstance()} is not null.
     * This test ensures that {@link DBConnection#getConnection()} can establish a connection,
     * although it does not interact with the database directly. It's a basic validation
     * to ensure that the connection object is successfully created.
     */    
    @Test
    public void testConnectionNotNull() {
        DBConnection instance = DBConnection.getInstance();
        Connection conn = instance.getConnection();
        Assert.assertNotNull("Connection should not be null", conn);
    }
    
}
