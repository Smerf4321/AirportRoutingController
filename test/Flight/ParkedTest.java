/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import Planes.PassengerPlane;
import airportroutingcontroller.Runways;
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
public class ParkedTest {
    
    public ParkedTest() {
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
     * Test of readyCheck method, of class Parked when at destination with passengers on-board
     */
    @Test
    public void testReadyCheckAtDestinationWithPassengers() {
        System.out.println("readyCheck");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 10, 20, false, 40, true, States.INFLIGHT, "London");
        Parked instance = new Parked();
        instance.readyCheck(flight);
        assertEquals("PO", flight.testOutput);
    }
    
    /**
     * Test of readyCheck method, of class Parked when at destination with
     * no passengers and low fuel
     */
    @Test
    public void testReadyCheckAtDestinationWithLowFuel() {
        System.out.println("readyCheck");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        Parked instance = new Parked();
        instance.readyCheck(flight);
        assertEquals("F", flight.testOutput);
       
    }
    
    /**
     * Test of readyCheck method, of class Parked when at destination with
     * no passengers, high fuel and no supplies
     */
    @Test
    public void testReadyCheckAtDestinationWithLowSupplies() {
        System.out.println("readyCheck");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 80, true, States.INFLIGHT, "London");
        Parked instance = new Parked();
        instance.readyCheck(flight);
        assertEquals("S", flight.testOutput);
       
    }

     /**
     * Test of readyCheck method, of class Parked when at destination with
     * no passengers, high fuel and supplies
     */
    @Test
    public void testReadyCheckAtDestinationWithNoNeeds() {
        System.out.println("readyCheck");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, true, 80, true, States.INFLIGHT, "London");
        Parked instance = new Parked();
        instance.readyCheck(flight);
        assertEquals("1", flight.testOutput);
    }
    
    /**
     * Test of readyCheck method, of class Parked when not at destination with passengers booked
     */
    @Test
    public void testReadyCheckNotAtDestinationWithPassengersBooked() {
        System.out.println("readyCheck");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "Paris");
        Parked instance = new Parked();
        instance.readyCheck(flight);
        assertEquals("PB", flight.testOutput);
    }
    
    /**
     * Test of readyCheck method, of class Parked when not at destination with
     * no passengers booked and low fuel
     */
    @Test
    public void testReadyCheckNotAtDestinationWithLowFuel() {
        System.out.println("readyCheck");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 0, false, 40, true, States.INFLIGHT, "Paris");
        Parked instance = new Parked();
        instance.readyCheck(flight);
        assertEquals("F", flight.testOutput);
       
    }
    
    /**
     * Test of readyCheck method, of class Parked when not at destination with
     * no passengers booked, high fuel and no supplies
     */
    @Test
    public void testReadyCheckNotAtDestinationWithLowSupplies() {
        System.out.println("readyCheck");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 0, false, 80, true, States.INFLIGHT, "Paris");
        Parked instance = new Parked();
        instance.readyCheck(flight);
        assertEquals("S", flight.testOutput);
       
    }

     /**
     * Test of readyCheck method, of class Parked when at destination with
     * no passengers booked, high fuel and supplies
     */
    @Test
    public void testReadyCheckNotAtDestinationWithNoNeeds() {
        System.out.println("readyCheck");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 0, true, 80, true, States.INFLIGHT, "Paris");
        Parked instance = new Parked();
        instance.readyCheck(flight);
        assertEquals("1", flight.testOutput);
    }

    /**
     * Test of departing method, of class Parked when a runway is available
     */
    @Test
    public void testDepartingSucces() {
        System.out.println("departing");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        Parked instance = new Parked();
        assertTrue(instance.departing(flight));
    }
    
    /**
     * Test of departing method, of class Parked when a runway isn't available
     */
    @Test
    public void testDepartingFailure() {
        System.out.println("departing");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        Parked instance = new Parked();
        Runways.changeRunwayTest();
        assertFalse(instance.departing(flight));
    }
    
    /**
     * Tests the arriving method, which should return an error
     */
    @Test
    public void testArriving() {
        System.out.println("arriving");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        Parked instance = new Parked();
        assertFalse(instance.arriving(flight));
    }
}
