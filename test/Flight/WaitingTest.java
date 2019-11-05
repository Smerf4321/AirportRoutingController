/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import Planes.PassengerPlane;
import airportroutingcontroller.Bays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author v8243060
 */
public class WaitingTest {
    
    public WaitingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of arriving method, of class Waiting when bay is available
     */
    @Test
    public void testArrivingSuccess() {
        System.out.println("arrivingSuccess");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        Waiting instance = new Waiting();
        instance.arriving(flight);
        assertEquals("1", flight.testOutput);
    }
    
    /**
     * Test of arriving method, of class Waiting when bay isn't available
     */
    @Test
    public void testArrivingFailure() {
        System.out.println("arrivingFailure");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        Waiting instance = new Waiting();
        Bays.changeBayTest();
        instance.arriving(flight);
        assertEquals("0", flight.testOutput);
    }

    /**
     * Test of departing method, of class Waiting when a runway is available
     */
    @Test
    public void testDepartingSuccess() {
        System.out.println("departingSuccess");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        Waiting instance = new Waiting();
        flight.giveClearance();
        instance.departing(flight);
        assertEquals("1", flight.testOutput);
    }
    
    /**
     * Test of departing method, of class Waiting when a runway isn't available
     */
    @Test
    public void testDepartingFailure() {
        System.out.println("departingFailure");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        Waiting instance = new Waiting();
        flight.revokeClearance();
        instance.departing(flight);
        assertEquals("0", flight.testOutput);
    }
}
